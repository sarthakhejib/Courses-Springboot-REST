package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Controller.CourseController;
import com.example.demo.Entity.Courses;
import com.example.demo.Exceptions.EmptyInputException;

@Service
public class CourseService {

	private List<Courses> courseList = new ArrayList<>(Arrays.asList(

			new Courses("Data Structure", "DSA", "DSA Description"),
			new Courses("Spring", "Spring FrameWork", "Spring Description"),
			new Courses("Java", "Java FrameWork", "Java Description")
			));

	public List<Courses> getAllCourses() {
		return courseList;
	}

	public void addCourse(Courses course) {
		if(course.getName().isBlank() || course.getDescription().isBlank()|| course.getId().isBlank())
			throw new EmptyInputException();

		courseList.add(course);
	}

	public void updateCourse(String id, Courses course) {
		int count=0;
		for(Courses c:courseList) {
			if(c.getId().equals(id)) {
				courseList.set(count, course);
			}
			count++;
		}
	}

	public void deleteCourse(String id) {
		courseList.removeIf(course -> course.getId().equals(id));		
	}

	public Courses getCourse(String id) {
		for(Courses c: courseList) {
			if(c.getId().equals(id))
				return c;
		}
		return null;
	}

}
