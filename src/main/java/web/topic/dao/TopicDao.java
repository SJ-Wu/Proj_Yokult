package web.topic.dao;

import java.util.List;

import web.topic.vo.Topic;

public interface TopicDao {
	Integer insert (Topic topic);
	List<Topic> selectAll();
	Integer update(Topic topic);
	Integer delete(Topic topic);
	
}
