package com.second_back.second_servie_back_end.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.second_back.second_servie_back_end.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart , Long>{
    
}
