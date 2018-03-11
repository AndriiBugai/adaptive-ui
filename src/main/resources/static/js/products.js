$( document ).ready(() => {

    document.addEventListener("categorySelected", event => {
        $.ajax({
            url: "/getProducts",
            type: "GET",
            data: {
                categoryId: event.detail.categoryId
            },
            success: result => {
                $(".jsRightComponent").html(result);
                initProductListListeners();
            }
        });
    });


});

let initProductListListeners = () => {
    $('.jsAddToCart').click(event => {
        let productId = $(event.currentTarget).attr('data-product-id');
        let addToCartEvent = new CustomEvent('addToCartEvent', {
            detail: {
                'productId': productId
            }
        });
        document.dispatchEvent(addToCartEvent);
    })
};