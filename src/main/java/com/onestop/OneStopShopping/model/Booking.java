package com.onestop.OneStopShopping.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingID;


    private String pickupLocation;
    private String destination;

    private LocalDateTime pickupDateTime;
    private LocalDateTime dropDateTime;

    private String bookingStatus;

    // Constructors, getters, and setters

    public Booking() {
        // Default constructor
    }

    public Booking(String pickupLocation, String destination,
                   LocalDateTime pickupDateTime, LocalDateTime dropDateTime, String bookingStatus) {

        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.pickupDateTime = pickupDateTime;
        this.dropDateTime = dropDateTime;
        this.bookingStatus = bookingStatus;
    }

    // Getters and setters for each field

    public Long getBookingID() {
        return bookingID;
    }

    public void setBookingID(Long bookingID) {
        this.bookingID = bookingID;
    }


    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getPickupDateTime() {
        return pickupDateTime;
    }

    public void setPickupDateTime(LocalDateTime pickupDateTime) {
        this.pickupDateTime = pickupDateTime;
    }

    public LocalDateTime getDropDateTime() {
        return dropDateTime;
    }

    public void setDropDateTime(LocalDateTime dropDateTime) {
        this.dropDateTime = dropDateTime;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}

