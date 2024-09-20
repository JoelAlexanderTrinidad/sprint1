package com.mindhub.spring1.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class EventLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Event event;

    @ManyToOne
    private Location location;

    @OneToMany(mappedBy = "eventLocation")
    private Set<CustomerEvent> customerEvents = new HashSet<>();

    private LocalDateTime date;
    private Integer assistance;

    public EventLocation() {
    }

    public EventLocation(LocalDateTime date, Integer assistance) {
        this.date = date;
        this.assistance = assistance;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getAssistance() {
        return assistance;
    }

    public void setAssistance(Integer assistance) {
        this.assistance = assistance;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<CustomerEvent> getCustomerEvents() {
        return customerEvents;
    }

    public void setCustomerEvents(Set<CustomerEvent> customerEvents) {
        this.customerEvents = customerEvents;
    }

    public void addCustomerEvents(CustomerEvent customerEvent){
        customerEvent.setEventLocation(this);
        customerEvents.add(customerEvent);
    }
}
