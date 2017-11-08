package com.mcgregor.boyall.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.mcgregor.boyall.object.Message;
import com.mcgregor.boyall.service.MessageService;

@RunWith(JUnit4.class)
public class MessageTests {
	
	List<Message> queue = new ArrayList<>();
	MessageService messageService = new MessageService();
	
	@Test
	public void testMessageType1(){
		messageService.proccessMessage(queue, new Message("apple", 1));
		Assert.assertEquals(1, queue.size());
		messageService.proccessMessage(queue, new Message("orange", 1));
		Assert.assertEquals(2, queue.size());
		messageService.proccessMessage(queue, new Message("banana", 1));
		Assert.assertEquals(3, queue.size());
	}
	
	@Test
	public void testMessageType2(){
		messageService.proccessMessage(queue, new Message(2, "banana", 1));
		Assert.assertEquals(3, queue.size());
		messageService.proccessMessage(queue, new Message(1, "banana", 1));
		Assert.assertEquals(5, queue.size());
	}
	
	@Test
	public void testMessageType3(){
		messageService.proccessMessage(queue, new Message("banana", 1));
		messageService.proccessMessage(queue, new Message("add", 1, "banana"));
		Assert.assertEquals(2, queue.get(0).getValue());
		messageService.proccessMessage(queue, new Message("subtract", 1, "banana"));
		Assert.assertEquals(1, queue.get(0).getValue());
		messageService.proccessMessage(queue, new Message("multiply", 5, "banana"));
		Assert.assertEquals(5, queue.get(0).getValue());
	}
	
	@Test
	public void Reporting10thMessage() throws IOException{
		messageService.proccessMessage(queue, new Message(10, "banana", 1));
		Assert.assertEquals(11, queue.size());
		messageService.proccessMessage(queue, new Message(10, "apple", 1));
		Assert.assertEquals(22, queue.size());
	}
	
	@Test
	public void Reporting50thMessage() throws IOException{
		messageService.proccessMessage(queue, new Message(1, "banana", 1));
		Assert.assertEquals(2, queue.size());
		messageService.proccessMessage(queue, new Message("add", 1, "apple"));
		Assert.assertEquals(3, queue.size());
		messageService.proccessMessage(queue, new Message(47, "banana", 1));
		Assert.assertEquals(51, queue.size());
	}
	
	@Test
	public void adding10Messages(){
		messageService.proccessMessage(queue, new Message(1, "banana", 1));
		messageService.proccessMessage(queue, new Message(1, "banana", 1));
		messageService.proccessMessage(queue, new Message(1, "banana", 1));
		messageService.proccessMessage(queue, new Message(1, "banana", 1));
		messageService.proccessMessage(queue, new Message(1, "banana", 1));
		messageService.proccessMessage(queue, new Message(1, "banana", 1));
		messageService.proccessMessage(queue, new Message(1, "banana", 1));
		messageService.proccessMessage(queue, new Message(1, "banana", 1));
		messageService.proccessMessage(queue, new Message(1, "banana", 1));
		messageService.proccessMessage(queue, new Message(1, "banana", 1));
	}
	
	@Test
	public void adding10Once(){
		messageService.proccessMessage(queue, new Message(10, "banana", 1));
	}
	
	@Test
	public void adding50Once(){
		messageService.proccessMessage(queue, new Message("add", 12, "apple"));
		messageService.proccessMessage(queue, new Message("add", 1, "apple"));
	}
}
