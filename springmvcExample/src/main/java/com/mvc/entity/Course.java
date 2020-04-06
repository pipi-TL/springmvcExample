package com.mvc.entity;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
@Entity
@Table(name="t_course")
public class Course {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="course_name")
    private String courseName;
    @Column(name="department")
    private String department;


    @ManyToOne
    @JoinColumn(name="student_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
