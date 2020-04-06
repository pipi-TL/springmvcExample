package com.mvc.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mvc.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveStudent(Student student) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(student);	
	}

	public List<Student> findStudent(Student student) {
		String hql = "from Student where email=:inputEmail and password=:inputPassword";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("inputEmail", student.getEmail());
        query.setParameter("inputPassword", student.getPassword());
        return query.list();
	}

}
