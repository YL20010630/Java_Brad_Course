package tw.lab.hi1;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import tw.lab.dao.SCDao;
import tw.lab.entity.Course;

public class CourseMenu extends JComboBox<String>{
	private MyModel model;
	private List<Course> courses;

	public CourseMenu() {
		
		courses = new SCDao().getAllCourses();
		
		model = new MyModel();
		setModel(model);
		
	}
	
	public Course getSelectedCourse() {
		if (getSelectedIndex() != -1) {
			return courses.get(getSelectedIndex());
		}
		return null;
	}
	
	
	private class MyModel extends DefaultComboBoxModel<String> {

		@Override
		public int getSize() {
			return courses.size();
		}

		@Override
		public String getElementAt(int index) {
			return courses.get(index).getCname();
		}
		
	}
	
}