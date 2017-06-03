package packageMain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CMD_Runner implements CommandLineRunner{

	@Autowired
	private Student_Interface sintr;
	
	@Override
	public void run(String... arg0) throws Exception {
		sintr.save(new Students("A",13.0));
		sintr.save(new Students("B",14.0));
		sintr.save(new Students("C",15.0));
		sintr.save(new Students("D",13.0));
		sintr.save(new Students("E",12.0));
		sintr.findByAgeLessThan(15.0).forEach(t->System.out.println(t.getName()));
	}

}
