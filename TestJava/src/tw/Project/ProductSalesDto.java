package tw.Project;

public class ProductSalesDto {
    private String productName;
    private int totalSales;

    public ProductSalesDto(String productName, int totalSales) {
        this.productName = productName;
        this.totalSales = totalSales;
    }

    public String getProductName() { return productName; }
    public int getTotalSales() { return totalSales; }
}
