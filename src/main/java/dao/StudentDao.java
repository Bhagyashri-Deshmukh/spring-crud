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
		this.template= template;
	}
	
	public List<Student> getAllStudents(){
		
		return template.query("select * from student", new RowMapper<Student>() {
			
			public Student mapRow(ResultSet rs, int row) throws SQLException {
			
				Student st = new Student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setAddress(rs.getString(3));
				return st;
			}
		});
	}

	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		String sql ="delete from student where id ="+id;
		template.update(sql);
	}
}
