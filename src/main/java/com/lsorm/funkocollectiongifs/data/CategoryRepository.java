package com.lsorm.funkocollectiongifs.data;

import com.lsorm.funkocollectiongifs.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Conventions"),
            new Category(2, "Hot Topic"),
            new Category(3, "Funko Shop")
    );

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }

    public Category findById(int id) {
        for(Category category : ALL_CATEGORIES) {
            if(category.getId() == id){
                return category;
            }
        }
        return null;
    }
}
