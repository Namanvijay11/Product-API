package in.namanit.service;

import in.namanit.dto.ProductCategoryDto;
import in.namanit.dto.ProductDto;
import in.namanit.entity.Product;
import in.namanit.entity.ProductCategory;
import in.namanit.mapper.ProductCategoryMapper;
import in.namanit.mapper.ProductMapper;
import in.namanit.repo.ProductCategoryRepo;
import in.namanit.repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;

    private ProductCategoryRepo categoryRepo;

    @Override
    public List<ProductCategoryDto> getAllCategory() {
        return categoryRepo.findAll()
                            .stream()
                            .map(ProductCategoryMapper::convertToDto)
                            .toList();
    }

    @Override
    public List<ProductDto> getProductsByCategory(Long categoryId) {
        return productRepo.findByCategoryCategoryId(categoryId).stream()
                .map(ProductMapper::convertToDto)
                .toList();
    }

    @Override
    public List<ProductDto> getProductsByName(String productName) {
        return productRepo.findByNameContainingIgnoreCase(productName)
                .stream()
                .map(ProductMapper::convertToDto)
                .toList();
    }

    @Override
    public ProductDto getProductById(Long productId) {
        return productRepo.findById(productId)
                .map(ProductMapper::convertToDto)
                .orElse(null);
    }
}
