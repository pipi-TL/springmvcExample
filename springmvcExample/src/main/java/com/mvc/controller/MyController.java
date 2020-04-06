package com.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.entity.Course;
import com.mvc.entity.Student;
import com.mvc.service.StudentService;

@Controller

public class MyController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping(value="/registerStudent")
    public String registerStudent(Student student){
        System.out.println(student);
        studentService.saveStudent(student);
        return "login";
    }
    
    @RequestMapping(value="/logout")
    public String logout(){
    	return "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(Student student, HttpSession session) {
        List<Student> studentList = studentService.findStudent(student);
        if(studentList.size() == 1){
            session.setAttribute("currentStudent", studentList.get(0));
            return "course";
        }else{
            return "login_failed";
        }
    }


    @RequestMapping(value="/registerCourse")
    public ModelAndView registerCourse(Course course, HttpSession session){
        Student currentStudent = (Student) session.getAttribute("currentStudent");
        course.setStudent(currentStudent);
        currentStudent.getCourses().add(course);
        studentService.saveStudent(currentStudent);
        session.setAttribute("courseList",currentStudent.getCourses());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("course");
        mv.addObject("courseName", course.getCourseName());

        return mv;
    }


    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return "denied";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "logout";
    }
}
