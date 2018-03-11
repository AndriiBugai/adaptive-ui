<#-- @ftlvariable name="categoryList" type="java.util.List<com.adaptive.ui.entity.Category>" -->


<div class="category-list">
    <div class="category-list-title font-h2">
        Категорії товарів
    </div>
    <#list categoryList as category>
        <div class="category font-h4 jsCategorySelect" id="${category.id}">
            ${category.name}
            <span style="float: right">
                <i class="fa fa-chevron-right" aria-hidden="true"></i>
            </span>
        </div>
    </#list>
</div>