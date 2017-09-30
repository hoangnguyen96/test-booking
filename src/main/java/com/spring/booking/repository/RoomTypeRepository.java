package com.spring.booking.repository;

import com.spring.booking.entities.RoomTypeEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by PC on 09/30/17.
 */
public interface RoomTypeRepository extends CrudRepository<RoomTypeEntity, Integer> {
}
