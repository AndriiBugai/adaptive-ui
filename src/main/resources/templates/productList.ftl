<#-- @ftlvariable name="productList" type="java.util.List<com.adaptive.ui.entity.Product>" -->
<#-- @ftlvariable name="categoryName" type="java.lang.String" -->


<div class="product-list">
    <div class="product-list-title font-h2">
        ${categoryName}
    </div>
    <div class="row">
        <#list productList as product>
            <div class="col-sm-4 product font-h4 jsCategorySelect" id="${product.id}">
                <div class="product-name font-h2">
                    ${product.name}
                </div>
                <div class="product-image">
                    <img src="/images/${product.image}"/>
                </div>
                <div class="product-footer">
                    <div class="product-price font-h1">
                        ${product.price} &#8372;
                    </div>

                    <button type="button" class="btn btn-success add-to-cart-btn jsAddToCart" data-product-id="${product.id}">
                        Купити
                    </button>
                </div>
            </div>
        </#list>
    </div>

</div>