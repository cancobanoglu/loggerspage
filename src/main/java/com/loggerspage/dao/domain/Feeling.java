package com.loggerspage.dao.domain;

public enum Feeling {

	OPEN(1), HAPPY(2), ALIVE(3), GOOD(4), LOVE(5), INTERESTED(6), POSITIVE(7), STRONG(8), ANGRY(9), DEPRESSED(10), CONFUSED(11), HELPLESS(12), INDIFFERENT(13), AFRAID(14), HURT(15), SAD(16);
	
	Feeling(int rate) {
		this.rate = rate;
	}

	private final int rate;

	public int getRate() {
		return rate;
	}

}
