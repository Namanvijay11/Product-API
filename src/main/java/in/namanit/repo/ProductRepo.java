package in.namanit.repo;

import in.namanit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {
    public List<Product> findByCategoryCategoryId(Long categoryId);
    public List<Product> findByNameContainingIgnoreCase(String name);
}
