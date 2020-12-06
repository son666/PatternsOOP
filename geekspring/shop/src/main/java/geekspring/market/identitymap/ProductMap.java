package geekspring.market.identitymap;

import geekspring.market.entites.Product;
import geekspring.market.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductMap {
    private Map<Long, Product> productMap = new HashMap<>();

    @Autowired
    private ProductRepository productRepository;


    @PostConstruct
    private void postConstruct() {
        List<Product> productList;
        productList = (List<Product>) productRepository.findAll();
        for (Product product : productList) {
            productMap.put(product.getId(), product);
        }
    }

    public void addProduct(Product product) {
        productRepository.save(product);
        productMap.put(product.getId(), product);
    }

    public void deleteProduct(Long key) {
        productRepository.deleteById(key);
        productMap.remove(key);
    }

    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>(productMap.values());
        if (productList.size() == 0) {
            productList = (List<Product>) productRepository.findAll();
        }
        return productList;
    }

    public Product getProduct(Long key) {
        Product product = productMap.get(key);
        if (product == null) {
            product = productRepository.findById(key).orElse(null);
        }
        return product;
    }

    public boolean isProductWithTitleExists (String productTitle) {
        for (Map.Entry<Long, Product> valMap : productMap.entrySet()) {
            if (valMap.getValue().getTitle().equals(productTitle)) {
                return true;
            }
        }
        return productRepository.findOneByTitle(productTitle) != null;
    }
}
