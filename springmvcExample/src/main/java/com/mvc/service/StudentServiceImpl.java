package com.mvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.StudentDao;
import com.mvc.entity.Student;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
    private StudentDao studentDao;

	@Override
    @Transactional
    public void saveStudent(Student student) {
		studentDao.saveStudent(student);
    }

    @Override
    @Transactional
    public List<Student> findStudent(Student student) {
        return studentDao.findStudent(student);
    }

}
