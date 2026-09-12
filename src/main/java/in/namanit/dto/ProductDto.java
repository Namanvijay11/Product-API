package in.namanit.dto;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProductDto {
    private Long productId;
    private String name;
    private String description;
    private String title;
    private BigDecimal unitPrice;
    private String imageUrl;
    private boolean active;
    private int unitsInStock;

    @CreationTimestamp
    private LocalDate dateCreated;
    @UpdateTimestamp
    private LocalDate lastUpdated;

}
