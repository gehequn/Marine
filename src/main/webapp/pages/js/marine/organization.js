$(document).ready(function () {

    $.ajax({
        url: "/Organization/getTree",
        type: "POST",
        dateType: "json",
        success: function (data) {
            if (data.flag == 0) {
                $('#treeView').treeview({
                    data: data.message,
                    levels: 1,
                    onNodeSelected:function(event, node){
                        setOperaNode(node);
                    }
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

function setOperaNode(node){
    var tableId = "";
    $("table").each(function () {
        if (!$(this).is(":hidden")) {
            tableId = $(this).attr("id");
        }
    });
    if (tableId == ADD_OPERA_ID) {
        $('#addParentName').val(node.text);
        $('#addParentId').val(node.id);
    } else if (tableId == EDIT_OPERA_ID){
        $('#editNodeName').val(node.text);
        $('#editParentId').val(node.id);
        var parentNods = $('#treeView').treeview('getParents',node);
        //清空select
        $('select.parentNode-select').html("");
        $.ajax({
            url:"/Organization/getOrgUpList",
            type:"POST",
            dateType:"json",
            data:{orgId:node.id},
            success:function (map) {
                if (map.flag == 0){
                    var appendStr = "";
                    var items = eval('(' + map.message + ')');
                    //存在父节点情况
                    if (parentNods.length >0) {
                        for (var i in items){
                            if (parentNods[0].id == items[i].id){
                                appendStr += "<option value='"+items[i].id+"' selected = 'selected'>"+items[i].orgName+"</option>";
                            } else {
                                appendStr += "<option value='"+items[i].id+"'>"+items[i].orgName+"</option>";
                            }
                        }
                    } else {
                        for (var i in items){
                            appendStr += "<option value='"+items[i].id+"'>"+items[i].orgName+"</option>";
                        }
                    }
                    $('select.parentNode-select').append(appendStr);
                } else {
                    $.showMsgText(map.message);
                    return;
                }
            }
        });
    } else {
        $('#delNodeName').val(node.text);
        $('#delNodeId').val(node.id);
    }
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

function operaPanel(divType) {
    var node = $('#treeView').treeview('getSelected');

    //增加新部门
    if (divType == ADD_OPERA_ID) {
        var addNodeName = $("input#addNodeName").val().trim();
        if (addNodeName && addNodeName != "") {
            $.ajax({
                url: "/Organization/addOrganization",
                type: "POST",
                dateType: "json",
                data: {
                    orgName:addNodeName,
                    parentOrgId:$('#addParentId').val(),
                    parentOrgName:$('#addParentName').val()
                },
                success: function (map) {
                    if (map.flag == 0) {
                        var singleNode = {
                            text: map.message.orgName,
                            id: map.message.id
                        };
                        $('#treeView').treeview("addNode", [singleNode, node]);
                    } else {
                        $.showMsgText(map.message);
                        return;
                    }
                }
            });
        } else {
            $.showMsgText('请输入新增部门名称!');
            return;
        }
    } else if (divType == EDIT_OPERA_ID) {
        var parentId = $("select.parentNode-select").val();
        var editNodeId = $("input#editNodeId").val();
        var addNodeName = $("input#editNodeName").val();
        console.log(parentId);
        if (addNodeName && addNodeName != "" && editNodeId) {
            $.ajax({
                url: "/Organization/editOrganization",
                type: "POST",
                dateType: "json",
                data: {
                    orgId:editNodeId,
                    orgName:addNodeName,
                    parentOrgId:parentId
                },
                success: function (map) {
                    if (map.flag == 0) {
                        window.location.href = "/Organization/init";
                    } else {
                        $.showMsgText(map.message);
                        return;
                    }
                }
            });
        } else {
            $.showMsgText('请输入部门名称!');
            return;
        }
    } else if (divType == DEL_OPERA_ID) {
        if (node.length == 0) {
            $.showMsgText('请选择节点');
            return;
        }
        var delNodeId = $("input#delNodeId").val();
        if (delNodeId) {
            $.ajax({
                url: "/Organization/delOrganization",
                type: "POST",
                dateType: "json",
                data: {
                    orgId:delNodeId
                },
                success:function (map) {
                    if (map.flag ==0){
                        $('#treeView').treeview('removeNode',node);
                    } else {
                        $.showMsgText(map.message);
                        return;
                    }
                }
            });
        } else {
            $.showMsgText('请选择删除的部门!');
            return;
        }
    }
}
