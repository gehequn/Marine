$(document).ready(function(){

    $.ajax({
        url:"/Organization/getTree",
        type:"POST",
        dateType:"json",
        success:function (data) {
            if (data.flag == 0){
                $('#treeView').treeview({
                    data: data.message,
                    levels:1
                });
            }
        },
        error:function (xhr) {
            alert(xhr.responseText);
        }
    });

    $.extend({

        showMsg: function (options) {
            var defaults = {
                text: '成功',
                title: '提示'
            }
            var opts = $.extend({}, defaults, options);
            BootstrapDialog.show({
                title: '提示',
                size: BootstrapDialog.SIZE_SMALL,
                type: BootstrapDialog.TYPE_DEFAULT,
                message: opts.text,
                buttons: [{
                    label: '确定',
                    action: function (dialog) {
                        dialog.close();
                    }
                }]
            });
        },

        showMsgText:function(text)
        {
            $.showMsg({ text: text });
        }
    });
});

function setCenterHeight() {
    var height = $(window).height();
    var centerHeight = height - 240;
    $(".right_content").height(centerHeight).css("overflow", "auto");
}

$(function () {
    //新增节点按钮
    $("#btnAdd").click(function () {
        var node = $('#treeView').treeview('getSelected');
        if (node.length == 0) {
            $.showMsgText('请选择节点');
            return;
        }
    });

    //编辑节点按钮
    $("#btnEdit").click(function () {

    });

    //删除节点按钮
    $("#btnDel").click(function () {

    });

    setCenterHeight();

    
});
