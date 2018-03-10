<#-- @ftlvariable name="categoryList" type="java.util.List<com.adaptive.ui.entity.Category>" -->


<div class="category-list">
    <div class="category-list-title h2">
        Категорії товарів
    </div>
    <#list categoryList as category>
        <div class="category h4" id="${category.id}">
            ${category.name}
        </div>
    </#list>
</div>