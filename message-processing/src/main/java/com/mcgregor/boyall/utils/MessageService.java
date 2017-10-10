package com.mcgregor.boyall.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.mcgregor.boyall.enums.EnumMessageTypeError;
import com.mcgregor.boyall.enums.EnumOperation;
import com.mcgregor.boyall.enums.EnumOperationType;
import com.mcgregor.boyall.enums.EnumValues;
import com.mcgregor.boyall.enums.Report;
import com.mcgregor.boyall.object.Message;

public class MessageService {
	
	public void proccessMessage(List<Message> queue, Message message) {
		if (message.getOccurrences() == EnumValues.ZERO.Value) {
			proccessMessageType3(queue, message);
		} else if (message.getOperation() == null) {
			proccessMessageType2(queue, message);
		} else {
			recordMessage(queue, message);
		}
	}
	
	public void recordMessage(List<Message> queue, Message message) {
		queue.add(new Message(message.getOperation(), message.getOccurrences(), message.getType(), message.getValue()));
		logReporting(queue);
	}

	public void proccessMessageType3(List<Message> queue, Message message) {
		try {
			queue.stream().filter(m -> m.getOccurrences() == EnumValues.ZERO.Value && m.getOperation() == null)
					.filter(m -> m.getType().equals(message.getType())).forEach(m -> m
							.setValue(executeOperation(m.getValue(), message.getValue(), message.getOperation())));
			recordMessage(queue, message);
		} catch (Exception e) {
			System.out.println(EnumMessageTypeError.MESSAGE_TYPE_3);
		}
	}
	
	public void proccessMessageType2(List<Message> queue, Message message) {
		try {
			List<Message> messages = IntStream.rangeClosed(1, message.getOccurrences())
					.mapToObj(value -> IntStream.rangeClosed(1, 1).mapToObj(
							t -> new Message(message.getOperation(), message.getOccurrences(), message.getType(), message.getValue())))
					.flatMap(Function.identity()).collect(Collectors.toList());
			
			messages.forEach(s-> recordMessage(queue, s));
			recordMessage(queue, message);
		} catch (Exception e) {
			System.out.println(EnumMessageTypeError.MESSAGE_TYPE_2);
		}
	}

	public Integer executeOperation(Integer x, Integer y, String operation) {
		if (operation.equals(EnumOperationType.ADD)) {
			return EnumOperation.ADD.eval(x, y);
		} else if (operation.equals(EnumOperationType.SUBTRACT)) {
			return EnumOperation.SUBTRACT.eval(x, y);
		} else {
			return EnumOperation.MULTUPLY.eval(x, y);
		}
	}
	
	public boolean isMultipleOf(Integer number, List<Message> queue) {
		return (queue.size() % number == EnumValues.ZERO.Value);
	}
	
	public void logReporting(List<Message> queue) {
		if (isMultipleOf(EnumValues.TENTH.Value, queue)){
			System.out.println(Report.REPORTING_10TH);
			System.out.println(
					queue.stream()
					.filter(s -> s.getOperation() == null && s.getOccurrences() == EnumValues.ZERO.Value)
					.collect(Collectors.groupingBy(Message::getType, Collectors.summingInt(Message::getValue))));
		}
		
		if (isMultipleOf(EnumValues.FIFTIETH.Value, queue)){
			System.out.println(Report.REPORTING_50TH);
			queue.stream().filter(s->s.getOperation() != null).forEach(System.out::println);
		}
	}
}
