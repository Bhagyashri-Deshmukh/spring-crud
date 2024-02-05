package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dao.StudentDao;
import pojo.Student;

@Controller
public class StudentController {
	
	@Autowired
	StudentDao dao;
	
	@RequestMapping("/show")
	public String getAllStudents(Model model){		
		List<Student> list= dao.getAllStudents();
		model.addAttribute("list", list);
		return "show";		
	}
	
	@RequestMapping(value="/deletestudent/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable int id) {		
		dao.deleteStudent(id);
		return "redirect:/show";
	} 
	
	@RequestMapping(value="/editstudent/{id}")
	public String editStudent(@PathVariable int id, Model model) {		
		Student student =dao.getStudentById(id);
		model.addAttribute("command", student);		
		return "editpage";		
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute("stud") Student stud ) {
		dao.update(stud);
		return "redirect:/show";		
	}
	
	@RequestMapping(value="/studentform")
	public String showForm(Model model) {
		model.addAttribute("command", new Student());
		return "studentform";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student) {
		dao.addStudent(student);
		return "redirect:/show";
	}
}