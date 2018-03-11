<#-- @ftlvariable name="order" type="java.util.List<com.adaptive.ui.entity.Product>" -->
<#-- @ftlvariable name="totalPrice" type="java.lang.Double" -->

<div>
    <#if order?has_content>
        <#list order as product>
            <div class="product font-h3" data-product-id="${product.id}">
                <div class="product-image">
                    <img src="/images/${product.image}"/>
                </div>
                <div class="product-features">
                    <div class="product-name font-h3">
                    ${product.name}
                    </div>
                    <div class="product-counter">
                        <div class="feature-name">Кількість</div>
                        <div class="feature-value">
                            <#if product.count = 1>
                                <#assign btnStatus = 'disabled'/>
                            </#if>
                            <button type="button" class="btn btn-default btn-sm jsDecrementQuantity ${btnStatus!}">
                                <i class="fa fa-minus" aria-hidden="true"></i>
                            </button>
                            <span >${product.count}</span>
                            <button type="button" class="btn btn-default btn-sm jsIncrementQuantity">
                                <i class="fa fa-plus" aria-hidden="true"></i>
                            </button>
                        </div>

                    </div>
                    <div class="product-price ">
                        <div class="feature-name">Ціна</div>
                        <span class="feature-value font-h2">${product.countTotalPrice()}&#8372;</span>
                    </div>
                    <div>
                        <button type="button" class="btn btn-danger btn-sm jsRemoveFromCart">
                            Видалити
                        </button>
                    </div>
                </div>
            </div>
        </#list>
        <div class="order-footer">
            <div class="order-total">
                <span>Разом:</span>
                <span class="total-price font-h2">${totalPrice!}&#8372;</span>
            </div>
            <button type="button" class="btn btn-default footer-btn" data-dismiss="modal">Продовжити покупки</button>
            <button type="button" class="btn btn-success footer-btn jsSubmitOrder">Оформити замовлення</button>
        </div>

    <#else>
        Кошик пустий
    </#if>

</div>