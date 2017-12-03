package com.loggerspage.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.loggerspage.dao.domain.ActivityEntity;

@Repository
public interface ActivityRepositoryCustom {
	public List<ActivityEntity> findActivityByInterval(Date start,Date stop);
}
