package com.mindhub.spring1.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "customer")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<Event> events = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<CustomerEvent> customerEvents = new HashSet<>();

    private String name;
    private String lastname;
    private String email;
    private Boolean activated;
    private String password;
    private Short age;
    private Enum gender;
    private Enum rol;

    public Customer() {
    }

    public Customer(String name, String lastname, String email, Boolean activated, String password, Short age, Enum gender, Enum rol) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.activated = activated;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.rol = rol;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Enum getGender() {
        return gender;
    }

    public void setGender(Enum gender) {
        this.gender = gender;
    }

    public Enum getRol() {
        return rol;
    }

    public void setRol(Enum rol) {
        this.rol = rol;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment){
        comment.setCustomer(this);
        comments.add(comment);
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public void addEvent(Event event){
        event.setCustomer(this);
        events.add(event);
    }

    public Set<CustomerEvent> getCustomerEvents() {
        return customerEvents;
    }

    public void setCustomerEvents(Set<CustomerEvent> customerEvents) {
        this.customerEvents = customerEvents;
    }

    public void addCustomerEvent(CustomerEvent customerEvent){
        customerEvent.setCustomer(this);
        customerEvents.add(customerEvent);
    }
}
