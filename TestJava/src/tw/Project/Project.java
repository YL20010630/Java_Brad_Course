package tw.Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;



public class Project extends JFrame {
	private ProjectTable table;
	
	public Project(){
		super("測試專案");
		
		setLayout(new BorderLayout());
		
		
		ProjectDAO dao = new ProjectDAOImpl();
		table = new ProjectTable(new ProjectTable(rankings));
		JScrollPane jsp = new JScrollPane(table);
		add(jsp, BorderLayout.CENTER);

		
		
		
		setSize(840, 640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}

	public static void main(String[] args) {
		try {
			new Project();
			
			ProjectDAO dao = new ProjectDAOImpl();
			List<SaleRanking> rankings = dao.rankSaleEmployee();
			
			for (SaleRanking r : rankings) {
				System.out.printf("員工ID：%d\t姓名：%s %s\t總銷售額：%.2f%n",
						r.getEmployeeId(), r.getFirstName(), r.getLastName(), r.getTotalSales());
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
