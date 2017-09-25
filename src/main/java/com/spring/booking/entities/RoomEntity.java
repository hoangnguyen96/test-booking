package com.spring.booking.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by PC on 09/20/17.
 */
@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "roomId")
    private List<BookingDetailsEntity> bookingDetailsEntityList;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "RoomTypeId")
    private RoomTypeEntity roomTypeId;

    @Column(name = "Description")
    private String description;

    @Column(name = "AdultPrice")
    private float adultPrice;

    @Column(name = "ChildrenPrice")
    private float childrenPrice;

    @Column(name = "Sale")
    private int sale;

    @Column(name = "Status")
    private String status;

    @Column(name = "Note")
    private String note;

    public RoomEntity() {
    }

    public RoomEntity(List<BookingDetailsEntity> bookingDetailsEntityList, String name, RoomTypeEntity roomTypeId, String description, float adultPrice, float childrenPrice, int sale, String status, String note) {
        this.bookingDetailsEntityList = bookingDetailsEntityList;
        this.name = name;
        this.roomTypeId = roomTypeId;
        this.description = description;
        this.adultPrice = adultPrice;
        this.childrenPrice = childrenPrice;
        this.sale = sale;
        this.status = status;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BookingDetailsEntity> getBookingDetailsEntityList() {
        return bookingDetailsEntityList;
    }

    public void setBookingDetailsEntityList(List<BookingDetailsEntity> bookingDetailsEntityList) {
        this.bookingDetailsEntityList = bookingDetailsEntityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomTypeEntity getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(RoomTypeEntity roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(float adultPrice) {
        this.adultPrice = adultPrice;
    }

    public float getChildrenPrice() {
        return childrenPrice;
    }

    public void setChildrenPrice(float childrenPrice) {
        this.childrenPrice = childrenPrice;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
