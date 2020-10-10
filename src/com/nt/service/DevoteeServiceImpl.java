package com.nt.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.nt.bo.DevoteeBO;
import com.nt.bo.DevoteeSuccessBO;
import com.nt.dao.DevoteeDAO;
import com.nt.dao.DevoteeDAOFactory;
import com.nt.dto.DevoteeDTO;

public class DevoteeServiceImpl implements DevoteeService {

	@Override
	public String register(DevoteeDTO dto) throws Exception {

		DevoteeBO bo = null;
		DevoteeDAO dao = null;
		int id = 0;

		// setting data to bo class obj
		bo = new DevoteeBO();
		bo.setName(dto.getName());
		bo.setHusbandName(dto.getHusbandName());
		bo.setMobileNo(dto.getMobileNo());
		bo.setVillage(dto.getVillage());
		bo.setMandal(dto.getMandal());
		bo.setDistrict(dto.getDistrict());
		bo.setPregnancyDate(dto.getPregnancyDate());
		bo.setFirstDate(dto.getFirstDate());
		bo.setVisitDate(dto.getVisitDate());
		bo.setStatus(dto.getStatus());
		bo.setVisitStatus(dto.getVisitStatus());
		bo.setOtherDetails(dto.getOtherDetails());
		bo.setChildNo(dto.getChildNo());
		bo.setRegisteredDate(dto.getRegisteredDate());
		bo.setDaysBetweenPdateAndFdate(dto.getDaysBetweenPdateAndFdate());
		bo.setDaysBetweenPdateAndRdate(dto.getDaysBetweenPdateAndRdate());
		bo.setDaysBetweenPdateAndVdate(dto.getDaysBetweenPdateAndVdate());

		// calling dao class method

		dao = DevoteeDAOFactory.getInstance();
		id = dao.insertDevotee(bo);

		if (id == 0) {
			return "Registration Failed";
		} else {

			return id + "";

		}

	}

	@Override
	public LocalDate calculateVisitDate(LocalDate stringDate) throws Exception {
		LocalDate pregnancyDate = null, visitingDate = null, plusDate = null;
		byte dayDifference = 0;

		// convert the given string date as date
		pregnancyDate = stringDate;
		// add the 98 days to the pregnancyDate(95 days to 101 days)
		plusDate = pregnancyDate.plusDays(98);
		// calculate the day difference between pregnancyDate and plusDate
		dayDifference = (byte) plusDate.getDayOfWeek().compareTo(DayOfWeek.THURSDAY);
		// calculate the date which is on thursday after 98 days using
		// dayDifference
		if (dayDifference == 0) {
			visitingDate = plusDate;
		} else if (dayDifference >= -3 && dayDifference <= -1) {
			visitingDate = plusDate.plusDays(-dayDifference);
		} else if (dayDifference >= 1 && dayDifference <= 3) {
			visitingDate = plusDate.plusDays(-dayDifference);
		}

		return visitingDate;
	}

	@Override
	public int calculateDays(LocalDate fromDate, LocalDate toDate) throws Exception {
		int days;
		days = (int) ChronoUnit.DAYS.between(fromDate, toDate) + 1;//including from date also.
		System.out.println("Differernce b/w 2 dates:: " + days);
		return days;
	}

	@Override
	public int getPageCount(Class obj) throws Exception {
		DevoteeDAO dao = null;
		long rowCount = 0;
		int pageCount = 0;

		// get DAO
		dao = DevoteeDAOFactory.getInstance();
		// use DAO
		rowCount = dao.rowCount(obj);
		// calculate pagesCount
		pageCount = (int) (rowCount / DevoteeService.PAGE_SIZE);

		if (rowCount % DevoteeService.PAGE_SIZE != 0)
			pageCount++;
		return pageCount;
	}

