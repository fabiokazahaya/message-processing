package com.mcgregor.boyall.object;

import com.mcgregor.boyall.enums.StringUtils;

public class Message {

	private String type;
	private int value;
	private int occurrences;
	private String operation;

	public Message(String typeArg, int valueArg) {
		this.type = typeArg;
		this.value = valueArg;
	}

	public Message(int occurencesArg, String typeArg, int valueArg) {
		this.occurrences = occurencesArg;
		this.type = typeArg;
		this.value = valueArg;
	}

	public Message(String operationArg, int valueArg, String typeArg) {
		this.operation = operationArg;
		this.value = valueArg;
		this.type = typeArg;
	}
	
	public Message(String operationArg, int occurencesArg, String typeArg, int valueArg) {
		this.operation = operationArg;
		this.occurrences = occurencesArg;
		this.type = typeArg;
		this.value = valueArg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getOccurrences() {
		return occurrences;
	}

	public void setOccurrences(int occurrences) {
		this.occurrences = occurrences;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return printOperation(this.operation) + printOccurrences(this.occurrences) + printType(this.getType()) + printValue(this.getValue());
	}

	public String printValue(int value) {
		return "value:" + this.getValue();
	}

	public String printType(String type) {
		return "type:" + this.getType() + " ";
	}

	public String printOperation(String operation) {
		return operation == null ? StringUtils.EMPTY.toString() : "operation:" + this.getOperation() + StringUtils.SPACE.toString();
	}

	public String printOccurrences(int occurrences) {
		return occurrences == 0 ? StringUtils.EMPTY.toString() : "occurrences:" + this.getOccurrences() + StringUtils.SPACE.toString();
	}
}
