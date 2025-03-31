package lk.ac.vau.fas.ict.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/app")
public class AppController {
	
	//Student object
	Student Ruz = new Student("2020ICT82","Ruzla", 23,"IT", 3.4);
	Student Bob = new Student("2020ICT01", "Bob", 23, "IT", 3.2);
	Student John = new Student("2020ICT20", "John", 24, "IT", 3.6);
	
	List<Student> students = new ArrayList<Student>();
	List<Student> studentsAge = new ArrayList<Student>();
	
	public AppController()
	{
		students.add(Ruz);
		students.add(Bob);
		students.add(John);
	}
	
//	@GetMapping("/msg")
//	public String myMessage()
//	{
//		return "Hello SpringBoot";
//	}
//	
//	@GetMapping("/name")
//	public String myName() 
//	{
//		return "My name is SpringBoot";
//	}
	
	@GetMapping("/age/{ag}")
	public String MyAge(@PathVariable("ag") int age)
	{
		return "My age is "+age;
	}
	
	@GetMapping("/details/{ag},{nm}")
	public String MyDetails(@PathVariable("ag") int age,@PathVariable("nm") String name)
	{
		return "My name is "+name+"\nMy age is "+age;
	}
	
	//method to return a student
	@GetMapping("/student")
	public Student getStudent() {
		return Ruz;
	}
	
	//method to return multiple students
	@GetMapping("/students")
	public List<Student> getStudents()
	{
//		students.add(Ruz);
//		students.add(Bob);
//		students.add(John);
		
		return students;
	}
	
	//Find a student from list by regNo
	@GetMapping("students/{reg}")
	public Student getStudentReg(@PathVariable("reg") String regNo)
	{
		for(Student student : students)
		{
			if(student.getRegNo().equals(regNo))
			{
				return student;
			}
		}
			return null;
	}
	
	//Find students whose age between 20-23
	@GetMapping("/ages")
	public List<Student> getStudentAge()
	{
		for(Student student : students)
		{
			if(student.getAge() > 19 && student.getAge() < 24)
			{
				studentsAge.add(student);
			}
		}
		return studentsAge;
	}
	
	//sort students by their gpa
		@GetMapping("/sortbyGPA")
		public List<Student> getSortedStudentbyGPA(){
			students.sort(Comparator.comparing(Student::getGpa));
			return students;
		}
		
    //CRUD operations for students
	//CREATE
		@GetMapping("/addStudent/{reg},{nm},{ag},{crs},{gpa}")
		public List<Student> addStudent(@PathVariable("reg") String regNo,@PathVariable("nm") String name,@PathVariable("ag") int age,@PathVariable("crs") String course,@PathVariable("gpa") double gpa)
		{
			Student newStu = new Student(regNo,name,age,course,gpa);
			students.add(newStu);
			return students;
		}
		
	//UPDATE
		
		@GetMapping("/updateStudent/{reg},{nm},{ag},{crs},{gpa}")
		public Student updateStudent(@PathVariable("reg") String regNo,@PathVariable("nm") String name,@PathVariable("ag") int age,@PathVariable("crs") String course,@PathVariable("gpa") double gpa)
		{
			for(Student student : students)
			{
				if(student.getRegNo().equals(regNo))
				{
					if(!name.equals(""))
					{
						student.setName(name);
					}
					if(age!=0 && age>0) 
					{
						student.setAge(age);
					}
					if(!course.equals(""))
					{
						student.setCourse(course);
					}
					if(gpa>0 && gpa<4)
					{
						student.setGpa(gpa);
					}
					return student;
				}
			}
			return null;
		}
		
	//DELETE
		
		@GetMapping("/deleteStudent/{reg}")
		public List<Student> deleteStudent(@PathVariable("reg") String regNo)
		{
			for(Student student : students)
			{
				if(student.getRegNo().equals(regNo))
				{
					students.remove(student);
				}
			}
			return students;
		}

}
