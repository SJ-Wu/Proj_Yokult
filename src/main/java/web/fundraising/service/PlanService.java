package web.fundraising.service;

import java.util.List;

import org.hibernate.Session;

import web.fundraising.dao.PlanDAO;
import web.fundraising.dao.PlanDAOhibernateHQL;
import web.fundraising.vo.PlanBean;

public class PlanService {
	PlanDAO PlanDAO;
	
	public PlanService() {
		this.PlanDAO = new PlanDAOhibernateHQL();
	}

	public PlanBean insertBean(PlanBean planBean) {
		return this.PlanDAO.insert(planBean);
	}
	public Boolean deleteBean(int id) {
		return this.PlanDAO.delete(id);
	}
	public PlanBean updateBean(int id, PlanBean planBean) {
		return this.PlanDAO.update(id, planBean);
	}
	public PlanBean selectBean(int id) {
		return this.PlanDAO.select(id);
	}
	public List<PlanBean> selectAllBeans() {
		return this.PlanDAO.selectAll();
	}
}
