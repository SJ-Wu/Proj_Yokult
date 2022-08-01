package web.topic.service;

import java.util.List;

import web.topic.vo.Topic;

public interface TopicService {
	List<Topic> selectAll();
	
	Integer update(Topic topic);
	
	Integer modify(Topic topic);

	Integer remove(Topic topic);
}
