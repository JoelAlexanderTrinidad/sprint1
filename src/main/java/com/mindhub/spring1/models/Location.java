package com.mindhub.spring1.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "location")
    private Set<EventLocation> eventLocations = new HashSet<>();

    private String name;
    private String location;
    private Integer capacity;
    private String img;

    public Location() {
    }

    public Location(String name, String location, Integer capacity, String img) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.img = img;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Set<EventLocation> getEventLocations() {
        return eventLocations;
    }

    public void setEventLocations(Set<EventLocation> eventLocations) {
        this.eventLocations = eventLocations;
    }

    public String getName() {
        return name;
    }

    public void addEventLocation(EventLocation eventLocation){
        eventLocation.setLocation(this);
        eventLocations.add(eventLocation);
    }
}
