package com.juaracoding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.model.ScreeningModel;
import com.juaracoding.repository.ScreeningRepository;

@RestController
@RequestMapping("/screening")
public class ScreeningController {
	
	@Autowired
	ScreeningRepository screeningRepo;
	
	@PostMapping("/")
	private String saveDataScreening(@RequestBody ScreeningModel screening) {
		screeningRepo.save(screening);
		return "Data berhasil disimpan!";
	}

}