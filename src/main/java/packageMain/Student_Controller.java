package packageMain;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student_Controller {

	@Autowired
	private Students_Service ss;
	
	@GetMapping("/student/{roll}")
	public Students get(@PathVariable("roll") int roll){
		return ss.select(roll);
	}
	
	@GetMapping("/student")
	public ArrayList<Students> getAll(){
		return ss.selectAll();
	}
	
	@PostMapping("/student")
	public Students post(@RequestBody Students sts){
		return ss.insert(sts);
	}
	
	@PutMapping("/student/{roll}")
	public Students put(@PathVariable("roll") int roll,@RequestBody Students stu){
		return ss.update(roll, stu);
	}
	
	@DeleteMapping("/student/{roll}")
	public String delete(@PathVariable int roll){
		ss.delete(roll);
		return "Deleted";
	}
	
	@DeleteMapping("/student")
	public String deleteAll(){
		ss.truncate();
		return "Tuncated";
	}
	
}
