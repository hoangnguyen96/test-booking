package com.spring.booking.repository;

import com.spring.booking.entities.BookingDetailsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by PC on 10/01/17.
 */
public interface BookingDetailsRepository extends CrudRepository<BookingDetailsEntity, Integer> {
}
