package com.loggerspage.dao.domain;

public enum Worth {
	A(1), B(2), C(3), D(4),E(5),F(6),G(7),H(8),I(9),J(10);

	Worth(int rate) {
		this.rate = rate;
	}

	private final int rate;

	public int getRate() {
		return rate;
	}
}