	@Override
	public List<DevoteeDTO> getSuccessReportData(int pageNo) throws Exception {
		int startPos = 0;
		DevoteeDAO dao = null;

		List<DevoteeSuccessBO> listBo = null;
		List<DevoteeDTO> listDTO = new ArrayList<DevoteeDTO>();
		// Decide StartPosition to get page Report data based on given pageno
		startPos = (pageNo * DevoteeService.PAGE_SIZE) - DevoteeService.PAGE_SIZE;
		// get DAO
		dao = DevoteeDAOFactory.getInstance();
		// use DAO
		listBo = dao.getSuccessDevotees(startPos, DevoteeService.PAGE_SIZE);
		// convert listDevoteeBO to listDevoteeDTO
		listBo.forEach(p -> {
			DevoteeDTO dto = null;
			dto = new DevoteeDTO();
			dto.setId(p.getDevoteeId());
			dto.setName(p.getName());
			dto.setHusbandName(p.getHusbandName());
			dto.setDistrict(p.getDistrict());
			dto.setMandal(p.getMandal());
			dto.setMobileNo(p.getMobileNo());
			dto.setOtherDetails(p.getOtherDetails());
			dto.setPregnancyDate(p.getPregnancyDate());
			dto.setFirstDate(p.getFirstDate());
			dto.setVisitStatus(p.getVisitStatus());
			dto.setStatus(p.getStatus());
			dto.setVillage(p.getVillage());
			dto.setVisitDate(p.getVisitDate());
			dto.setChildNo(p.getChildNo());
			dto.setDaysBetweenPdateAndFdate(p.getDaysBetweenPdateAndFdate());
			dto.setDaysBetweenPdateAndRdate(p.getDaysBetweenPdateAndRdate());
			dto.setDaysBetweenPdateAndVdate(p.getDaysBetweenPdateAndVdate());
			dto.setRegisteredDate(p.getRegisteredDate());
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public List<DevoteeDTO> getReportData(int pageNo) throws Exception {
		int startPos = 0;
		DevoteeDAO dao = null;

		List<DevoteeBO> listBo = null;
		List<DevoteeDTO> listDTO = new ArrayList<DevoteeDTO>();
		// Decide StartPosition to get page Report data based on given pageno
		startPos = (pageNo * DevoteeService.PAGE_SIZE) - DevoteeService.PAGE_SIZE;
		// get DAO
		dao = DevoteeDAOFactory.getInstance();
		// use DAO
		listBo = dao.getDevotees(startPos, DevoteeService.PAGE_SIZE);
		// convert listDevoteeBO to listDevoteeDTO
		listBo.forEach(p -> {
			DevoteeDTO dto = null;
			dto = new DevoteeDTO();
			dto.setId(p.getDevoteeId());
			dto.setName(p.getName());
			dto.setHusbandName(p.getHusbandName());
			dto.setDistrict(p.getDistrict());
			dto.setMandal(p.getMandal());
			dto.setMobileNo(p.getMobileNo());
			dto.setOtherDetails(p.getOtherDetails());
			dto.setPregnancyDate(p.getPregnancyDate());
			dto.setFirstDate(p.getFirstDate());
			dto.setVisitStatus(p.getVisitStatus());
			dto.setStatus(p.getStatus());
			dto.setVillage(p.getVillage());
			dto.setVisitDate(p.getVisitDate());
			dto.setChildNo(p.getChildNo());
			dto.setDaysBetweenPdateAndFdate(p.getDaysBetweenPdateAndFdate());
			dto.setDaysBetweenPdateAndRdate(p.getDaysBetweenPdateAndRdate());
			dto.setDaysBetweenPdateAndVdate(p.getDaysBetweenPdateAndVdate());
			dto.setRegisteredDate(p.getRegisteredDate());
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public DevoteeDTO searchDevoteeById(int id) throws Exception {
		DevoteeDAO dao = null;
		DevoteeBO bo = null;
		DevoteeDTO dto = null;
		// get DAO
		dao = DevoteeDAOFactory.getInstance();
		bo = dao.getDevoteeById(id);
		if (bo != null) {
			// convert DevoteeBO to DevoteeDTO
			dto = new DevoteeDTO();
			dto.setId(bo.getDevoteeId());
			dto.setName(bo.getName());
			dto.setHusbandName(bo.getHusbandName());
			dto.setDistrict(bo.getDistrict());
			dto.setMandal(bo.getMandal());
			dto.setMobileNo(bo.getMobileNo());
			dto.setOtherDetails(bo.getOtherDetails());
			dto.setPregnancyDate(bo.getPregnancyDate());
			dto.setFirstDate(bo.getFirstDate());
			dto.setVillage(bo.getVillage());
			dto.setVisitDate(bo.getVisitDate());
			dto.setVisitStatus(bo.getVisitStatus());
			dto.setStatus(bo.getStatus());
			dto.setChildNo(bo.getChildNo());
			dto.setDaysBetweenPdateAndFdate(bo.getDaysBetweenPdateAndFdate());
			dto.setDaysBetweenPdateAndRdate(bo.getDaysBetweenPdateAndRdate());
			dto.setDaysBetweenPdateAndVdate(bo.getDaysBetweenPdateAndVdate());
			dto.setRegisteredDate(bo.getRegisteredDate());
		}
		return dto;
	}

	@Override
	public void updateDevotee(int devoteeId, String visitingStatus, String status) throws Exception {
		DevoteeDAO dao = null;
		// calling dao class method
		dao = DevoteeDAOFactory.getInstance();
		dao.updateDevoteeById(devoteeId, visitingStatus, status);
	}

	@Override
	public String transferDevotee(int devoteeId) throws Exception {
		DevoteeDAO dao = null;
		boolean result = false;
		// calling dao class method
		dao = DevoteeDAOFactory.getInstance();
		try {
			result = dao.moveDevotee(devoteeId);
		} catch (HibernateException he) {
			throw he;
		} catch (Exception e) {
			throw e;
		}
		if (result == true) {
			System.out.println(" Details moved successfully...");
			return " Details moved successfully...";
		} else {
			System.out.println(" Your Details are not moved...");
			return "Your Details are not moved...";
		}

	}

	@Override

	public List<DevoteeDTO> searchDevoteesByDate(String fieldType, LocalDate fromDate, LocalDate toDate)
			throws Exception {
		DevoteeDAO dao = null;

		List<DevoteeBO> listBo = null;
		List<DevoteeDTO> listDTO = new ArrayList<DevoteeDTO>();
		// get DAO
		dao = DevoteeDAOFactory.getInstance();
		// use DAO
		listBo = dao.getDevoteesByDate(fieldType, fromDate, toDate);
		// convert listDevoteeBO to listDevoteeDTO
		listBo.forEach(p -> {
			DevoteeDTO dto = null;
			dto = new DevoteeDTO();
			dto.setId(p.getDevoteeId());
			dto.setName(p.getName());
			dto.setHusbandName(p.getHusbandName());
			dto.setDistrict(p.getDistrict());
			dto.setMandal(p.getMandal());
			dto.setMobileNo(p.getMobileNo());
			dto.setOtherDetails(p.getOtherDetails());
			dto.setPregnancyDate(p.getPregnancyDate());
			dto.setFirstDate(p.getFirstDate());
			dto.setVisitStatus(p.getVisitStatus());
			dto.setStatus(p.getStatus());
			dto.setVillage(p.getVillage());
			dto.setVisitDate(p.getVisitDate());
			dto.setChildNo(p.getChildNo());
			dto.setDaysBetweenPdateAndFdate(p.getDaysBetweenPdateAndFdate());
			dto.setDaysBetweenPdateAndRdate(p.getDaysBetweenPdateAndRdate());
			dto.setDaysBetweenPdateAndVdate(p.getDaysBetweenPdateAndVdate());
			dto.setRegisteredDate(p.getRegisteredDate());
			listDTO.add(dto);
		});
		return listDTO;

	}

	@Override
	public List<DevoteeDTO> searchDevoteesByStringData(String fieldType, String fieldValue) throws Exception {
		DevoteeDAO dao = null;

		List<DevoteeBO> listBo = null;
		List<DevoteeDTO> listDTO = new ArrayList<DevoteeDTO>();
		// get DAO
		dao = DevoteeDAOFactory.getInstance();
		// use DAO
		listBo = dao.getDevoteesByStringData(fieldType, fieldValue);
		// convert listDevoteeBO to listDevoteeDTO
		listBo.forEach(p -> {
			DevoteeDTO dto = null;
			dto = new DevoteeDTO();
			dto.setId(p.getDevoteeId());
			dto.setName(p.getName());
			dto.setHusbandName(p.getHusbandName());
			dto.setDistrict(p.getDistrict());
			dto.setMandal(p.getMandal());
			dto.setMobileNo(p.getMobileNo());
			dto.setOtherDetails(p.getOtherDetails());
			dto.setPregnancyDate(p.getPregnancyDate());
			dto.setFirstDate(p.getFirstDate());
			dto.setVisitStatus(p.getVisitStatus());
			dto.setStatus(p.getStatus());
			dto.setVillage(p.getVillage());
			dto.setVisitDate(p.getVisitDate());
			dto.setChildNo(p.getChildNo());
			dto.setDaysBetweenPdateAndFdate(p.getDaysBetweenPdateAndFdate());
			dto.setDaysBetweenPdateAndRdate(p.getDaysBetweenPdateAndRdate());
			dto.setDaysBetweenPdateAndVdate(p.getDaysBetweenPdateAndVdate());
			dto.setRegisteredDate(p.getRegisteredDate());
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public DevoteeDTO searchDevoteesByMobile(String fieldType, String fieldValue) throws Exception {
		DevoteeDAO dao = null;

		DevoteeBO bo = null;
		DevoteeDTO dto = null;
		// get DAO
		dao = DevoteeDAOFactory.getInstance();
		// use DAO
		bo = dao.getDevoteesByMobile(fieldType, fieldValue);
		// convert listDevoteeBO to listDevoteeDTO
		if (bo != null) {
			dto = new DevoteeDTO();

			dto.setId(bo.getDevoteeId());
			dto.setName(bo.getName());
			dto.setHusbandName(bo.getHusbandName());
			dto.setDistrict(bo.getDistrict());
			dto.setMandal(bo.getMandal());
			dto.setMobileNo(bo.getMobileNo());
			dto.setOtherDetails(bo.getOtherDetails());
			dto.setPregnancyDate(bo.getPregnancyDate());
			dto.setFirstDate(bo.getFirstDate());
			dto.setVisitStatus(bo.getVisitStatus());
			dto.setStatus(bo.getStatus());
			dto.setVillage(bo.getVillage());
			dto.setVisitDate(bo.getVisitDate());
			dto.setChildNo(bo.getChildNo());
			dto.setDaysBetweenPdateAndFdate(bo.getDaysBetweenPdateAndFdate());
			dto.setDaysBetweenPdateAndRdate(bo.getDaysBetweenPdateAndRdate());
			dto.setDaysBetweenPdateAndVdate(bo.getDaysBetweenPdateAndVdate());
			dto.setRegisteredDate(bo.getRegisteredDate());
		}
		return dto;
	}

	@Override
	public DevoteeDTO searchDevoteesByMobileNoOrId(String fieldType, String fieldValue) throws Exception {
		DevoteeDAO dao = null;

		DevoteeBO bo = null;
		DevoteeDTO dto = null;
		// get DAO
		dao = DevoteeDAOFactory.getInstance();
		// use DAO
		bo = dao.getDevoteesByMobileNoOrId(fieldType, fieldValue);
		// convert listDevoteeBO to listDevoteeDTO
		if (bo != null) {
			dto = new DevoteeDTO();

			dto.setId(bo.getDevoteeId());
			dto.setName(bo.getName());
			dto.setHusbandName(bo.getHusbandName());
			dto.setDistrict(bo.getDistrict());
			dto.setMandal(bo.getMandal());
			dto.setMobileNo(bo.getMobileNo());
			dto.setOtherDetails(bo.getOtherDetails());
			dto.setPregnancyDate(bo.getPregnancyDate());
			dto.setFirstDate(bo.getFirstDate());
			dto.setVisitStatus(bo.getVisitStatus());
			dto.setStatus(bo.getStatus());
			dto.setVillage(bo.getVillage());
			dto.setVisitDate(bo.getVisitDate());
			dto.setChildNo(bo.getChildNo());
			dto.setDaysBetweenPdateAndFdate(bo.getDaysBetweenPdateAndFdate());
			dto.setDaysBetweenPdateAndRdate(bo.getDaysBetweenPdateAndRdate());
			dto.setDaysBetweenPdateAndVdate(bo.getDaysBetweenPdateAndVdate());
			dto.setRegisteredDate(bo.getRegisteredDate());
		}
		return dto;
	}

	@Override
	public LocalDate addMoreDaysToPregnancyDateToGetFirstDate(int differenceBetweenPdateAndFdate, LocalDate firstDate)
			throws Exception {
		int addMoreDays = 0, addMoreDaysToGetThursday = 0;
		if (differenceBetweenPdateAndFdate >= 64 && differenceBetweenPdateAndFdate <= 69) {
			//if the days between pdate and fdate is from 64 to 69 add 7 more days to get alternate next thursday
			addMoreDays = (70 - differenceBetweenPdateAndFdate) + (7 - (70 - differenceBetweenPdateAndFdate) % 7) + 7;
			addMoreDaysToGetThursday = -firstDate.plusDays(addMoreDays).getDayOfWeek().compareTo(DayOfWeek.THURSDAY);
		} else {
			addMoreDays = (70 - differenceBetweenPdateAndFdate) + (7 - (70 - differenceBetweenPdateAndFdate) % 7);
			addMoreDaysToGetThursday = -firstDate.plusDays(addMoreDays).getDayOfWeek().compareTo(DayOfWeek.THURSDAY);
		}
		return firstDate.plusDays(addMoreDays + addMoreDaysToGetThursday);
	}

	@Override
	public float calculateSuccessDevoteesPercentage() throws Exception {
		DevoteeDAO dao = null;
		float successPercentage = 0.0f;
		// get DAO
		dao = DevoteeDAOFactory.getInstance();
		// use DAO
		successPercentage = dao.getSuccessDevoteesPercentage();
		return successPercentage;
	}

}
