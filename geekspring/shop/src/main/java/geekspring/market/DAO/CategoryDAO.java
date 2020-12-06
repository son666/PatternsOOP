package geekspring.market.DAO;

import geekspring.market.entites.Category;
import geekspring.market.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDAO implements DAO<Category> {
    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>)categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public boolean isCategoryWithTitleExists(String categoryTitle) {
        return categoryRepository.findOneByTitle(categoryTitle) != null;
    }
}
