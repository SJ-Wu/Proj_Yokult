package web.topic.service.impl;

import java.util.List;

import javax.naming.NamingException;

import web.topic.dao.TopicDao;
import web.topic.dao.impl.TopicDaoJDBC;
import web.topic.service.TopicService;
import web.topic.vo.Topic;

public class TopicServiceImpl implements TopicService {
	private TopicDao dao;

	public TopicServiceImpl() throws NamingException {
		dao = new TopicDaoJDBC();
	}

	@Override
	public List<Topic> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Integer update(Topic topic) {
		return dao.insert(topic);
	}

	public Integer modify(Topic topic) {
		// 1. check if there is any null column in the not-null column

		return dao.update(topic);
	}

	@Override
	public Integer remove(Topic topic) {

		return dao.delete(topic);
	}

}
