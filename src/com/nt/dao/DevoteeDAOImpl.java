package com.nt.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;

import com.nt.bo.DevoteeBO;
import com.nt.bo.DevoteeSuccessBO;
import com.nt.utility.HibernateUtil;

public class DevoteeDAOImpl implements DevoteeDAO {
	 private static final String CALL_PROCEDURE_SUCESS_PERCENTAGE="{call calculate_success_percentage(?)}";


	@Override
	public int insertDevotee(DevoteeBO bo) throws Exception {
		Session ses = null;
		Transaction tx = null;
		int idVal = 0;
		boolean flag = false;

		// get session
		ses = HibernateUtil.getSession();

		try {
			tx = ses.beginTransaction();
			idVal = (Integer) ses.save(bo);
			flag = true;

		} catch (HibernateException he) {
			flag = false;
			he.printStackTrace();
			System.out.println("HibernateException1 ..... Object not saved/inserted..");
			throw he;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			System.out.println("Exception1 .... Object not saved/inserted..");
			throw e;
		} finally {
			if (flag == true) {
				tx.commit();
				System.out.println("Object saved/inserted successfully..");
				System.out.println("Registration Id is:: " + idVal);
			} else {
				tx.rollback();
				System.out.println("Object not saved/inserted..");

			}

		}

		return idVal;

	}

	@Override
	public List<DevoteeBO> getDevotees(int startPos, int pageSize) {
		Session ses = null;
		Criteria criteria = null;
		List<DevoteeBO> list = null;

		try {
			// get session
			ses = HibernateUtil.getSession();
			// prepare QBC logic
			criteria = ses.createCriteria(DevoteeBO.class);
			// set first record of the page and number of records per page
			criteria.setFirstResult(startPos);
			criteria.setMaxResults(pageSize);

			// execute QBC logic
			list = criteria.list();
		} catch (HibernateException he) {
			throw he;
		} catch (Exception e) {
			throw e;
		}

		// return list
		return list;
	}

	@Override
	public List<DevoteeSuccessBO> getSuccessDevotees(int startPos, int pageSize) {
		Session ses = null;
		Criteria criteria = null;
		List<DevoteeSuccessBO> list = null;
		// get session
		ses = HibernateUtil.getSession();
		// prepare QBC logic
		criteria = ses.createCriteria(DevoteeSuccessBO.class);
		// set first record of the page and number of records per page
		criteria.setFirstResult(startPos);
		criteria.setMaxResults(pageSize);
		// execute QBC logic
		list = criteria.list();
		// return list
		return list;
	}

	@Override
	public long rowCount(Class obj) throws Exception {
		Session ses = null;
		Criteria criteria = null;
		Projection p = null;
		List<?> list = null;
		long count = 0L;
		// get session
		ses = HibernateUtil.getSession();
		// prepare QBC logic
		criteria = ses.createCriteria(obj);
		// create Projection
		p = Projections.rowCount();
		// add Projection obj Criteria
		criteria.setProjection(p);
		// execute QBC
		list = criteria.list();
		count = (Long) list.get(0);
		return count;
	}

