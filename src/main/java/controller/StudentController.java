package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
