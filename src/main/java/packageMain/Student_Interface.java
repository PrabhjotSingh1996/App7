package packageMain;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface Student_Interface extends CrudRepository<Students,Integer>{

	public ArrayList<Students> findByAgeLessThan(Double age);
	
}
