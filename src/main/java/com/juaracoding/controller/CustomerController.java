package com.juaracoding.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.config.JwtTokenUtil;
import com.juaracoding.model.CustomerCustomeGetNameModel;
import com.juaracoding.model.CustomerModel;
import com.juaracoding.repository.CustomerRepository;
import com.juaracoding.service.JwtCustomerDetailService;

@RestController
@RequestMapping("/customer")
public class CustomerController{
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JwtCustomerDetailService jwtCustomerDetailService;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	PasswordEncoder pEncoder;
	
	@GetMapping("/")
	private List<CustomerCustomeGetNameModel> getAllFullName(){
		return customerRepository.getAllDataFirstNameLastName();
		
	}
	
	@GetMapping("/querynative")
	private List<CustomerModel> getDataByIdDanFirstName(
			@RequestParam(name = "id") long id,
			@RequestParam(name ="firstName") String firstName){
		return customerRepository.getDataById(id, firstName);
	}
	
	@PostMapping("/registrasi")
	private ResponseEntity<String> saveCustomer(@RequestBody CustomerModel customer){
		customer.setPassword(pEncoder.encode(customer.getPassword()));
		customerRepository.save(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body("Behasil di buat");
	}
	
	@PostMapping("/login")
	private ResponseEntity<?> login(@RequestBody CustomerModel customerModel) throws Exception{
		authenticate(customerModel.getUsername(),customerModel.getPassword());
		
		final UserDetails userDetails = jwtCustomerDetailService
				.loadUserByUsername(customerModel.getUsername());
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(token);
	}
	private void authenticate(String username, String password) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			//User disabled
		throw new Exception("USER_DISABED", e);	
		} catch (BadCredentialsException e) {
			//invalid credentials
			throw new Exception("INVALID_CREDENTIALS",e);
		}
	}
}
