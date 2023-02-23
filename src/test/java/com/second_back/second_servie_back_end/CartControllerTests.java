package com.second_back.second_servie_back_end;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
// import org.hibernate.annotations.UpdateTimestamp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.second_back.second_servie_back_end.Entity.Cart;
import com.second_back.second_servie_back_end.Repository.CartRepository;

@WebMvcTest
public class CartControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartRepository cartRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void postANewCart() throws Exception{
        Cart cart = Cart.builder()
                            .name("table")
                            .image("it's a table")
                            .quantity(1)
                            .totalPrice(54321L)
                            .price(1L)
                            .build();
        given(cartRepository.save(any(Cart.class))).willAnswer((invocation) -> invocation.getArgument(0));
        ResultActions response = mockMvc.perform(post("/cart/add")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(cart)));
        response.andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name",is(cart.getName())))
            .andExpect(jsonPath("$.image",is(cart.getImage())))
           .andExpect(jsonPath("$.quantity", is(cart.getQuantity())))
           .andExpect(jsonPath("$.totalPrice",is(cart.getTotalPrice().intValue())))
           .andExpect(jsonPath("$.price", is(cart.getPrice().intValue())));
    }

    @Test
    public void getAllTheCarts() throws Exception{
        Cart cart1 = Cart.builder()
            .name("table")
            .image("it's a table")
            .quantity(1)
            .totalPrice(1L)
            .price(1L)
            .build(); 
        Cart cart2 = Cart.builder()
            .name("table")
            .image("it's a table")
            .quantity(1)
            .totalPrice(1L)
            .price(1L)
            .build(); 
        List<Cart> carts = List.of(cart1,cart2);
        // given(cartRepository.findAll()).willReturn();
        given(cartRepository.findAll()).willReturn(carts);


        ResultActions response = mockMvc.perform(get("/cart/all"));
        
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(carts.size())));
    }


    @Test
    public void canDeleteACart() throws Exception{
        Long cartId = 1L;
        willDoNothing().given(cartRepository).deleteById(cartId);;

        ResultActions response = mockMvc.perform(delete("/cart/{id}", cartId ));

        response.andExpect(status().isOk()).andDo(print());
        verify(cartRepository,times(1)).deleteById(cartId);
    }


    @Test
    public void canDeleteAllThings(){
        willDoNothing().given(cartRepository).deleteAll();
        cartRepository.deleteAll();
        verify(cartRepository,times(1)).deleteAll();
    }

}
