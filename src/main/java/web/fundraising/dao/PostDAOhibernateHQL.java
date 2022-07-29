package web.fundraising.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import web.fundraising.vo.PostBean;

public class PostDAOhibernateHQL implements PostDAO {
	
	private Session session;
	
//	public PostDAOhibernateHQL(Session session) {
//		this.session = session;
//	}
	
	@Override
	public PostBean insert(PostBean postBean) {
		if(postBean != null && postBean.getPostID() == null) {			
			this.session.save(postBean);
			return postBean;				
		}
		return null;
	}

	@Override
	public Boolean delete(Integer id) {
		if(id != null && id >0) {
			PostBean delete = this.session.get(PostBean.class, id);
			if(delete != null) {
				this.session.delete(delete);
				return true;
			}
		}
		return null;
	}

	@Override
	public PostBean update(Integer id, PostBean postBean) {
		if(id != null && id > 0 && postBean != null && postBean.getPostID() == null) {			
			PostBean update = this.session.get(PostBean.class, id);
			if(update != null) {
				this.session.save(update);
				return update;				
			}
		}
		return null;
	}

	@Override
	public PostBean select(Integer id) {
		if(id != null && id >0) {
			return this.session.get(PostBean.class, id);
		}
		return null;
	}

	@Override
	public List<PostBean> selectAll() {
		Query<PostBean> qurey = this.session.createQuery("from Fund_POST", PostBean.class);
		List<PostBean> result = qurey.list();
		return result;
	}
	
}
