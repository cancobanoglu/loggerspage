package com.loggerspage.dao;

import java.util.Date;
import java.util.List;

import com.loggerspage.dao.domain.ActivityEntity;

public interface ActivityRepositoryCustom {
	public List<ActivityEntity> findActivityByInterval(Date start,Date stop);
}
