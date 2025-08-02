package tw.lab.hi1;

import tw.lab.dao.SCDao;
import tw.lab.entity.Student;

public class lab13 {

	public static void main(String[] args) {
		SCDao dao = new SCDao();
		Student s1 = new Student("Alicia");
		Student s2 = new Student("Bereta");
		Student s3 = new Student("Cyn");
		Student s4 = new Student("Doris");
		Student s5 = new Student("Eliena");
		Student s6 = new Student("Faula");
		
		dao.save(s1);dao.save(s2);dao.save(s3);
		dao.save(s4);dao.save(s5);dao.save(s6);
		
	}

}
