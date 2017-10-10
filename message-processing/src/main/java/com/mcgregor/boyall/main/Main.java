package com.mcgregor.boyall.main;

import java.util.ArrayList;
import java.util.List;

import com.mcgregor.boyall.object.Message;
import com.mcgregor.boyall.utils.MessageService;

public class Main {
	
	public static void main(String ...args) {
		
		MessageService messageService = new MessageService();
		
		List<Message> queue = new ArrayList<Message>();
		
		messageService.proccessMessage(queue, new Message("apple", 1));
		messageService.proccessMessage(queue, new Message("orange", 1));
		messageService.proccessMessage(queue, new Message("add", 1, "apple"));
		messageService.proccessMessage(queue, new Message(45, "banana", 1));
		messageService.proccessMessage(queue, new Message("add", 5, "apple"));
		messageService.proccessMessage(queue, new Message(2, "apple", 1));
		
	}
}


