package edu.mum.cs.cs425.eRegistrar;

import edu.mum.cs.cs425.eRegistrar.model.Student;
import edu.mum.cs.cs425.eRegistrar.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ERegistrarApplication implements CommandLineRunner {
	@Autowired
	IStudentRepository iStudentRepository;
  	 public static void main(String[] args) {
		SpringApplication.run(ERegistrarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student = new Student("100-10","bareket","gerezh","gebremesel",3.8, LocalDate.of(2019,11,27),true);

		iStudentRepository.save(student);
  	 }
}
