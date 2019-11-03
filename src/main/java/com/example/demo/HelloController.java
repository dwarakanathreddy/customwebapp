package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private StudentService studentservice = new StudentService();
	@RequestMapping("/hello")
	@ResponseBody
	public List<Student> hello() {
//		return "hello dwarak";
		return studentservice.get_students();
	}
	@RequestMapping("/hello/{id}")
	public Student getstudent(@PathVariable String id) {
		return studentservice.get_students(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/hello")
	public String addStudent(@RequestBody Student student) {
		studentservice.add_students(student);
		return "successfully added";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/hello/{id}")
	public String deleteStudent(@PathVariable String id) {
		studentservice.delete_student(id);
		return "deleted";
	}
}
