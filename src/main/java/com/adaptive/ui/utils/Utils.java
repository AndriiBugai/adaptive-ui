package com.adaptive.ui.utils;

import com.adaptive.ui.entity.MenuItem;
import com.adaptive.ui.entity.SoldProduct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Utils {

    public List<MenuItem> getMenuList() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Звіти", "reports"));
        menuItems.add(new MenuItem("Клієнти", "clients"));
        menuItems.add(new MenuItem("Табель робочого часу", "timesheet"));
        menuItems.add(new MenuItem("Виставлення рахунків", ""));
        menuItems.add(new MenuItem("Закупка", "purchase"));
        menuItems.add(new MenuItem("Персональна інформація", "personalInformation"));
        menuItems.add(new MenuItem("Облік інвентаря", "inventory"));
        return menuItems;
    }


    public List<SoldProduct> getSoldProductsList() {
        List<SoldProduct> soldProducts = new ArrayList<>();
        soldProducts.add(new SoldProduct("Продукт 1", "p1"));
        soldProducts.add(new SoldProduct("Продукт 2", "p2"));
        soldProducts.add(new SoldProduct("Продукт 3", "p3"));
        soldProducts.add(new SoldProduct("Продукт 4", "p4"));
        soldProducts.add(new SoldProduct("Продукт 5", "p5"));
        return soldProducts;
    }

}
