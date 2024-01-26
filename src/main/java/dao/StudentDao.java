package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pojo.Student;

public class StudentDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Student> getAllStudents(){
		
		return template.query("select * from student", new RowMapper<Student>(){
			
			public Student mapRow(ResultSet rs, int row) throws SQLException{
				
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setAddress(rs.getString(3));
				return student;
			}
		});
	}
}
