package com.juaracoding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.juaracoding.model.CustomerCustomeGetNameModel;
import com.juaracoding.model.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long>{
	
	@Query(value="SELECT CONCAT(first_name,\"\",last_name) as nama FROM `customer`"
			,nativeQuery = true)
	List<CustomerCustomeGetNameModel> getAllDataFirstNameLastName();
	
	@Query(value="SELECT * FROM `customer` WHERE first_name LIKE ?1%"
			+ "AND last_name = ?2"
			, nativeQuery = true)
	List<CustomerModel> getByFirstName(String firstname, String lastname);
	
	@Query(value="SELECT * FROM `customer` WHERE customer_id LIKE >?1 "
			+ "AND first_name LIKE %?2%",
			 nativeQuery = true)
	List<CustomerModel> getDataById(long id, String firstname);
	/*
	 * ini adalah pencarian berdasarkan nama depan tapi menggunakan 
	 * query otomatis jpa
	 */
	List<CustomerModel> findByFirstName(String firstname);
	
	CustomerModel findByUsername(String username);

}
