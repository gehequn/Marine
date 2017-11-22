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
    param.url = '/Welcome/record';
    param.table = 'tb_departments';
    queryParam.userId = 1;
    param.param = queryParam;
    param.columns =  [ {
        checkbox : true
    }, {
        field : 'id',
        title : '部门名称'
    }, {
        field : 'userName',
        title : '上级部门'
    }, {
        field : 'nickName',
        title : '部门级别'
    } ];
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
        $("#btn_query").click(function() {
            $("#tb_departments").bootstrapTable('refresh');
        });
    };

    return oInit;
};