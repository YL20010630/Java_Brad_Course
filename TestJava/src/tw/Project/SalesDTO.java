package tw.Project;

public class SalesDTO {
	
//DTO 用來接收查詢結果
	public class CategorySalesDTO {
		private String categoryName;
		private Long totalQuantity;
		private Double totalSales;
		
		public CategorySalesDTO(String categoryName, Long totalQuantity, Double totalSales) {
			this.categoryName = categoryName;
			this.totalQuantity = totalQuantity;
			this.totalSales = totalSales;
		}
		
		// getters & setters
	}
}


