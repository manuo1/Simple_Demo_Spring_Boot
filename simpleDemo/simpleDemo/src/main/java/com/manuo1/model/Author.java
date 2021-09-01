package com.manuo1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok
@NoArgsConstructor // lombok
@Entity  // This tells Hibernate to make a table out of this class

public class Author {

	// Attributes
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idAuthor;
	
	private String authorName;
	
	@OneToMany(mappedBy="author")
	private List<Message> authorMessages;
	
	// Constructor
	
	public Author(String authorName) {
		super();
		this.authorName = authorName;
	}
		
}
