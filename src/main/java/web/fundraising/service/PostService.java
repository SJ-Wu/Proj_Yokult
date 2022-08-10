package web.fundraising.service;

import java.util.List;

import org.hibernate.Session;

import web.fundraising.dao.PostDAO;
import web.fundraising.dao.PostDAOhibernateHQL;
import web.fundraising.vo.PostBean;

public class PostService {
	PostDAO PostDAO;
	
	public PostService() {
		this.PostDAO = new PostDAOhibernateHQL();
	}
	
	public PostBean insertBean(PostBean postBean) {
		return this.PostDAO.insert(postBean);
	}
	public Boolean deleteBean(Integer id) {
		return this.PostDAO.delete(id);
	}
	public PostBean updateBean(Integer id, PostBean postBean) {
		return this.PostDAO.update(id, postBean);
	}
	public PostBean selectBean(Integer id) {
		return this.PostDAO.select(id);
	}
	public List<PostBean> selectAllBeans() {
		return this.PostDAO.selectAll();
	}
}
