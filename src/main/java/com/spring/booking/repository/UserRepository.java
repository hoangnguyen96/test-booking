package com.spring.booking.repository;

import com.spring.booking.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by PC on 09/20/17.
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    public UserEntity findByEmailAndPassword(String email, String password);
    public UserEntity findByEmail(String email);
}
