package com.loggerspage.dao.domain;

import java.io.Serializable;

public enum Category  implements Serializable{

	WORK,READING,SPORT,HOMEWORK,FUN,SHOPPING,REST;
	

    public String getCategory() {
        return this.name();
    }
}
