package com.manuo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.manuo1.data.AuthorDAO;
import com.manuo1.data.MessageDAO;
import com.manuo1.model.Author;
import com.manuo1.model.Message;
import com.manuo1.model.NewMessageForm;

@Controller
public class MessageController {

	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private AuthorDAO authorDAO;
	
	@GetMapping("/messages")
	public String showMessage(Model model) {
		// send an empty NewMessageForm Model to the view
		model.addAttribute("newMessageForm", new NewMessageForm());
		// send a list of all messages to the view
		model.addAttribute("messagelist", messageDAO.findAll());
		
		return "MessagePage";
	}
	
	@PostMapping("/messages")
	public String postMessage(@ModelAttribute NewMessageForm newMessageForm) {
		Author author = null;
		
		// author management
		if (authorDAO.findByAuthorName(newMessageForm.getAuthorName()).size() != 1) {
			// create a new author if the author does not already exist in the database
			author = authorDAO.save(new Author(newMessageForm.getAuthorName()));
		}
		else {
			// if exist get author by name
			author = authorDAO.findByAuthorName(newMessageForm.getAuthorName()).get(0);
		}
		
		// message management
		messageDAO.save(new Message(newMessageForm.getContent(), author));
		
		return "redirect:messages";
		
	}
	
}
