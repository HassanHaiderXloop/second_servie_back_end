package com.second_back.second_servie_back_end.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.second_back.second_servie_back_end.Entity.Cart;
import com.second_back.second_servie_back_end.Repository.CartRepository;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {
    
    @Autowired
    public CartRepository cartRepository;

    @PostMapping("/add")
    public Cart addCart(@RequestBody Cart cart){
        return cartRepository.save(cart);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cart>> getAllCart(){
        return ResponseEntity.ok().body(cartRepository.findAll());
        
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
       try{ 
        cartRepository.deleteById(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
       }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
    }
    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteCarts(){
        
       try{ 
        cartRepository.deleteAll();
        return new ResponseEntity<>(null,HttpStatus.OK);
       }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
    }


    


    
}
