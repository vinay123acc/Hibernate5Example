package com.vinay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="topics")
public class Topic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="topic_id")
	private long id;
	
	public Topic(){
		
	}
	
	public Topic(long id, String topicName) {
		super();
		this.id = id;
		this.topicName = topicName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	@Column(name="topic_name")
	private String topicName;
	
	@ManyToOne
	private Course course;

	@Override
	public String toString() {
		return "Topic [id=" + id + ", topicName=" + topicName + ", course="
				+ course + "]";
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
