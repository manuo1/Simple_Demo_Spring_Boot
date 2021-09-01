package com.manuo1.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.manuo1.model.Author;

@Service
public interface AuthorDAO extends JpaRepository<Author, Long> {

	List<Author> findByAuthorName(String authorName);
			
}
