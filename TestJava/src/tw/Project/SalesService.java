import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesService {
    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<CategorySalesDTO> getCategorySales() {
        List<Object[]> results = salesRepository.findCategorySales();
        return results.stream().map(row -> new CategorySalesDTO(
                (String) row[0],
                ((Number) row[1]).longValue(),
                ((Number) row[2]).doubleValue()
        )).collect(Collectors.toList());
    }
}
