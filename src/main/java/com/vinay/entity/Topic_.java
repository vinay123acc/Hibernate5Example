package com.vinay.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Topic.class)
public abstract class Topic_ {

	public static volatile SingularAttribute<Topic, String> topicName;
	public static volatile SingularAttribute<Topic, Course> course;
	public static volatile SingularAttribute<Topic, Long> id;

}

