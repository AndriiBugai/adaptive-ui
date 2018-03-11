package com.adaptive.ui.dao;

import com.adaptive.ui.entity.Category;
import com.adaptive.ui.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAO {

    @Autowired
    private MongoOperations mongoOperations;

    public List<Category> getAllCategories() {
        return mongoOperations.findAll(Category.class);
    }

    public List<Product> getProductsByCategory(String categoryId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("category").is(categoryId));
        return mongoOperations.find(query,Product.class);
    }

    public Product getProductById(String productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(productId));
        return mongoOperations.findOne(query,Product.class);
    }

}
