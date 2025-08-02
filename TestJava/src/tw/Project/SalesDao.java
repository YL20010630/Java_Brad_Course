package tw.Project;

public class SalesDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ProductSalesDto> findTopSellingProducts() {
        String sql = """
            SELECT p.ProductName, SUM(od.Quantity) AS TotalSales
            FROM OrderDetails od
            JOIN Products p ON od.ProductID = p.ProductID
            GROUP BY p.ProductName
            ORDER BY TotalSales DESC
            LIMIT 5
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new ProductSalesDto(
                rs.getString("ProductName"),
                rs.getInt("TotalSales")
            )
        );
    }
}
