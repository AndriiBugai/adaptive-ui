<#-- @ftlvariable name="orderedProductMap" type="java.util.Map<com.adaptive.ui.entity.Product, Integer>" -->

<div class="cart">

    <div class="modal fade jsCartPopup" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <div class="cart-title font-h2">
                        Кошик товарів
                    </div>
                </div>
                <div class="modal-body jsCartPopupBody">
                    <#include "cartContent.ftl"  parse=true>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

</div>