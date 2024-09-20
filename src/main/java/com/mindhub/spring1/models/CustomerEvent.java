package com.mindhub.spring1.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class CustomerEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private EventLocation eventLocation;

    @ManyToOne
    private Customer customer;

    public CustomerEvent() {
    }

    public UUID getId() {
        return id;
    }

    public EventLocation getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(EventLocation eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
