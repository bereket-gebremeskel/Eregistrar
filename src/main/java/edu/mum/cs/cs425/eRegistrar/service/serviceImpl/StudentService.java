package edu.mum.cs.cs425.eRegistrar.service.serviceImpl;

import edu.mum.cs.cs425.eRegistrar.model.Student;
import edu.mum.cs.cs425.eRegistrar.repository.IStudentRepository;
import edu.mum.cs.cs425.eRegistrar.service.iService.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
@Service
public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepository;

    @Autowired
    public StudentService(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = iStudentRepository.findAll();
        return students;
    }

    @Override
    public Student save(Student student) {
        Student st = iStudentRepository.save(student);
        return st;
    }

    @Override
    public Student findOne(Long id) {
        Student student = iStudentRepository.getOne(id);
        return student;
    }

    @Override
    public void delete(Long id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    public List<Student> searchStudents(Student student) {
        List<Student> st = iStudentRepository.findByFirstName(student.getFirstName());
        return st;
    }

    @Override
    public List<Student> findByKeyWord(String keyword) {
        iStudentRepository.findByKeyWord(keyword);
        return iStudentRepository.findByKeyWord(keyword);
    }
}
