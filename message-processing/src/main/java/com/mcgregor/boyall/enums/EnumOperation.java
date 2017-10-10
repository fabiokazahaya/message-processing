package com.mcgregor.boyall.enums;

public enum EnumOperation {

	ADD {
		public int eval(int x, int y) {
			return x + y;
		}
	},

	SUBTRACT {
		public int eval(int x, int y) {
			return x - y;
		}
	},

	MULTUPLY {
		public int eval(int x, int y) {
			return x * y;
		}
	};

	public abstract int eval(int x, int y);
}
