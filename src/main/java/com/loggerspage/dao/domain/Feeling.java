package com.loggerspage.dao.domain;

import java.io.Serializable;

public enum Feeling implements Serializable{

	OPEN(1), HAPPY(2), ALIVE(3), GOOD(4), LOVE(5), INTERESTED(6), POSITIVE(7), STRONG(8), ANGRY(9), DEPRESSED(10), CONFUSED(11), HELPLESS(12), INDIFFERENT(13), AFRAID(14), HURT(15), SAD(16);
	
	Feeling(int feeling) {
		this.feeling = feeling;
	}

	private final int feeling;

	public int getFeeling() {
		return feeling;
	}

}
