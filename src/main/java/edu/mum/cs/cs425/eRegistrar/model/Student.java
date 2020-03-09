package edu.mum.cs.cs425.eRegistrar.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;

    @Column(name = "student_number")
    @NotBlank
    private String studentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private double cGpa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    private boolean isInternational;
    public Student() {

    }

    public Student( @NotBlank String studentNumber, String  firstName, String middleName, String lastName, double cGpa, LocalDate enrollmentDate, boolean isInternational) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cGpa = cGpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getcGpa() {
        return cGpa;
    }

    public void setcGpa(double cGpa) {
        this.cGpa = cGpa;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public boolean getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(boolean isInternational) {
        this.isInternational = isInternational;
    }
}
