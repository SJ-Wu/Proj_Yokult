package web.topic.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.topic.dao.TopicDao;
import web.topic.vo.Topic;

public class TopicDaoJDBC implements TopicDao {
	private DataSource datasource;

	public TopicDaoJDBC() throws NamingException {
		datasource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/Yokult");
	}

	final String SELECTALL = "select TOPID, TITLE, CONTENT, SORTID, VIEWS, POSTTIME from TOPIC;";

	@Override
	public List<Topic> selectAll() {
		try (Connection conn = datasource.getConnection(); PreparedStatement ps = conn.prepareStatement(SELECTALL);) {
			try (ResultSet rs = ps.executeQuery()) {
				List<Topic> topics = new ArrayList<Topic>();
				System.out.println("Show topic list:");
				while (rs.next()) {
					Topic t = new Topic();
					t.setTopid(rs.getInt("TOPID"));
					t.setTitle(rs.getString("TITLE"));
					t.setContent(rs.getString("CONTENT"));
					t.setSortid(rs.getInt("SORTID"));
					t.setViews(rs.getInt("VIEWS"));
					t.setPosttime(rs.getTimestamp("POSTTIME"));
					topics.add(t);
					System.out.println(t);
				}
				return topics;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer insert(Topic topic) {
		try (Connection conn = datasource.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("insert into TOPIC (TOPID, TITLE, CONTENT, SORTID, VIEWS, POSTTIME)"
								+ "values (?, ?, ?, ?, ?, ?);");) {
			ps.setInt(1, topic.getTopid());
			ps.setString(2, topic.getTitle());
			ps.setString(3, topic.getContent());
			ps.setInt(4, topic.getSortid());
			ps.setInt(5, topic.getViews());
			ps.setTimestamp(6, topic.getPosttime());

			int rowCount = ps.executeUpdate();
			System.out.println("insert " + rowCount + "topic.");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	final String UPDATE = "update TOPIC set TITLE = ?, CONTENT = ?, SORTID = ?, VIEWS = ?, POSTTIME = ? where TOPID = ?;";

	@Override
	public Integer update(Topic topic) {
		try (Connection conn = datasource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(UPDATE);) {
			pstmt.setString(1, topic.getTitle());
			pstmt.setString(2, topic.getContent());
			pstmt.setInt(3, topic.getSortid());
			pstmt.setInt(4, topic.getViews());
			pstmt.setTimestamp(5, topic.getPosttime());
			pstmt.setInt(6, topic.getTopid());
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " row(s) updated!!");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	

	final String DELETE = "delete from TOPIC where TOPID = ?;";
	@Override
	public Integer delete(Topic topic) {
		try (Connection conn = datasource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(DELETE);) {
			pstmt.setInt(1, topic.getTopid());
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " row(s) deleted!!");
			return rowCount;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
