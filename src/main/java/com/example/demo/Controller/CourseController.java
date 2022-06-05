package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Courses;
import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.Service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping ("/courses")
	public List<Courses> getAllCourses(){		
		return courseService.getAllCourses();
	}
	
	@RequestMapping ("/courses/{id}")
	public Courses getCourse(@PathVariable String id){		
		Courses c= courseService.getCourse(id);
		if(c==null) {
			throw new UserNotFoundException();
		}
		return c;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/courses")
	public void addCourse(@RequestBody Courses course) {
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/courses/{id}")
	public void updateCourse(@RequestBody Courses course,@PathVariable("id") String id) {
		courseService.updateCourse(id,course);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}")
	public void deleteCourse(@PathVariable("id") String id) {
		courseService.deleteCourse(id);
	}
	
}
