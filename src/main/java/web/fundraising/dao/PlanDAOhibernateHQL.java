package web.fundraising.dao;

import static web.fundraising.common.CommonJDBC.URL;
import static web.fundraising.common.CommonJDBC.USER;
import static web.fundraising.common.CommonJDBC.PASSWORD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Session;
import org.hibernate.query.Query;

import web.fundraising.vo.PlanBean;

public class PlanDAOhibernateHQL implements PlanDAO {
	
	private Session session;
	
	public PlanDAOhibernateHQL(Session session) {
		this.session = session;
	}
	
	@Override
	public PlanBean insert(PlanBean planBean) {
		if(planBean != null && planBean.getPlanID() >0) {			
			PlanBean insert = this.session.get(PlanBean.class, planBean.getPlanID());
			if(insert != null) {
				this.session.save(insert);
				return insert;				
			}
		}
		return null;
	}

	@Override
	public Boolean delete(Integer id) {
		if(id >0) {
			PlanBean delete = this.session.get(PlanBean.class, id);
			if(delete != null) {
				this.session.delete(delete);
				return true;
			}
		}
		return null;
	}

	@Override
	public PlanBean update(Integer id, PlanBean planBean) {
		if(planBean != null && planBean.getPlanID() >0) {			
			PlanBean update = this.session.get(PlanBean.class, id);
			if(update != null) {
				this.session.save(update);
				return update;				
			}
		}
		return null;
	}

	@Override
	public PlanBean select(Integer id) {
		if(id >0) {
			return this.session.get(PlanBean.class, id);
		}
		return null;
	}

	@Override
	public List<PlanBean> selectAll() {
		Query<PlanBean> qurey = this.session.createQuery("from Fund_PLAN", PlanBean.class);
		List<PlanBean> result = qurey.list();
		return result;
	}
	
}
