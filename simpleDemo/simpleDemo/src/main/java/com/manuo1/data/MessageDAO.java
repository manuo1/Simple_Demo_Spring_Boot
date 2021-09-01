package com.manuo1.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.manuo1.model.Message;

@Service
public interface MessageDAO extends JpaRepository<Message, Long>{
	
}
