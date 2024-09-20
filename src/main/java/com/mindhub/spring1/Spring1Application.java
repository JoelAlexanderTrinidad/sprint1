package com.mindhub.spring1;

import com.mindhub.spring1.models.*;
import com.mindhub.spring1.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Spring1Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring1Application.class, args);
	}

	@Bean
	public CommandLineRunner initData(CommentRepository commentRepository, CustomerRepository customerRepository, CustomerEventRepository customerEventRepository, EventRepository eventRepository, EventLocationRepository eventLocationRepository, LocationRepository locationRepository){
		return args -> {

			CustomerEvent customerEvent = new CustomerEvent();

			EventLocation eventLocation = new EventLocation(LocalDateTime.now(), 3);
			eventLocation.addCustomerEvents(customerEvent);

			Customer customer = new Customer("Pepito", "Gonzalez", "asd@gmail.com", true, "123456", (short) 20, Gender.WARMACHINE, Rol.CUSTOMER);
			customer.addCustomerEvent(customerEvent);

			Event event = new Event("Alto evento, venite", "asd.jpg", "No sé qué es eso", "Junji Ito Event");
			customer.addEvent(event);

			Comment comment = new Comment("Estuvo re piola, me chapé un dragqueen");
			customer.addComment(comment);
			event.addComment(comment);
			event.addEventLocation(eventLocation);


			Location location = new Location("Tokio", "En tu corazón", 2, "asd.jpg");
			location.addEventLocation(eventLocation);
			customerRepository.save(customer);
			locationRepository.save(location);
			eventRepository.save(event);
			eventLocationRepository.save(eventLocation);
			customerEventRepository.save(customerEvent);
			commentRepository.save(comment);



		};
	}

}
