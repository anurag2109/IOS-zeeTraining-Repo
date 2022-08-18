package com.zee.zee5app;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Arrays;

import javax.naming.InvalidNameException;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Employee;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.enums.Geners;
import com.zee.zee5app.exceptions.EntryAlreadyExistException;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;
import com.zee.zee5app.repo.EmployeeRepository;
import com.zee.zee5app.service.MovieServiceImpl;
import com.zee.zee5app.service.UserServiceImpl;

@SpringBootApplication
public class Zee5appApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = null;
		context =SpringApplication.run(Zee5appApplication.class, args);
		DataSource dataSource = context.getBean(DataSource.class);
		
		
		// ---------------- user operation ----------------------------------
		UserServiceImpl impl = context.getBean(UserServiceImpl.class);
		try {
			impl.insertuser(new User(true, LocalDate.now(), LocalDate.now(),"anu@gmail.com", "anurag", "karn","12345", "anu@123"));
			System.out.println(impl.getAllUsers().get());
		} catch (UnableToGenerateIdException | EntryAlreadyExistException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		// ---------------- movie operation ----------------------------------
//		MovieServiceImpl movieServiceImpl = context.getBean(MovieServiceImpl.class);
//		try {
//			movieServiceImpl.insertMovie(new Movie("ajay", "kajol",Geners.ACTION , "Hindi", 140.89f, "Lal singh chadda", "Dharma", "trailer"));
//			System.out.println(movieServiceImpl.getAllMoviesByName("Lal singh chadda"));
//		} catch (UnableToGenerateIdException | FileNotFoundException | InvalidNameException | InvalidIdException | NoDataFoundException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		
		
		// ---------------- Employee operation ----------------------------------
//		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
//		employeeRepository.save(new Employee("tech","Anurag", 11500000));
//		System.out.println(employeeRepository.findByDept("tech"));
//		System.out.println(employeeRepository.findBySalaryGreaterThan(11000000));
//		System.out.println(employeeRepository.findBySalaryGreaterThanEqual(11500000));
		context.close();
	}

}
