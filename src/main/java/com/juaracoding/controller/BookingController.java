package com.juaracoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.model.BookingModel;
import com.juaracoding.repository.BookingRepository;

@RestController
public class BookingController {
	@Autowired
	BookingRepository bookingRepository;
	
	@GetMapping("/")
	private List<BookingModel> getAll(){
		return bookingRepository.findAll();
	}
	@GetMapping("/{booking}")
	private BookingModel getallid (@PathVariable ("booking") Long id) {
		return bookingRepository.findById(id).get();
	}
	
	@GetMapping("/nama/{firstname}")
	private List<BookingModel> getBookingByFirstName(@PathVariable("firstname") String name){
		return bookingRepository.findByCustomerId_firstName(name);
	}
	
	@GetMapping("/maxofseat2/{maxofseat}")
	private List<BookingModel> getBookingByMaxOfSeat2(@PathVariable("maxofseat") long maxofseat){
		return bookingRepository.findByScreeningIdRoomIdMaxOfSeat(maxofseat);
	}

}
