package com.adaptive.ui.utils;


import com.adaptive.ui.entity.MenuItem;
import com.adaptive.ui.entity.SoldProduct;
import com.adaptive.ui.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AdaptivityFilter {

    @Autowired
    Utils utils;

    public SoldProduct getStatisticsProductName() {
        return utils.getSoldProductsList().get(3);
    }

    public List<MenuItem> getMenuList() {
        List<MenuItem> menuList = utils.getMenuList();
        Collections.shuffle(menuList);
        return menuList;
    }

    // short/long
    public String getTimeSheetConfig() {
        String shortTimeSheet = "shortTimeSheet";
        String longTimeSheet = "longTimeSheet";
        return longTimeSheet;
    }
}
