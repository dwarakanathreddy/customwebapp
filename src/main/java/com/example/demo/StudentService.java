package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private List<Student> students = new ArrayList<Student>(Arrays.asList(
			new Student("dwarak","2"),
			new Student("tarak","3")
			));
	
	public List<Student> get_students(){
		return students;
	}
	
	public void add_students(Student student) {
		students.add(student);
	}
	
	public Student get_students(String id) {
		return students.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}
	
	public void delete_student(String id) {
		students.remove(students.stream().filter(t->t.getId().equals(id)).findFirst().get());
	}
}
