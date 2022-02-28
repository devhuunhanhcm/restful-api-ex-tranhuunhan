package cybersoft.backend.java16.restfulapiexercise.restresource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.backend.java16.restfulapiexercise.model.Student;

@RestController
@RequestMapping("/students")
public class StudentResource {
	List<Student> students = new ArrayList<Student>();
	
	@GetMapping
	public Object getStudents() {
		return students;
	}
	
	@PostMapping
	public Object insertStudent(@RequestBody Student student) {
		Student entity = new Student();
		entity.setName(student.getName());
		entity.setAge(student.getAge());
		
		students.add(entity);
		return students;
	}
	
	@GetMapping("/add")
	public Object insertStudent2(@RequestParam(name = "name",required = false) String name,@RequestParam(name ="age",required = false) int age) {
		students.add(new Student(name,age));
		return students;
	}
	
	@GetMapping("/{name}/{age}")
	public Object insertStudent3(@PathVariable("name") String name,@PathVariable("age") int age) {
		students.add(new Student(name,age));
		return students;
	}
	
}
