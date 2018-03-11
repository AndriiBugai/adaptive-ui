$( document ).ready(() => {

    document.addEventListener("refreshCart", () => {
        refreshCart();
    });

    $('.jsOpenCart').click(event => {
        $('.jsCartPopup').modal();
    });

    let initCartListeners = () => {
        $('.jsIncrementQuantity').click(event => {
            let productId = $(event.currentTarget).closest('.product').attr('data-product-id');
            $.ajax({
                url: "/incrementQuantity",
                type: "GET",
                data: {
                    productId: productId
                },
                success: result => {
                    refreshCart();
                }
            });
        });

        $('.jsDecrementQuantity').click(event => {
            let productId = $(event.currentTarget).closest('.product').attr('data-product-id');
            $.ajax({
                url: "/decrementQuantity",
                type: "GET",
                data: {
                    productId: productId
                },
                success: result => {
                    refreshCart();
                }
            });
        });

        $('.jsRemoveFromCart').click(event => {
            let productId = $(event.currentTarget).closest('.product').attr('data-product-id');
            $.ajax({
                url: "/removeFromCart",
                type: "GET",
                data: {
                    productId: productId
                },
                success: result => {
                    refreshCart();
                }
            });
        });
    };

    initCartListeners();


    document.addEventListener("addToCartEvent", event => {
        $.ajax({
            url: "/addProductToCart",
            type: "GET",
            data: {
                productId: event.detail.productId
            },
            success: result => {
                refreshCart();
            }
        });
    });

    let refreshCart = () => {
        $.ajax({
            url: "/refreshCartContent",
            type: "GET",
            success: result => {
                $(".jsCartPopupBody").html(result);
                initCartListeners();
            }
        });
    };




});

