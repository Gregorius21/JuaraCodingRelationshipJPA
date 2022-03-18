package com.juaracoding.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="seat")
public class SeatModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long seatId;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="roomSeatId", referencedColumnName = "roomId")
	private RoomModel roomId;

}