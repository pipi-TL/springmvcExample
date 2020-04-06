package com.mvc.service;
import java.util.List;
import com.mvc.entity.Student;

public interface StudentService {
	public void saveStudent(Student student);
	public List<Student> findStudent(Student student);

}
