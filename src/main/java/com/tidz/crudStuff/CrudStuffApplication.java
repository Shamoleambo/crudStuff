package com.tidz.crudStuff;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tidz.crudStuff.dao.AppDAO;
import com.tidz.crudStuff.entity.Instructor;
import com.tidz.crudStuff.entity.InstructorDetail;

@SpringBootApplication
public class CrudStuffApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudStuffApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor instructor = new Instructor("Chad", "Darby", "darby@tidzcomp.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.tidztutos.com", "Podes crer");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);
		System.out.println("Done");
	}

}
