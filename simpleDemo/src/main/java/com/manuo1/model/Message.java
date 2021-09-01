package com.manuo1.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok
@NoArgsConstructor // lombok
@Entity // This tells Hibernate to make a table out of this class
public class Message {

	// Attributes
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idMessage;
	
	private LocalDateTime timeStamp;
	private String content;
	
	@ManyToOne
	@JoinColumn(name="auhtor_id", nullable=false)
	private Author author;
	
	// Constructor
	
	public Message(String content, Author author) {
		super();
		this.timeStamp = LocalDateTime.now();
		this.content = content;
		this.author = author;
	}
	
	
}
