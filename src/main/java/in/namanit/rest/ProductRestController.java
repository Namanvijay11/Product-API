package in.namanit.rest;

import in.namanit.dto.ProductCategoryDto;
import in.namanit.dto.ProductDto;
import in.namanit.exception.NoProductCategoriesFound;
import in.namanit.exception.NoProductsFoundException;
import in.namanit.response.ApiResponse;
import in.namanit.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<List<ProductCategoryDto>>> productCategories(){
        log.debug("method execution started");
        ApiResponse<List<ProductCategoryDto>> response = new ApiResponse<>();

        List<ProductCategoryDto> allCategory = productService.getAllCategory();
        if(allCategory.isEmpty()){
//            log.warn("Products Categories Not Available");
//            response.setStatus(200);
//            response.setMessage("No Product Available");
//            response.setData(null);
//            return new ResponseEntity<>(response, HttpStatus.OK);
            throw new NoProductCategoriesFound("Product Categories Not Found");
        }
        else{
            response.setStatus(200);
            response.setMessage("Fetched all categories");
            response.setData(allCategory);
            log.debug("method execution completed");
            log.info("Fetched Product Categories Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/products/{categoryId}")
    public ResponseEntity<ApiResponse<List<ProductDto>>> productsByCategory(@PathVariable Long categoryId){
        ApiResponse<List<ProductDto>> response = new ApiResponse<>();
        List<ProductDto> products = productService.getProductsByCategory(categoryId);
        if(products.isEmpty()){
//            log.warn("Products Not Available With given category Id");
//            response.setStatus(200);
//            response.setMessage("No Products Available");
//            response.setData(null);
//            return new ResponseEntity<>(response,HttpStatus.OK);
            throw new NoProductsFoundException("No Products Found With Given Category Id");
        }
        else {
            response.setStatus(200);
            response.setMessage("Fetched Product By Category");
            response.setData(products);
            log.info("Fetched Product Successfully Based on Category Id");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
    }

    @GetMapping("/productsByName/{name}")
    public ResponseEntity<ApiResponse<List<ProductDto>>> productsByName(@PathVariable String name){
        ApiResponse<List<ProductDto>> response = new ApiResponse<>();
        List<ProductDto> products = productService.getProductsByName(name);
        if(products.isEmpty()){
//            log.warn("Products Not Available With Given Name");
//            response.setStatus(200);
//            response.setMessage("Failed To Fetched Product By Name");
//            response.setData(null);
//            return new ResponseEntity<>(response,HttpStatus.OK);
            throw new NoProductsFoundException("No Products Found With Given Name");
        }
        else {
            response.setStatus(200);
            response.setMessage("Fetched Product By Name");
            response.setData(products);
            log.info("Fetched Products Successfully Based Name");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ApiResponse<ProductDto>> product(@PathVariable Long productId){
        ApiResponse<ProductDto> response = new ApiResponse<>();
        ProductDto productDto = productService.getProductById(productId);
        if(productDto!=null){
            response.setStatus(200);
            response.setMessage("Fetched Product By Id");
            response.setData(productDto);
            log.info("Fetched Product Successfully By Product Id");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        else{
//            log.warn("No Product Found With Given Id");
//            response.setStatus(200);
//            response.setMessage("No Products Available");
//            response.setData(null);
//            return new ResponseEntity<>(response,HttpStatus.OK);
            throw new NoProductsFoundException("No Product Found With Given Product Id");
        }
    }
}
