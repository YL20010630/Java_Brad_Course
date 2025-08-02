package tw.lab.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sname;

	public Student() {}
	public Student(String sname) {
		this.sname = sname;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
//	-------------------------------
//	建立多對多關聯
	@ManyToMany(
//			CascadeType.ALL 表示新增學生時，若課程沒在資料庫，也會自動新增
			cascade = CascadeType.ALL,
//			EAGER 表示查學生時會同時查課程
			fetch = FetchType.EAGER
			)
//	資料表 sc 是關聯表
	@JoinTable(
			name = "sc",
//			本表欄位叫 sid，對應學生
			joinColumns = {@JoinColumn(name = "sid")},
//			對方欄位叫 cid，對應課程
			inverseJoinColumns = {@JoinColumn(name = "cid")}
			)
	private Set<Course> courses = new HashSet<>();

//	取得該學生所選課程清單
	public Set<Course> getCourses() {
		return courses;
	}
//	設定課程清單
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public void addCourse(Course course) {
		if (courses.add(course)) {
			course.getStudents().add(this);
//			加入課程並同步更新課程的 students（保持雙向同步）
		}
	}
	
	
	
	
}