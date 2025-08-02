package tw.lab.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cname;

	public Course() {}
	public Course(String cname) {
		this.cname = cname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
	
//	----------------------------
	@ManyToMany(
//			mappedBy = "courses" 表示這一端不是主控方，Student 才是
			mappedBy = "courses", 
//			EAGER 表示查學生時會同時查課程
			fetch = FetchType.EAGER
			)
	private Set<Student> students = new HashSet<>();

//	從課程中取得所有選這門課的學生清單
	public Set<Student> getStudents() {
		return students;
	}
//	設定學生清單
	public void setStudents(Set<Student> students) {
		this.students = students;
	}	

	
	
}