package com.manuo1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok
@NoArgsConstructor // lombok
public class NewMessageForm {

	private String authorName;
	private String content;
	
}
