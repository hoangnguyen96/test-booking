package com.spring.booking.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by PC on 09/20/17.
 */
@Entity
@Table(name = "roomtype")
public class RoomTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "roomTypeId")
    private List<RoomEntity> roomEntityList;

    @Column(name = "Name")
    private String name;

    @Column(name = "BedQuantity")
    private int bedQuantity;

    @Column(name = "Cost")
    private float cost;

    public RoomTypeEntity() {
    }

    public RoomTypeEntity(List<RoomEntity> roomEntityList, String name, int bedQuantity, float cost) {
        this.roomEntityList = roomEntityList;
        this.name = name;
        this.bedQuantity = bedQuantity;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<RoomEntity> getRoomEntityList() {
        return roomEntityList;
    }

    public void setRoomEntityList(List<RoomEntity> roomEntityList) {
        this.roomEntityList = roomEntityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBedQuantity() {
        return bedQuantity;
    }

    public void setBedQuantity(int bedQuantity) {
        this.bedQuantity = bedQuantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
