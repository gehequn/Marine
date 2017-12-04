$(document).ready(function () {

    $.ajax({
        url: "/Organization/getTree",
        type: "POST",
        dateType: "json",
        success: function (data) {
            if (data.flag == 0) {
                $('#treeView').treeview({
                    data: data.message,
                    levels: 1
                });
            }
        },
        error: function (xhr) {
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

        showMsgText: function (text) {
            $.showMsg({text: text});
        }

    });
});
var ADD_OPERA_ID = "addTable";

var EDIT_OPERA_ID = "editTable";

var DEL_OPERA_ID = "delTable";

function setCenterHeight() {
    var height = $(window).height();
    var centerHeight = height - 240;
    $(".right_content").height(centerHeight).css("overflow", "auto");
};

$(function () {

    //设置组织树框高度
    setCenterHeight();

    //新增节点按钮
    $("#btnAdd").click(function () {
        $("table.table").hide();
        $("table.table-add").show();
    });

    //编辑节点按钮
    $("#btnEdit").click(function () {
        $("table.table").hide();
        $("table.table-edit").show();
    });

    //删除节点按钮
    $("#btnDel").click(function () {
        $("table.table").hide();
        $("table.table-del").show();
    });

    $("#editButton").click(function () {
        var tableId = "";
        $("table").each(function () {
            if (!$(this).is(":hidden")) {
                tableId = $(this).attr("id");
            }
        });
        operaPanel(tableId);
    });
});

function operaPanel(divType){
    var node = $('#treeView').treeview('getSelected');
    if (node.length == 0) {
        $.showMsgText('请选择节点');
        return;
    }
    if (divType == ADD_OPERA_ID) {
        var addNodeName = $("input#addNodeName").val().trim();
        if (addNodeName && addNodeName!=""){
            //todo ajax
        } else {
            $.showMsgText('请输入新增部门名称!');
            return;
        }
    } else if (divType == EDIT_OPERA_ID){
        var parentId = $("select.parentNode-select").val();
        var editNodeId = $("input#editNodeId").val();
        var addNodeName = $("input#editNodeName").val();
        if (addNodeName && addNodeName!="" && editNodeId) {
            //todo ajax
        } else {
            $.showMsgText('请输入部门名称!');
            return;
        }
    } else if (divType == DEL_OPERA_ID){
        var delNodeId = $("input#delNodeId").val();
        if (delNodeId) {
            //todo ajax
        } else {
            $.showMsgText('请选择删除的部门!');
            return;
        }
    }
}
