package com.juaracoding.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="booking")
public class BookingModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "screeningId",referencedColumnName = "screeningId")
	private ScreeningModel screeningId;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private CustomerModel customerId;
}
