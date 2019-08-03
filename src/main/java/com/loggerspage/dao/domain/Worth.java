package com.loggerspage.dao.domain;

import java.io.Serializable;

public enum Worth implements Serializable {
	A(1), B(2), C(3), D(4),E(5),F(6),G(7),H(8),I(9),J(10);

	Worth(int worth) {
		this.worth = worth;
	}

	private final int worth;

	public int getWorht() {
		return worth;
	}
}
