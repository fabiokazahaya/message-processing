package com.mcgregor.boyall.enums;

public enum EnumValues {
	ZERO(0), TENTH(10), FIFTIETH(50);

	public final int Value;

	private EnumValues(int value) {
		Value = value;
	}
}
