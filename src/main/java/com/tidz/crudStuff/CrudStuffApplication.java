package com.tidz.crudStuff;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tidz.crudStuff.dao.AppDAO;
import com.tidz.crudStuff.entity.Course;
import com.tidz.crudStuff.entity.Instructor;
import com.tidz.crudStuff.entity.InstructorDetail;
import com.tidz.crudStuff.entity.Review;
import com.tidz.crudStuff.entity.Student;

@SpringBootApplication
public class CrudStuffApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudStuffApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createCourseAndStudent(appDAO);
//			findCourseAndStudents(appDAO);
//			findStudentAndCourses(appDAO);
//			addMoreCoursesForStudent(appDAO);
//			deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int id = 2;
		System.out.println("Deleting student id: " + id);

		appDAO.deleteStudentById(id);
		System.out.println("Done!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int id = 2;
		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		Course course1 = new Course("Cars 101");
		Course course2 = new Course("Talk to fishes advanced");

		student.add(course1);
		student.add(course2);

		System.out.println("Updating student: " + student);
		System.out.println("associated courses: " + student.getCourses());

		appDAO.update(student);
		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int id = 1;

		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		System.out.println("Loaded student: " + student);
		System.out.println("Courses: " + student.getCourses());

		System.out.println("Done!");

	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int id = 10;

		Course course = appDAO.findCourseAndStudentsByCourseId(id);

		System.out.println("Loaded course: " + course);
		System.out.println("Students: " + course.getStudents());

		System.out.println("Done!");
	}

	private void createCourseAndStudent(AppDAO appDAO) {
		Course course = new Course("Pacman - how to score a lot!");

		Student student1 = new Student("Mano", "Dahora", "mano@mail.com");
		Student student2 = new Student("Truta", "Maneiro", "truta@mail.com");

		course.add(student1);
		course.add(student2);

		System.out.println("Saving the course: " + course);
		System.out.println("Associated students: " + course.getStudents());

		appDAO.save(course);
		System.out.println("Done!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		System.out.println("Deleting course id: " + id);
		appDAO.deleteCourseById(id);
		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseAndReviewsByCourseId(id);

		System.out.println(course);
		System.out.println(course.getReviews());
		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("sky");
		course.add(new Review("so bad"));
		course.add(new Review("not cool"));
		course.add(new Review("lame"));
		course.add(new Review("I liked it"));

		System.out.println("Saving the course");
		System.out.println(course);
		System.out.println(course.getReviews());

		appDAO.save(course);
		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;
		System.out.println("Deleting course id: " + id);

		appDAO.deleteCourseById(id);
		System.out.println("Done!");
	}

	private void deleteInstructorFromBeyond(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting instructor id: " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;
		System.out.println("Finding course id: " + id);
		Course course = appDAO.findCourseById(id);

		System.out.println("Updating course id: " + id);
		course.setTitle("Giriologia");

		appDAO.update(course);
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Updating the instructor id: " + id);
		instructor.setLastName("TESTER");

		appDAO.update(instructor);
		System.out.println("Done!");
	}

	private void findInstrucotrWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		System.out.println("Findind instructor id: " + id);

		Instructor instructor = appDAO.findInstructorByJoinFetch(id);

		System.out.println("instructor: " + instructor);
		System.out.println("the associated courses: " + instructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("instructor: " + instructor);

		System.out.println("Finding courses for instructor id: " + id);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		instructor.setCourses(courses);
		System.out.println("the associated courses: " + instructor.getCourses());

		System.out.println("Done!");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;

		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("instructor: " + instructor);
		System.out.println("the associated courses" + instructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Mano", "Dahora", "mano@tidzcomp.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.tidztutos", "Gírias");

		instructor.setInstructorDetail(instructorDetail);

		Course courseOne = new Course("Várias gíria");
		Course courseTwo = new Course("Gestos maneiros");

		instructor.add(courseOne);
		instructor.add(courseTwo);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());

		appDAO.save(instructor);
		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int id = 3;
		System.out.println("Deleting instructor detail id: " + id);

		appDAO.deleteInstructorDetailById(id);
		System.out.println("Done!");

	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 2;

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("InstructorDetail : " + instructorDetail);
		System.out.println("The associated instructor: " + instructorDetail.getInstructor());

		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Delete instructor id: " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("instructor: " + instructor);
		System.out.println("the associated instructorDetail only: " + instructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {

		Instructor instructor = new Instructor("Madhu", "Patel", "madhu@tidzcomp.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.tidztutos.com", "É nois");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);
		System.out.println("Done");
	}

}
