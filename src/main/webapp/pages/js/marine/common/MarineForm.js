$.extend($.fn, {

})

$.FORM = {
    showConfirm : function (showOption) {
        
    },

    showFormDialog :function (showOption) {

        //如果有数据先加载数据
        if (showOption.dataSource != undefined && showOption.dataSource != null) {
            $.ajax({
                type : "post",
                async : false,
                url : showOption.dataSource,
                contentType : 'application/json',
                dataType : "json",
                success : function (html) {
                    $()
                },
                error : function(XMLHttpRequest, textStatus, errorThrown){

                }
            });
        } else {

        }
    },

    showDialog : function (showOption, buttons, data) {
        
    }
}