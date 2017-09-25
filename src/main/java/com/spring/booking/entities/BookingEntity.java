package com.spring.booking.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by PC on 09/20/17.
 */
@Entity
@Table(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bookingId")
    private List<BookingDetailsEntity> bookingDetailsEntityList;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private UserEntity userId;

    @Column(name = "BookingDate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date bookingDate;

    @Column(name = "Scmnd")
    private String scmnd;

    @Column(name = "Name")
    private String name;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Address")
    private String address;

    @Column(name = "ticketCode")
    private String ticketCode;

    @Column(name = "Note")
    private String note;

    public BookingEntity() {
    }

    public BookingEntity(List<BookingDetailsEntity> bookingDetailsEntityList, UserEntity userId, Date bookingDate, String scmnd, String name, String phone, String address, String ticketCode, String note) {
        this.bookingDetailsEntityList = bookingDetailsEntityList;
        this.userId = userId;
        this.bookingDate = bookingDate;
        this.scmnd = scmnd;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.ticketCode = ticketCode;
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

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getScmnd() {
        return scmnd;
    }

    public void setScmnd(String scmnd) {
        this.scmnd = scmnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
