package in.namanit.service;

import in.namanit.dto.ProductCategoryDto;
import in.namanit.dto.ProductDto;

import java.util.List;

public interface ProductService {

    public List<ProductCategoryDto> getAllCategory();
    public List<ProductDto> getProductsByCategory(Long categoryId);
    public List<ProductDto> getProductsByName(String productName);
    public ProductDto getProductById(Long productId);

}
