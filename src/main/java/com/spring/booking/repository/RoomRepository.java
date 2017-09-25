package com.spring.booking.repository;

import com.spring.booking.entities.RoomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by PC on 09/20/17.
 */
@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Integer> {
}
