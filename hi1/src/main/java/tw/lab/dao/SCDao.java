package tw.lab.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.lab.entity.Course;
import tw.lab.entity.Student;
import tw.lab.hi1.HibernateUtil;

//	資料存取層：儲存學生或課程

public class SCDao {
	public void save(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
//			用 session.persist(...) 儲存 Entity
			session.persist(student);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	public void save(Course course) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.persist(course);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void delete(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.remove(student);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
		
	}	
	
//	原為public void update(Student student) {，這是只更新資料，不需要回傳內容
//	現在，需要拿回更新後的資料做其他操作
	public Student update(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.merge(student);
			transaction.commit();
			return getById(student.getId());
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
			return null;
		}
	}
	
	
//	查詢單一學生
	public Student getById(Long studentId) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.get(Student.class, studentId);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;		
	}
	
//	查詢單一課程
	public Course getCourseById(Long courseId) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.get(Course.class, courseId);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;		
	}
	
//	查詢所有課程
	public List<Course> getAllCourses(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("FROM Course", Course.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;		
	}
	
	
	
	
	
	
	
	
	
}