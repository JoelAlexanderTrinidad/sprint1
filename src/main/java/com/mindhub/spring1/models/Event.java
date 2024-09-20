package com.mindhub.spring1.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "event")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<EventLocation> eventLocations = new HashSet<>();

    @ManyToOne
    private Customer customer;

    private String description;
    private String img;
    private String age_req;
    private String name;

    public Event() {
    }

    public Event(String description, String img, String age_req, String name) {
        this.description = description;
        this.img = img;
        this.age_req = age_req;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAge_req() {
        return age_req;
    }

    public void setAge_req(String age_req) {
        this.age_req = age_req;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment){
        comment.setEvent(this);
        comments.add(comment);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<EventLocation> getEventLocations() {
        return eventLocations;
    }

    public void setEventLocations(Set<EventLocation> eventLocations) {
        this.eventLocations = eventLocations;
    }

    public void addEventLocation(EventLocation eventLocation){
        eventLocation.setEvent(this);
        eventLocations.add(eventLocation);
    }
}
