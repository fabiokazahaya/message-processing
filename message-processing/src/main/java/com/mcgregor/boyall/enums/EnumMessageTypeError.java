package com.mcgregor.boyall.enums;

public enum EnumMessageTypeError {
	
	MESSAGE_TYPE_2 {
		@Override
		public String toString() {
			return "Error processing message type 2";
		}
	},
	MESSAGE_TYPE_3 {
		@Override
		public String toString() {
			return "Error processing message type 3";
		}
	}
}
