package tw.Project;

public class SaleRanking {
	private int employeeId;
	private String firstName;
	private String lastName;
	private double totalSales;
	
	public SaleRanking(int employeeId, String firstName, String lastName, double totalSales) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalSales = totalSales;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public double getTotalSales() {
		return totalSales;
	}
}