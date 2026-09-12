package in.namanit.mapper;

import in.namanit.dto.ProductCategoryDto;
import in.namanit.entity.ProductCategory;
import org.modelmapper.ModelMapper;

public class ProductCategoryMapper {
    public static final ModelMapper mapper = new ModelMapper();
    public static ProductCategoryDto convertToDto(ProductCategory productCategoryEntity){
        return mapper.map(productCategoryEntity,ProductCategoryDto.class);
    }

    public static ProductCategory toEntity(ProductCategoryDto productCategoryDto){
        return mapper.map(productCategoryDto,ProductCategory.class);
    }
}
