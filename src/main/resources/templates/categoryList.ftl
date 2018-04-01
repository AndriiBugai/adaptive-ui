<#-- @ftlvariable name="menuList" type="java.util.List<com.adaptive.ui.entity.MenuItem>" -->


<div class="category-list">
    <div class="category-list-title font-h2">
        Категорії товарів
    </div>
    <#list menuList as menu>
        <div class="category font-h4 jsSelectMenu" id="${menu.id}"><#--jsCategorySelect-->
            ${menu.name}
            <span style="float: right">
                <i class="fa fa-chevron-right" aria-hidden="true"></i>
            </span>
        </div>
    </#list>
</div>