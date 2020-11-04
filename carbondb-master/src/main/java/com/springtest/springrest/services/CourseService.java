package com.springtest.springrest.services;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springtest.springrest.entities.Course;
@Service
public interface CourseService {

	public List<Course> getCourses();

	public Course getCourse(String courseId);

	public Course addCourse(Course course);

	public void updateCourse(Course course, String courseId);

}
