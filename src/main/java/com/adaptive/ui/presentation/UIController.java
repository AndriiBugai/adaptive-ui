package com.adaptive.ui.presentation;

import com.adaptive.ui.beans.Cart;
import com.adaptive.ui.dao.DAO;
import com.adaptive.ui.entity.MenuItem;
import com.adaptive.ui.entity.Product;
import com.adaptive.ui.entity.SoldProduct;
import com.adaptive.ui.utils.AdaptivityFilter;
import com.adaptive.ui.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UIController {

    @Autowired
    private DAO dao;

    @Autowired
    private Utils utils;

    @Autowired
    private Cart cart;

    @Autowired
    private AdaptivityFilter adaptivityFilter;

    public UIController() {
    }



    private final static String CATEGORY_LIST = "categoryList";
    private final static String PRODUCT_LIST = "productList";
    private final static String ORDER = "order";
    private final static String TOTAL_PRICE = "totalPrice";

    private final static String MENU_LIST = "menuList";

    private final static String PAGE_MAIN = "mainPage";
    private final static String COMPONENT_PRODUCTS = "productList";
    private final static String COMPONENT_CART = "cartContent";
    private final static String REPORTS_COMPONENT = "reports";
    private final static String MENU_ITEM = "menuItem";
    private final static String DEFAULT_MENU_ITEM_CONTENT = "defaultMenuItemContent";
    private final static String SELECTED_SOLD_PRODUCT = "selectedSoldProduct";
    private final static String SOLD_PRODUCTS = "soldProducts";



    @RequestMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute(MENU_LIST, adaptivityFilter.getMenuList());
        model.addAttribute(ORDER, cart.getOrderedProducts());
        model.addAttribute(TOTAL_PRICE, cart.getTotalPrice());
        return PAGE_MAIN;
    }

//    @RequestMapping("/getProducts")
//    public String getProducts(Model model, @RequestParam("categoryId") String categoryId) {
//        List<Product> productList = dao.getProductsByCategory(categoryId);
//        model.addAttribute(PRODUCT_LIST, productList);
//        model.addAttribute(MENU_LIST, categoryId);
//        return COMPONENT_PRODUCTS;
//    }

    @RequestMapping("/getMenuItem")
    public String getMenuItem(Model model, @RequestParam("menuId") String menuId) {
        MenuItem menuItem = utils.getMenuList().stream().filter(m -> m.getId().equals(menuId)).findAny().get();
        model.addAttribute(MENU_ITEM, menuItem);

        if(menuId.equals("reports")) {
            List<SoldProduct> soldProducts = utils.getSoldProductsList();
            model.addAttribute(SOLD_PRODUCTS, soldProducts);
            model.addAttribute(SELECTED_SOLD_PRODUCT, adaptivityFilter.getStatisticsProductName()); // configurable param
            return REPORTS_COMPONENT;
        } else if(menuId.equals("timesheet")) {
            String timeSheetPage = adaptivityFilter.getTimeSheetConfig();
            return timeSheetPage;
        }
        return DEFAULT_MENU_ITEM_CONTENT;
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
    @RequestMapping("/setQuantity")
    public void setQuantity(Model model,
                               @RequestParam("productId") String productId,
                               @RequestParam("value") int value ) {
        cart.setQuantity(productId, value);
    }

    @ResponseBody
    @RequestMapping("/removeFromCart")
    public void refreshCartContent(Model model, @RequestParam("productId") String productId) {
        cart.removeFromCart(productId);
    }



}
