package my.name.firstname;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class FirstnameController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @GetMapping("/firstname")
    public Name getFirstname() {
	String query = "SELECT id, name FROM firstname WHERE id=?";	
	return jdbcTemplate.query(query, new Object[] {1}, (rs, rowNum) -> new Name(rs.getString("name"))).get(0);
    }
    
    public static class Name {
	private String name;
			
	public Name(String name) {
	    this.name = name;
	}
	
	public String getName() {
	    return name;
	}
    }
}    
