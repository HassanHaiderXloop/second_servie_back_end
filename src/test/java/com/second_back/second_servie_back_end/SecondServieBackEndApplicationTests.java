package com.second_back.second_servie_back_end;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.second_back.second_servie_back_end.Entity.Cart;
import com.second_back.second_servie_back_end.Repository.CartRepository;

// @SpringBootTest
class SecondServieBackEndApplicationTests {

	@Mock
	private CartRepository cartRepository;

	@Test
	void contextLoads() {
	}
	@Test
	void getAndSetCartId(){
		Cart cut = new Cart();
		Long myId = 1L;
		cut.setId(myId);
		assertEquals(myId, cut.getId());
	}
	@Test
	void getAndSetCartName(){
		Cart cut = new Cart();
		String myNmae = "Chocolate Pudding";
		cut.setName(myNmae);
		assertEquals(myNmae, cut.getName());
	}
	@Test
	void getAndSetCartShortQuantity(){
		Cart cut = new Cart();
		int myQuantity= 4;
		cut.setQuantity(myQuantity);
		assertEquals(myQuantity, cut.getQuantity());

	}
	@Test
	void getAndSetCartTotalPrice(){
		Cart cut = new Cart();
		Long myTotalPrice = 456789L;
		cut.setTotalPrice(myTotalPrice);
		assertEquals(myTotalPrice, cut.getTotalPrice());

	}
	@Test
	void getAndSetCartImage(){
		Cart cut = new Cart();
		String myImage = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ChocolatePudding.png";
		cut.setImage(myImage);
		assertEquals(myImage, cut.getImage());

	}
	@Test
	void getAndSetCartPrice(){
		Cart cut = new Cart();
		Long myPrice = 798875L;
		cut.setPrice(myPrice);
		assertEquals(myPrice, cut.getPrice());

	}
}