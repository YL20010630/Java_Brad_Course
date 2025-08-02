package tw.lab.hi1;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import tw.lab.dao.SCDao;
import tw.lab.entity.Course;
import tw.lab.entity.Student;

public class lab15 {
	public static void main(String[] args) {
		SCDao dao = new SCDao();
		Student s1;
//		if (s1 != null) {
//			System.out.printf("Welcome, %s\n", s1.getSname());
			
			Scanner scanner = new Scanner(System.in);
			while(true) {
				s1 = dao.getById((long)4);
				
//				顯示所有尚未選的課程，判斷學生是否在該課程的學生清單中
				List<Course> courses = dao.getAllCourses();
				for (Course course : courses) {
					if (!isExist(s1, course.getStudents())) {
						System.out.printf("%d. %s\n", course.getId(), course.getCname());
					}
				}				
				
				System.out.println("Which?");
				long cid = scanner.nextLong();
				if (cid == 0) break;
				s1.addCourse(dao.getCourseById(cid));
				
				dao.update(s1);
			}
			
			
//		}else {
//			System.out.println("Student NOT FOUND");
//		}
	}

//	判斷學生是否已經選過該課程
	private static boolean isExist(Student s, Set<Student> students) {
		boolean ret = false;
		for (Student student : students) {
			
//			如果這位課程裡的學生 student 的 id，等於我們傳進來這位學生 s 的 id，就表示他已經選過這門課了
//			student 是 for 迴圈裡從 Set<Student> 拿出來的其中一位學生
//			s 是外部傳進來的目標學生物件(（要檢查的那一個)），是這個方法的參數
//			.getId() 是從資料庫對應到的學生主鍵
			if (student.getId() == s.getId()) {
				ret = true;
				break;
			}
		}
		return ret;
	}

}
