package web.member.dao.impl;

import java.sql.Date;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import web.member.vo.Member;

public class MemberDaoImplHibernate {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		
		Member insert = new Member();
		insert.setMemID("TGA1990");
		insert.setMemPassword("123");
		insert.setMemEmail("abc@gmail.com");
		insert.setMemFirstName("Kevin");
		insert.setMemLastName("Hou");
		insert.setMemCellPhone("0912345678");
		Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());	
		
		insert.setMemBirth(sqlDate);
		session.save(insert);
		trx.commit();
		session.close();
		sessionFactory.close();

	}

}
