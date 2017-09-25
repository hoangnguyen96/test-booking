package com.spring.booking.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by PC on 09/20/17.
 */
@Entity
@Table(name = "bookingdetails")
public class BookingDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "BookingId")
    private BookingEntity bookingId;

    @ManyToOne
    @JoinColumn(name = "RoomId")
    private RoomEntity roomId;

    @Column(name = "DateCheckIn")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateCheckIn;

    @Column(name = "DateCheckOut")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateCheckOut;

    @Column(name = "AdultQuantity")
    private int adultQuantity;

    @Column(name = "ChildrenQuantity")
    private int childrenQuantity;

    @Column(name = "Cost")
    private float cost;

    public BookingDetailsEntity() {
    }

    public BookingDetailsEntity(BookingEntity bookingId, RoomEntity roomId, Date dateCheckIn, Date dateCheckOut, int adultQuantity, int childrenQuantity, float cost) {
        this.bookingId = bookingId;
        this.roomId = roomId;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
        this.adultQuantity = adultQuantity;
        this.childrenQuantity = childrenQuantity;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookingEntity getBookingId() {
        return bookingId;
    }

    public void setBookingId(BookingEntity bookingId) {
        this.bookingId = bookingId;
    }

    public RoomEntity getRoomId() {
        return roomId;
    }

    public void setRoomId(RoomEntity roomId) {
        this.roomId = roomId;
    }

    public Date getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(Date dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public Date getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(Date dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public int getAdultQuantity() {
        return adultQuantity;
    }

    public void setAdultQuantity(int adultQuantity) {
        this.adultQuantity = adultQuantity;
    }

    public int getChildrenQuantity() {
        return childrenQuantity;
    }

    public void setChildrenQuantity(int childrenQuantity) {
        this.childrenQuantity = childrenQuantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
