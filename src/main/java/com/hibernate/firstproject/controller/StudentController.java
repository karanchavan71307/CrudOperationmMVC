package com.hibernate.firstproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.firstproject.model.LoginPage;
import com.hibernate.firstproject.model.Student;
import com.hibernate.firstproject.service.StudentService;

@Controller
public class StudentController {

	// get the service class
	@Autowired
	private StudentService studentService;

	@GetMapping("/home")
	public String getHomePage(Model model) {

		List<Student> student = this.studentService.getAllStudent();
		model.addAttribute("student", student);
		return "home";
	}

	@GetMapping("/getpage")
	public String getPage() {

		System.out.println("first controller");

		return "formpage";
	}

	// get the form
	@PostMapping("/student")
	public String studentInfo(@ModelAttribute("student") Student student, Model model) {

		System.out.println("seconds controller");

		// save the student
		this.studentService.saveStudent(student);

		System.out.println(student);
		model.addAttribute("model", student);
		return "success";
	}

	// delete the Student

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id) {

		this.studentService.deleteStudent(id);

		System.out.println("deleted succesfully...");

		return "redirect:/home";
	}

	@GetMapping("/update/{id}")
	public String updateStudent(@PathVariable("id") int id, Model model) {

		Student student = this.studentService.getStudent(id);

		model.addAttribute("s", student);

		return "formpage2";
	}

	// login page

	@GetMapping("/login")
	public String getLogin() {
		System.out.println("login page");
		return "login";
	}

	@PostMapping("/display")
	public String loginPage(@ModelAttribute("loginPage") LoginPage loginPage, Model model) {

		// getting all data from the database
		List<Student> list = this.studentService.getAllStudent();

		Optional<Student> optional = list.stream().filter(i -> i.getEmail().equals(loginPage.getEmail())).findAny();
		Optional<Student> optional2 = list.stream().filter(i -> i.getPassword().equals(loginPage.getPassword()))
				.findAny();

		if ( ! optional.isPresent() && optional2.isPresent()) {

			System.out.println("this is implements of the login page..");

			System.out.println(loginPage);

			model.addAttribute("LoginData", loginPage);

			return "loginsuccess";

		}
		return "loginfaild";

	}

}
