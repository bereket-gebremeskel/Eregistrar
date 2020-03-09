package edu.mum.cs.cs425.eRegistrar.service.iService;

import edu.mum.cs.cs425.eRegistrar.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();

    Student save(Student student);

    Student findOne(Long id);

    void delete(Long id);

    List<Student> searchStudents(Student student);

    List<Student> findByKeyWord(String keyword);

}
