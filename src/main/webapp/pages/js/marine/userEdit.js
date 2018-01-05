$(function() {
    // 1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    // 2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

});

var TableInit = function() {
    var param = {};
    var queryParam = {};
    param.url = '/User/record';
    param.table = 'tb_userInfo';
    queryParam.limit = 10;
    queryParam.offset = 1;
    param.param = queryParam;
    param.columns =  [
        // {
        // checkbox : true
        // },
        {
        field : 'id',
        title : '用户id'
    }, {
        field : 'userName',
        title : '用户id'
    }, {
        field : 'nickName',
        title : '用户昵称'
    } ,{
        field : 'id',
        title : '操作',
        align: 'center',
        formatter:function(value,row,index){
            var e = '<input class="btn btn-success" type="button" value="编辑节点" onclick="editUser(\''+ row.id + '\')"/>';
            var d = '<input class="btn btn-danger" type="button" value="删除节点" onclick="delUser(\''+ row.id +'\')"/>';
            return e+d;
        }
    }];
    var oTableInit = new Object();
    var marineInit = new MarineTableInit(param);
    // 初始化Table
    oTableInit.Init = function() {
        marineInit.Init();
    };

    return oTableInit;
};

var ButtonInit = function () {
    var oInit = new Object();

    oInit.Init = function () {
        //初始化页面上面的按钮事件
        $("#user_query").click(function() {
            $("#tb_userInfo").bootstrapTable('refresh');
        });
    };

    return oInit;
};

function editUser() {
    // console.log(userId);
    $.FORM.showFormDialog({});
}

function delUser(userId) {
    // console.log(userId);
    console.log('');
}