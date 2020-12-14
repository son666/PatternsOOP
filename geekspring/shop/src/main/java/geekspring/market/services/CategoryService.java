package geekspring.market.services;

import geekspring.market.DAO.CategoryDAO;
import geekspring.market.entites.Category;
import geekspring.market.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    public Category getCategoryById(Long id) {
        return categoryDAO.getById(id);
    }

    public boolean isCategoryWithTitleExists(String categoryTitle) {
        return categoryDAO.isCategoryWithTitleExists(categoryTitle);
    }

    public List<Category> getAllCategories() {
        return categoryDAO.getAll();
    }

    public void deleteCategoryById(Long id) {
        categoryDAO.delete(id);
    }

    public void saveCategory(Category category) {
        categoryDAO.save(category);
    }
}
