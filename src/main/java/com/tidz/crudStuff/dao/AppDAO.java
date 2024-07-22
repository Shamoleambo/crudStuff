package com.tidz.crudStuff.dao;

import java.util.List;

import com.tidz.crudStuff.entity.Course;
import com.tidz.crudStuff.entity.Instructor;
import com.tidz.crudStuff.entity.InstructorDetail;

public interface AppDAO {

	void save(Instructor instructor);

	Instructor findInstructorById(int id);

	void deleteInstructorById(int id);

	InstructorDetail findInstructorDetailById(int id);

	void deleteInstructorDetailById(int id);

	List<Course> findCoursesByInstructorId(int id);

	Instructor findInstructorByJoinFetch(int id);

	void update(Instructor instructor);

	void update(Course course);

	Course findCourseById(int id);

}
