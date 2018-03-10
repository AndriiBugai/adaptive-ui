<#-- @ftlvariable name="categoryList" type="java.util.List<com.adaptive.ui.entity.Category>" -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Інтернет магазин</title>
    <link href="/css/index.css" rel="stylesheet">
    <link href="/css/category-list.css" rel="stylesheet">
    <link href="/css/common-style.css" rel="stylesheet">

</head>
<body>
    <div class="header">
        <div class="content">
            <div class="header__title h1">
                Інтернет магазин
            </div>
            <div class="header__subtitle h3">
                з адаптивним інтерфейсом користувача
            </div>
        </div>
    </div>

    <div class="content main">
        <#include "categoryList.ftl"  parse=true>
    </div>

    <script src="/js/main.js"></script>
</body>
</html>