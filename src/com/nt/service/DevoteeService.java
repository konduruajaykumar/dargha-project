package com.nt.service;

import java.time.LocalDate;
import java.util.List;

import org.logicalcobwebs.cglib.core.Local;

import com.nt.dto.DevoteeDTO;

public interface DevoteeService {
	public static final int PAGE_SIZE = 20;
	public String register(DevoteeDTO dto) throws Exception;
	public LocalDate calculateVisitDate(LocalDate stringDate) throws Exception;
	public int calculateDays(LocalDate fromDate, LocalDate toDate) throws Exception;
	public int getPageCount(Class obj) throws Exception;
	public List<DevoteeDTO> getReportData(int pageNo) throws Exception;
	public List<DevoteeDTO> getSuccessReportData(int pageNo) throws Exception;
	public DevoteeDTO searchDevoteeById(int id) throws Exception;
	public void updateDevotee(int devoteeId, String visitingStatus, String status) throws Exception;
	public String transferDevotee(int devoteeId) throws Exception;
	public List<DevoteeDTO> searchDevoteesByDate(String fieldType, LocalDate fromDate, LocalDate toDate) throws Exception;
	public List<DevoteeDTO> searchDevoteesByStringData(String fieldType, String fieldValue) throws Exception;
	public DevoteeDTO searchDevoteesByMobile(String fieldType, String fieldValue) throws Exception;
	public DevoteeDTO searchDevoteesByMobileNoOrId(String fieldType, String fieldValue) throws Exception;
	public LocalDate addMoreDaysToPregnancyDateToGetFirstDate(int differenceBetweenPdateAndFdate, LocalDate firstDate) throws Exception;
	public float calculateSuccessDevoteesPercentage() throws Exception;

}
