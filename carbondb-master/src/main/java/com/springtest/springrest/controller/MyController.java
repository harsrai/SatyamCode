package com.springtest.springrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springtest.springrest.dao.CourseDaoInterface;
import com.springtest.springrest.entities.Course;
import com.springtest.springrest.services.CourseService;

@RestController
public class MyController {

	Logger log = LoggerFactory.getLogger(MyController.class);

	@Autowired
	private CourseService courseService;
   @Autowired
	CourseDaoInterface courseDaoInterface ;

		// get the all courses
		@GetMapping("/courses")
		public ResponseEntity<List<Course>> getCourses() {
			String methodName = "CourseServiceImpl.getCourses";
			log.debug("{} called", methodName);
			String id = "111";
			//Course coursesample = new Course("1234", "sample", "sample");
			//Course saved = courseDaoInterface.save(coursesample);
			//log.debug("saved: " + saved);
			Iterable<Course> dblist = courseDaoInterface.findAll();
			List<Course> list = new ArrayList<Course>();
			for(Course c : dblist) {
				log.debug("course: " + c);
				list.add(c);
			}
			//List<Course> list = (List<Course>) courseDaoInterface.getCourses( );
//			 List<Course> list = (List<Course>) courseDaoInterface.getCourses(id);
			
			if (list.size() <= 0) {
				log.info("Started");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			} else {
				return ResponseEntity.of(Optional.of(list));
			}
		}

		// get single the course
		@GetMapping("/courses/{courseId}")
		public ResponseEntity<Course> getCourse(@PathVariable String courseId)

		{
			String methodName = "CourseServiceImpl.getCourse";
			log.debug("{} called", methodName);
			Course course = courseService.getCourse(courseId);
			if (course == null) {
				log.warn("Received 0 results for search string");
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.of(Optional.of(course));
		}

//Add Course
		@PostMapping("/courses")
		public ResponseEntity<Course> addCourse(@RequestBody Course course) {
			String methodName = "CourseServiceImpl.addCourse";
			log.debug("{} called", methodName);
			try {
				Course b = null;
				b = this.courseService.addCourse(course);
				return ResponseEntity.of(Optional.of(b));
			} catch (Exception e) {
				log.error("Error happened in the add Courses endpoint", e);
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

		}

		// update course
		@PutMapping("/courses/{courseId}")
		public Course updateCourse(@RequestBody Course course, @PathVariable("courseId") String courseId) {
			String methodName = "CourseServiceImpl.updateCourse";
			log.debug("{} called", methodName);
			this.courseService.updateCourse(course, courseId);
			return course;
		}
	}

