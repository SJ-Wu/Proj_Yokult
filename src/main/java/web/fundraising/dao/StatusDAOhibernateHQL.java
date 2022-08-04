package web.fundraising.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import web.fundraising.vo.StatusBean;

public class StatusDAOhibernateHQL implements StatusDAO {
	
	private Session session;
	
	public StatusDAOhibernateHQL(Session session) {
		this.session = session;
	}
	
	@Override
	public StatusBean insert(StatusBean statusBean) {
		if(statusBean != null && statusBean.getStatusID() == null) {			
			this.session.save(statusBean);
			return statusBean;				
		}
		return null;
	}

	@Override
	public Boolean delete(String id) {
		if(id != null && id.trim() != "" && id.trim().length() <= 2) {
			StatusBean delete = this.session.get(StatusBean.class, id);
			if(delete != null) {
				this.session.delete(delete);
				return true;
			}
		}
		return null;
	}

	@Override
	public StatusBean update(String id, StatusBean statusBean) {
		if(id != null && id.trim() != "" && id.trim().length() <= 2 && statusBean != null && statusBean.getStatusID() == null) {			
			StatusBean update = this.session.get(StatusBean.class, id);
			if(update != null) {
				this.session.save(update);
				return update;				
			}
		}
		return null;
	}

	@Override
	public StatusBean select(String id) {
		if(id != null && id.trim() != "" && id.trim().length() <= 2) {
			return this.session.get(StatusBean.class, id);
		}
		return null;
	}

	@Override
	public List<StatusBean> selectAll() {
		Query<StatusBean> qurey = this.session.createQuery("from StatusBean", StatusBean.class);
		List<StatusBean> result = qurey.list();
		return result;
	}
	
}