	@Override
	public float getSuccessDevoteesPercentage() throws Exception {
		Session ses = null;
		float successPercentage = 0.0f;
		// get Session object
		ses = HibernateUtil.getSession();
		try {
			// call Pl/SQL procedure through Callback interface
			successPercentage =  ses.doReturningWork(new ReturningWork<Float>() {

				@Override
				public Float execute(Connection con) throws SQLException {
					CallableStatement cs = null;
					float result = 0.0f;
					// write CallableStatement obj based JDBC code
					cs = con.prepareCall(CALL_PROCEDURE_SUCESS_PERCENTAGE);
					// register OUT params with jdbc types
					cs.registerOutParameter(1, Types.FLOAT);
					// execute PL/SQL Procedure
					cs.execute();
					// get result from out param
					result = cs.getFloat(1);
					return result;
				}// execute(-)
			}// anonymous inner class
			);// method call

		} catch (HibernateException he) {
			he.printStackTrace();
			throw he;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return successPercentage;
	}//method

	@Override
	public DevoteeBO getDevoteeById(int id) throws Exception {
		Session ses = null;
		DevoteeBO bo = null;
		// get session
		ses = HibernateUtil.getSession();
		// get Object/Load object
		bo = ses.get(DevoteeBO.class, id);
		return bo;
	}

	@Override
	public void updateDevoteeById(int id, String visitStatus, String status) throws Exception {
		Session ses = null;
		Transaction tx = null;

		DevoteeBO bo = null;

		boolean flag = false;

		// get session
		ses = HibernateUtil.getSession();

		try {
			tx = ses.beginTransaction();
			// call getDevoteeById(id); method to get the obj by passsing id
			bo = getDevoteeById(id);
			bo.setVisitStatus(visitStatus);
			bo.setStatus(status);
			ses.update(bo);
			flag = true;

		} catch (HibernateException he) {
			flag = false;
			he.printStackTrace();
			System.out.println("HibernateException1 ..... Object not updated..");
			throw he;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			System.out.println("Exception1 .... Object not updated..");
			throw e;
		} finally {
			if (flag == true) {
				tx.commit();
				System.out.println("Object updated successfully..");
			} else {
				tx.rollback();
				System.out.println("Object not updated..");

			}

		}

	}

	@Override
	public boolean moveDevotee(int devoteeId) throws Exception {
		Session ses = null;
		DevoteeBO devotee = null;
		DevoteeSuccessBO sucessDevotee = null;
		boolean srcFlag = false, destFlag = false, finalResultFlag = false;
		Transaction tx = null;

		// get Session
		ses = HibernateUtil.getSession();
		// get Object from Devotee_REGISTER Table

		try {

			devotee = ses.get(DevoteeBO.class, devoteeId);
			// store object into Devotee_SUCCESS Table
			sucessDevotee = new DevoteeSuccessBO();
			sucessDevotee.setDevoteeId(devotee.getDevoteeId());
			sucessDevotee.setName(devotee.getName());
			sucessDevotee.setHusbandName(devotee.getHusbandName());
			sucessDevotee.setMobileNo(devotee.getMobileNo());
			sucessDevotee.setVillage(devotee.getVillage());
			sucessDevotee.setMandal(devotee.getMandal());
			sucessDevotee.setDistrict(devotee.getDistrict());
			sucessDevotee.setPregnancyDate(devotee.getPregnancyDate());
			sucessDevotee.setFirstDate(devotee.getFirstDate());
			sucessDevotee.setVisitDate(devotee.getVisitDate());
			sucessDevotee.setVisitStatus(devotee.getVisitStatus());
			sucessDevotee.setStatus(devotee.getStatus());
			sucessDevotee.setOtherDetails(devotee.getOtherDetails());
			sucessDevotee.setChildNo(devotee.getChildNo());
			sucessDevotee.setDaysBetweenPdateAndFdate(devotee.getDaysBetweenPdateAndFdate());
			sucessDevotee.setDaysBetweenPdateAndRdate(devotee.getDaysBetweenPdateAndRdate());
			sucessDevotee.setDaysBetweenPdateAndVdate(devotee.getDaysBetweenPdateAndVdate());
			sucessDevotee.setRegisteredDate(devotee.getRegisteredDate());

			// begin Tx
			tx = ses.beginTransaction();
			// devotee.setStatus("active");
			ses.save(sucessDevotee);
			destFlag = true;
			ses.delete(devotee);
			srcFlag = true;
			tx.commit();
		} catch (HibernateException he) {
			System.out.println("in HB");
			srcFlag = false;
			destFlag = false;
			tx.rollback();
			throw he;
		} catch (Exception e) {
			System.out.println("in E");
			srcFlag = false;
			destFlag = false;
			tx.rollback();
			throw e;
		} finally {
			if (srcFlag == false || destFlag == false) {
				System.out.println("Record not moved");
				finalResultFlag = false;
				System.out.println(finalResultFlag + " finalResultFlag");

			} else {
				System.out.println("Record  moved");
				finalResultFlag = true;
				System.out.println(finalResultFlag + " finalResultFlag");

			}
			// close objects
			HibernateUtil.closeSesion();

		} // finally
		System.out.println(finalResultFlag + "::finalResultFlag");
		return finalResultFlag;
	}

	@Override
	public List<DevoteeBO> getDevoteesByDate(String fieldType, LocalDate fromDate, LocalDate toDate) throws Exception {
		Session ses = null;
		Criteria criteria = null;
		Criterion searchByFieldTypeDate = null;
		List<DevoteeBO> list = null;
		// get session
		ses = HibernateUtil.getSession();
		// prepare QBC logic
		criteria = ses.createCriteria(DevoteeBO.class);
		// create condition based on firstDate
		searchByFieldTypeDate = Restrictions.between(fieldType, fromDate, toDate);
		// add condition
		criteria.add(searchByFieldTypeDate);
		// execute QBC logic
		list = criteria.list();
		// return list
		return list;

	}

	@Override
	public List<DevoteeBO> getDevoteesByStringData(String fieldType, String fieldValue) throws Exception {
		Session ses = null;
		Criteria criteria = null;
		Criterion searchByFieldType = null;
		List<DevoteeBO> list = null;
		// get session
		ses = HibernateUtil.getSession();
		// prepare QBC logic
		criteria = ses.createCriteria(DevoteeBO.class);
		// create condition based on firstDate
		// searchByFieldType = Restrictions.ilike(fieldType, fieldValue);
		searchByFieldType = Restrictions.sqlRestriction(" " + fieldType + " like '%" + fieldValue + "%'");
		// add condition
		criteria.add(searchByFieldType);
		// execute QBC logic
		list = criteria.list();
		// return list
		return list;
	}

	@Override
	public DevoteeBO getDevoteesByMobile(String fieldType, String fieldValue) throws Exception {
		Session ses = null;
		Criteria criteria = null;
		Criterion searchByFieldType = null;
		List<DevoteeBO> list = null;
		// get session
		ses = HibernateUtil.getSession();
		// prepare QBC logic
		criteria = ses.createCriteria(DevoteeBO.class);
		// create condition based on firstDate
		searchByFieldType = Restrictions.eq(fieldType, Long.parseLong(fieldValue));
		// add condition
		criteria.add(searchByFieldType);
		// execute QBC logic
		list = criteria.list();
		// return list
		return list.get(0);
	}

	@Override
	public DevoteeBO getDevoteesByMobileNoOrId(String fieldType, String fieldValue) throws Exception {
		Session ses = null;
		Criteria criteria = null;
		Criterion searchByFieldType = null;
		List<DevoteeBO> list = null;
		// get session
		ses = HibernateUtil.getSession();
		// prepare QBC logic
		criteria = ses.createCriteria(DevoteeBO.class);
		if (fieldType.equalsIgnoreCase("mobileNo")) {
			// create condition based on mobile No
			searchByFieldType = Restrictions.eq(fieldType, Long.parseLong(fieldValue));
		} else {
			// create condition based on mobile No
			searchByFieldType = Restrictions.eq(fieldType, Integer.parseInt(fieldValue));
			// searchByFieldType =
			// Restrictions.idEq(Integer.parseInt(fieldValue));
		}
		// add condition
		criteria.add(searchByFieldType);
		// execute QBC logic
		list = criteria.list();
		// return list
		return list.get(0);
	}

}