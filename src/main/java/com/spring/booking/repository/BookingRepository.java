package com.spring.booking.repository;

import com.spring.booking.entities.BookingEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by PC on 09/29/17.
 */
public interface BookingRepository extends CrudRepository<BookingEntity, Integer> {
}
