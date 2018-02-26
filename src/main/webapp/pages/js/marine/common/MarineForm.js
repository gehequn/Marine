$.extend($.fn, {

})

$.FORM = {

    setResponseHtml : function (html) {
        var $message = $('<div></div>');
        $message.html(html);// 把传回来的页面作为message返回
        return $message;
    },

    showConfirm : function (showOption) {
        
    },

    showFormDialog :function (showOption) {

        var dialog;
        var buttons;

        var setOption = function (showOption, html) {

            // showOption.message($.FORM.setResponseHtml(html));
            showOption = $.extend({message : $.FORM.setResponseHtml(html)},showOption);

            if (showOption.readOnly != undefined && showOption.readOnly != null) {
                if (showOption.readOnly) {
                    // 只读模式
                } else {
                    // 修改模式
                    buttons = [ {
                        icon : 'glyphicon glyphicon-saved',
                        label : '修改',
                        cssClass : 'btn-primary',
                        action : function(dialogItself) {
                            // $.FORM.postForm(showOpt, dialogItself);
                        }
                    }, {
                        icon : 'glyphicon glyphicon-ban-circle',
                        label : '取消',
                        action : function(dialogItself) {
                            dialogItself.close();
                        }
                    } ];
                }
            } else {

            }

            dialog = $.FORM.showDialog(showOption, buttons);
        }

        //如果有数据先加载数据
        if (showOption.dataUrl != undefined && showOption.dataUrl != null) {
            console.log(showOption.param);
            $.ajax({
                type : "post",
                async : false,
                url : showOption.dataUrl,
                contentType: 'application/json;charset=utf-8',
                // contentType : 'application/json',
                dataType : "json",
                data : showOption.param,
                success : function (responseHtml) {
                    // console.log(responseHtml);
                    setOption (showOption, responseHtml);
                },
                error : function(XMLHttpRequest, textStatus, errorThrown){

                }
            });
        } else {
            setOption (showOption, null);
        }
    },

    showDialog : function (showOption, buttons) {
        showOption.buttons = $.extend(showOption.buttons, buttons);
        var defaults = {
            text: '成功',
            title: '提示'
        }
        var opts = $.extend({}, defaults, showOption);

        //无buttons 则默认只有一个确定按钮
        if (showOption.buttons == undefined || showOption.buttons == null) {
            showOption.buttons = [ {
                icon : 'glyphicon glyphicon-ok',
                label : '确定',
                cssClass : 'btn-primary',
                action : function(dialogItself) {
                    dialogItself.close();
                }
            } ];
        }

        var dialog = BootstrapDialog.show({
            title: '提示',
            size: showOption.dialogSize?showOption.dialogSize:BootstrapDialog.SIZE_SMALL,
            type: BootstrapDialog.TYPE_DEFAULT,
            message: opts.message,
            buttons:  showOption.buttons
        });
        return dialog;
    }
}