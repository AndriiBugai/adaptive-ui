<#-- @ftlvariable name="categoryList" type="java.util.List<com.adaptive.ui.entity.Category>" -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Інтернет магазин</title>
    <link href="/css/libs/bootstrap.min.css" rel="stylesheet">
    <link href="/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/css/common-style.css" rel="stylesheet">
    <link href="/css/index.css" rel="stylesheet">
    <link href="/css/category-list.css" rel="stylesheet">
    <link href="/css/product-list.css" rel="stylesheet">
    <link href="/css/cart.css" rel="stylesheet">
    <link href="/css/time-sheet.css" rel="stylesheet">

</head>
<body>
    <div class="header">
        <div class="content">
            <div class="left">
                <div class="header__title font-h1">
                    ERP-система
                </div>
                <div class="header__subtitle font-h3">
                    з адаптивним інтерфейсом користувача
                </div>
            </div>
            <div class="right">
                <button type="button" class="btn btn-info open-cart-btn jsOpenCart">
                    Кошик
                    <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                </button>
            </div>

        </div>
    </div>

    <div class="content main">
        <div class="left-component">
            <#include "categoryList.ftl"  parse=true>
        </div>
        <div class="right-component jsRightComponent"></div>
        <#include "cartPopup.ftl"  parse=true>
    </div>

    <script src="/js/libs/jquery-3.3.1.js"></script>
    <script src="/js/libs/highcharts.js"></script>
    <script src="/js/libs/exporting.js"></script>
    <script src="/js/libs/bootstrap.js"></script>
    <script src="/js/categories.js"></script>
    <script src="/js/products.js"></script>
    <script src="/js/cart.js"></script>
    <script src="/js/reports.js"></script>


</body>
</html>