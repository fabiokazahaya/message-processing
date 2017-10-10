package com.mcgregor.boyall.enums;

public enum EnumOperationType {

	ADD {
		@Override
		public String toString() {
			return "add";
		}
	},
	SUBTRACT {
		@Override
		public String toString() {
			return "subtract";
		}
	}
}
