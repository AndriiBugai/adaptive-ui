$( document ).ready(() => {

    // document.addEventListener("categorySelected", event => {
    //     $.ajax({
    //         url: "/getProducts",
    //         type: "GET",
    //         data: {
    //             categoryId: event.detail.categoryId
    //         },
    //         success: result => {
    //             $(".jsRightComponent").html(result);
    //             initProductListListeners();
    //         }
    //     });
    // });

    document.addEventListener("menuSelected", event => {
        $.ajax({
            url: "/getMenuItem",
            type: "GET",
            data: {
                menuId: event.detail.menuId
            },
            success: result => {
                $(".jsRightComponent").html(result);
                let initJS = new CustomEvent('initJS', {
                    detail: {
                        'menuId': event.detail.menuId
                    }
                });
                document.dispatchEvent(initJS);
                initMenuItemListeners();
            }
        });
    });


});

let initMenuItemListeners = () => {
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