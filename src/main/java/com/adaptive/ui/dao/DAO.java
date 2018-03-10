package com.adaptive.ui.dao;

import com.adaptive.ui.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAO {

    @Autowired
    private MongoOperations mongoOperations;

    public List<Category> getAllCategories() {
        return mongoOperations.findAll(Category.class);
    }

}
