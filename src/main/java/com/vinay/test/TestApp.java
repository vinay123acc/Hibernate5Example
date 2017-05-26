package com.vinay.test;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vinay.entity.Course;
import com.vinay.entity.Course_;
import com.vinay.entity.Topic;
import com.vinay.util.HibernateUtil;

public class TestApp {


	Session session = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TestApp app = new TestApp();
		// app.addCourse("Hindi");
		// app.addTopic("Chemistry");
		app.listCourse();
	}


	private void addCourse(String courseName) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();

			Course course = new Course();
			course.setCourseName(courseName);

			Topic topic = new Topic();
			topic.setTopicName("TopicName:" + courseName);
			topic.setCourse(course);

			course.getTopics().add(topic);

			session.save(course);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

	}


	private void addTopic(String topicName) {

		try {
			session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();

			Topic topic = new Topic();
			topic.setTopicName(topicName);

			session.save(topic);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

	}

	private void listCourse() {
		session = HibernateUtil.getSession();
		CriteriaQuery<Course> courseQuery = session.getCriteriaBuilder().createQuery(Course.class);
		Root<Course> courseRoot = courseQuery.from(Course.class);

		courseQuery.select(courseRoot);
		courseQuery.where(session.getCriteriaBuilder().equal(courseRoot.get(Course_.courseName), "Physics"));

		List<Course> courses = session.createQuery(courseQuery).getResultList();

		for (Course course : courses) {
			System.out.println(course);
			for (Topic topic : course.getTopics()) {
				System.out.println(topic);
			}
		}

	}

}
