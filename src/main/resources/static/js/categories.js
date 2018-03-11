$( document ).ready(() => {

    $('.jsCategorySelect').click(event => {
        let categoryId = $(event.currentTarget).attr('id');
        let categorySelected = new CustomEvent('categorySelected', {
            detail: {
                'categoryId': categoryId
            }
        });
        document.dispatchEvent(categorySelected);
    })
});