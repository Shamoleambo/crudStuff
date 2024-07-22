package com.tidz.crudStuff.dao;

import com.tidz.crudStuff.entity.Instructor;
import com.tidz.crudStuff.entity.InstructorDetail;

public interface AppDAO {

	void save(Instructor instructor);

	Instructor findInstructorById(int id);

	void deleteInstructorById(int id);

	InstructorDetail findInstructorDetailById(int id);
}
