package com.adaptive.ui.presentation;

import com.adaptive.ui.beans.Cart;
import com.adaptive.ui.dao.DAO;
import com.adaptive.ui.entity.Category;
import com.adaptive.ui.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UIController {

    @Autowired
    private DAO dao;

    @Autowired
    private Cart cart;

    public UIController() {
    }



    private final static String CATEGORY_LIST = "categoryList";
    private final static String PRODUCT_LIST = "productList";
    private final static String ORDER = "order";
    private final static String TOTAL_PRICE = "totalPrice";

    private final static String CATEGORY_NAME = "categoryName";

    private final static String PAGE_MAIN = "mainPage";
    private final static String COMPONENT_PRODUCTS = "productList";
    private final static String COMPONENT_CART = "cartContent";


    @RequestMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute(CATEGORY_LIST, dao.getAllCategories());
        model.addAttribute(ORDER, cart.getOrderedProducts());
        model.addAttribute(TOTAL_PRICE, cart.getTotalPrice());
        return PAGE_MAIN;
    }

    @RequestMapping("/getProducts")
    public String getProducts(Model model, @RequestParam("categoryId") String categoryId) {
        List<Product> productList = dao.getProductsByCategory(categoryId);
        model.addAttribute(PRODUCT_LIST, productList);
        model.addAttribute(CATEGORY_NAME, categoryId);
        return COMPONENT_PRODUCTS;
    }

    @RequestMapping("/refreshCartContent")
    public String refreshCartContent(Model model) {
        model.addAttribute(ORDER, cart.getOrderedProducts());
        model.addAttribute(TOTAL_PRICE, cart.getTotalPrice());
        return COMPONENT_CART;
    }

    @ResponseBody
    @RequestMapping("/addProductToCart")
    public void addProductToCart(Model model, @RequestParam("productId") String productId) {
        Product product = dao.getProductById(productId);
        cart.addProduct(product);
    }

    @ResponseBody
    @RequestMapping("/incrementQuantity")
    public void incrementQuantity(Model model, @RequestParam("productId") String productId) {
        cart.incrementQuantity(productId);
    }

    @ResponseBody
    @RequestMapping("/decrementQuantity")
    public void decrementQuantity(Model model, @RequestParam("productId") String productId) {
        cart.decrementQuantity(productId);
    }

    @ResponseBody
    @RequestMapping("/removeFromCart")
    public void refreshCartContent(Model model, @RequestParam("productId") String productId) {
        cart.removeFromCart(productId);
    }



}
