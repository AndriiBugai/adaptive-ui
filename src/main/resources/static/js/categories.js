$( document ).ready(() => {

    // $('.jsCategorySelect').click(event => {
    //     let categoryId = $(event.currentTarget).attr('id');
    //     let categorySelected = new CustomEvent('categorySelected', {
    //         detail: {
    //             'categoryId': categoryId
    //         }
    //     });
    //     document.dispatchEvent(categorySelected);
    // })


    $('.jsSelectMenu').click(event => {
        let menuId = $(event.currentTarget).attr('id');
        let categorySelected = new CustomEvent('menuSelected', {
            detail: {
                'menuId': menuId
            }
        });
        document.dispatchEvent(categorySelected);
    })
});