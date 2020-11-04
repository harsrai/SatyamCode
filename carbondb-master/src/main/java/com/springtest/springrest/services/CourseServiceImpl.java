package com.springtest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//import com.springtest.springrest.dao.CourseDaoInterface;
import com.springtest.springrest.entities.Course;

@Service

public class CourseServiceImpl implements CourseService {
	//@Autowired
	//CourseDaoInterface courseDaoInterface;
	List<Course> list;

	public CourseServiceImpl() {

		list = new ArrayList<>();
		list.add(new Course("111", "JAVA COURSE ", " This course introduces JAVA programming language"));
		list.add(new Course("222", "ANGULAR COURSE ", "This course introduces ANGULAR programming language"));
		list.add(new Course("333", "SPRING BOOT ", "This course introduces SPRING BOOT programming language"));
	}

//	@Override
//	public List<Course> getCourses() {
//		// TODO Auto-generated method stub
//	//return courseDaoInterface.findAll("111");
//		return list;
//	}
//	}

	@Override
	public Course getCourse(String courseId) {

		Course c = null;
		try {

			for (Course course : list) {
				if (course.getId().equals(courseId)) {
					c = course;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public void updateCourse(Course course, String courseId) {
		list = list.stream().map(b -> {
			if (b.getId().equals(courseId)) {
				b.setTitle(course.getTitle());
				b.setDescription(course.getDescription());
			}
			return b;
		}).collect(Collectors.toList());
	}


	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return null;
	}
}
