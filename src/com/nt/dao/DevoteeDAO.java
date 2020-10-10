package com.nt.dao;

import java.time.LocalDate;
import java.util.List;

import com.nt.bo.DevoteeBO;
import com.nt.bo.DevoteeSuccessBO;

public interface DevoteeDAO {

	public int insertDevotee(DevoteeBO bo) throws Exception;

	public long rowCount(Class obj) throws Exception;

	public List<DevoteeBO> getDevotees(int startPos, int pageSize) throws Exception;

	public List<DevoteeSuccessBO> getSuccessDevotees(int startPos, int pageSize) throws Exception;

	public DevoteeBO getDevoteeById(int id) throws Exception;

	public void updateDevoteeById(int id, String visitStatus, String status) throws Exception;

	public boolean moveDevotee(int devoteeId) throws Exception;

	public List<DevoteeBO> getDevoteesByDate(String fieldType, LocalDate fromDate, LocalDate toDate) throws Exception;

	public List<DevoteeBO> getDevoteesByStringData(String fieldType, String fieldValue) throws Exception;

	public DevoteeBO getDevoteesByMobile(String fieldType, String fieldValue) throws Exception;

	public DevoteeBO getDevoteesByMobileNoOrId(String fieldType, String fieldValue) throws Exception;

	public float getSuccessDevoteesPercentage() throws Exception;
}
