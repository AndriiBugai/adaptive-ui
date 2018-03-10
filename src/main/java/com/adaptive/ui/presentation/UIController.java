package com.adaptive.ui.presentation;

import com.adaptive.ui.dao.DAO;
import com.adaptive.ui.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UIController {

    @Autowired
    private DAO dao;

    private final static String CATEGORY_LIST = "categoryList";

    private final static String PAGE_MAIN = "mainPage";

    @GetMapping("/")
    public String hello(Model model) {
        List<Category> categoryList = dao.getAllCategories();
        model.addAttribute(CATEGORY_LIST, categoryList);
        return PAGE_MAIN;
    }
}
