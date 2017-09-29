package com.spring.booking.repository;

import com.spring.booking.entities.RoomEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by PC on 09/20/17.
 */
@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Integer> {
    @Query(value = "select r.name from room as r join bookingdetails as b on b.id = r.id join roomtype as t on t.id = r.id where b.DateCheckIn >= ?1 and b.DateCheckOut >= ?2 and r.RoomTypeId = ?3", nativeQuery = true)
    List<RoomEntity> findByAvailableRoom(String date1, String date2, int type );
}
