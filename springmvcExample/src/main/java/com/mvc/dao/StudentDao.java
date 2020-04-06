package com.mvc.dao;
import java.util.List;
import com.mvc.entity.Student;

public interface StudentDao {
	public void saveStudent(Student student);
	List<Student> findStudent(Student student);
}
