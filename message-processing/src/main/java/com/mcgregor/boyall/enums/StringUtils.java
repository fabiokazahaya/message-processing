package com.mcgregor.boyall.enums;

public enum StringUtils {

	EMPTY {
		@Override
		public String toString() {
			return "";
		}
	},
	SPACE {
		@Override
		public String toString() {
			return " ";
		}
	}
}