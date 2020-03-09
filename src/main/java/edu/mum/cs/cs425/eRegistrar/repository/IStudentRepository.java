package edu.mum.cs.cs425.eRegistrar.repository;

import edu.mum.cs.cs425.eRegistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {
//    @Query("FROM Student WHERE firstName LIKE '%b'")
    List<Student> findByFirstName(String firstName);

    @Query(value="select * from students s where s.first_name like %:keyword%",nativeQuery = true)
    List<Student> findByKeyWord(@Param("keyword") String keyword);
//     or e.lastName like %:keyword%
}
