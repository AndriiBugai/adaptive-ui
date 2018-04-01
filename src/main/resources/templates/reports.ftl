<#-- @ftlvariable name="menuItem" type="com.adaptive.ui.entity.MenuItem" -->

<#-- @ftlvariable name="selectedSoldProduct" type="com.adaptive.ui.entity.SoldProduct" -->
<#-- @ftlvariable name="soldProducts" type="java.util.List<com.adaptive.ui.entity.SoldProduct>" -->


<div class="product-list reports" data-menu-id="${menuItem.id}">
    <div class="product-list-title font-h2">
        ${menuItem.name}
    </div>

    <div>
        <select class="jsSelectSoldProduct" style="margin-top: 10px; height: 40px">
            <#list soldProducts as product>
                <#if product.id == selectedSoldProduct.id>
                    <option selected="selected">${product.name}</option>
                <#else>
                    <option>${product.name}</option>
                </#if>
            </#list>
        </select>

    </div>

    <div id="sold-items">

    </div>

</div>