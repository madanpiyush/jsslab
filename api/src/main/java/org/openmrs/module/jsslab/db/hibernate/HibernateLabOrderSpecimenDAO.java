package org.openmrs.module.jsslab.db.hibernate;

import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.APIException;
import org.openmrs.module.jsslab.db.LabOrderSpecimen;
import org.openmrs.module.jsslab.db.LabOrderSpecimenDAO;

public class HibernateLabOrderSpecimenDAO implements LabOrderSpecimenDAO {

	private SessionFactory sessionFactory;
	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		
	}
	@Override
	public LabOrderSpecimen getLabOrderSpecimenByUuid(String uuid) {
		return (LabOrderSpecimen)this.sessionFactory.getCurrentSession().createCriteria(LabOrderSpecimen.class)
				.add(Restrictions.eq("uuid", uuid)).uniqueResult();
	}

	@Override
	public LabOrderSpecimen saveLabOrderSpecimen(LabOrderSpecimen labOrderSpecimen) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(labOrderSpecimen);
		labOrderSpecimen.getOrder().getOrderSpecimens().add(labOrderSpecimen);
		labOrderSpecimen.getSpecimen().getOrderSpecimens().add(labOrderSpecimen);
		return labOrderSpecimen;
	}

	@Override
	public void deleteLabOrderSpecimen(LabOrderSpecimen labOrderSpecimen) {
		this.sessionFactory.getCurrentSession().delete(labOrderSpecimen);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.openmrs.module.jsslab.db.LabOrderSpecimenDAO#getLabOrderSpecimenByName(java.lang.String)
	 * 
	 * Maybe the method doesn't need implement LabOrderSpecimen
	 */
	@Override
	public LabOrderSpecimen getLabOrderSpecimenByName(String labOrderSpecimen) {
		throw new NotImplementedException();
	}
	
	/**
	 * @see LabOrderSpecimenDAO#getLabOrderSpecimens(String, Boolean, Integer, Integer)
	 */
	@SuppressWarnings("unchecked")
	public List<LabOrderSpecimen> getLabOrderSpecimens(String nameFragment, Boolean includeVoided, Integer start, Integer length) {
		Criteria criteria = sessionFactory.getCurrentSession()
			.createCriteria(LabOrderSpecimen.class);
//		TODO add filters back
//			.createAlias("order","o").createAlias("specimen", "s");
//		if (!includeVoided)
//			criteria.add(Restrictions.ne("voided", true));
//		
//		if (StringUtils.isNotBlank(nameFragment))
//			criteria.add(Restrictions.disjunction()
//				.add(Restrictions.eq("o.uuid", nameFragment))
//				.add(Restrictions.eq("s.uuid", nameFragment))
//			);
//		
//		criteria.addOrder(Order.asc("o.uuid")).addOrder(Order.asc("s.uuid"));
		
		if (start != null)
			criteria.setFirstResult(start);
		if (length != null && length > 0)
			criteria.setMaxResults(length);
		
		return (List<LabOrderSpecimen>) criteria.list();
	}
	
	@Override
	public Integer getCountOfLabOrderSpecimens(Boolean includeVoided)
			throws APIException {
		return getLabOrderSpecimens("", includeVoided, null, null).size();
	}
	
}
