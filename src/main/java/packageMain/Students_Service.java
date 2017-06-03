package packageMain;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Students_Service {

	@Autowired
	private Student_Interface si;
	
	public Students select(int Roll){
		return si.findOne(Roll);
	}
	
	public ArrayList<Students> selectAll(){
		ArrayList<Students> list = new ArrayList<>();
		si.findAll().forEach(t->list.add(t));
		return list;
	}
	
	public Students insert(Students stu){
		return si.save(stu);
	}
	
	public Students update(int roll,Students stu){
		si.delete(roll);
		return si.save(stu);
	}
	
	public void delete(int roll){
		si.delete(roll);
	}

	public void truncate(){
		si.deleteAll();
	}
}
