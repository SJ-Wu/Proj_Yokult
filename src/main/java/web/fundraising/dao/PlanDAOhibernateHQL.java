package web.fundraising.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.hibernate.HibernateUtil;
import web.fundraising.vo.PlanBean;

public class PlanDAOhibernateHQL implements PlanDAO {
	
	private Session session;
	
//	public PlanDAOhibernateHQL(Session session) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		this.session = session;
//		System.out.println("Session opened.");
//	}
//	public void SessionClose() {
//		session.close();
//		System.out.println("Session closed.");
//	}
	
	@Override
	public PlanBean insert(PlanBean planBean) {
		if(planBean != null && planBean.getPlanID() == null) {			
			this.session.save(planBean);
			return planBean;				
		}
		return null;
	}

	@Override
	public Boolean delete(Integer id) {
		if(id != null && id >0) {
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
		if(id != null && id > 0 && planBean != null && planBean.getPlanID() == null) {			
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
		if(id != null && id >0) {
			return this.session.get(PlanBean.class, id);
		}
		return null;
	}

	@Override
	public List<PlanBean> selectAll() {
		Query<PlanBean> qurey = this.session.createQuery("from PlanBean", PlanBean.class);
		List<PlanBean> result = qurey.list();
		return result;
	}
	
}
