var MarineTableInit = function(tableParams) {
    var oTableInit = new Object();
    // 初始化Table
    oTableInit.Init = function() {
        $("#" + tableParams.table).bootstrapTable({
            url : tableParams.url, // 请求后台的URL（*）
            method : tableParams.method?tableParams.method:'post', // 请求方式（*）
            contentType : "application/x-www-form-urlencoded",
            toolbar : tableParams.toolbar?tableParams.toolbar:'#toolbar', // 工具按钮用哪个容器
            striped : tableParams.striped?tableParams.striped:true, // 是否显示行间隔色
            cache : tableParams.cache?tableParams.cache:false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination : tableParams.pagination?tableParams.pagination:true, // 是否显示分页（*）
            sortable : tableParams.sortable?tableParams.sortable:false, // 是否启用排序
            sortOrder : tableParams.sortOrder?tableParams.sortOrder:"asc", // 排序方式
            queryParams : oTableInit.queryParams,// 传递参数（*）
            sidePagination : tableParams.sidePagination?tableParams.sidePagination:"server", // 分页方式：client客户端分页，server服务端分页（*）
            pageNumber : tableParams.pageNumber?tableParams.pageNumber:1, // 初始化加载第一页，默认第一页
            pageSize : tableParams.pageSize?tableParams.pageSize:10, // 每页的记录行数（*）
            pageList : tableParams.pageList?tableParams.pageList:[ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
            search : tableParams.search?tableParams.search:false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch : tableParams.strictSearch?tableParams.strictSearch:true,
            showColumns : tableParams.showColumns?tableParams.showColumns:true, // 是否显示所有的列
            showRefresh : tableParams.showRefresh?tableParams.showRefresh:true, // 是否显示刷新按钮
            minimumCountColumns : tableParams.minimumCountColumns?tableParams.minimumCountColumns:2, // 最少允许的列数
            clickToSelect : tableParams.clickToSelect?tableParams.clickToSelect:true, // 是否启用点击选中行
            height : tableParams.height?tableParams.height:500, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId : tableParams.uniqueId?tableParams.uniqueId:"ID", // 每一行的唯一标识，一般为主键列
            showToggle : tableParams.showToggle?tableParams.showToggle:true, // 是否显示详细视图和列表视图的切换按钮
            cardView : tableParams.cardView?tableParams.cardView:false, // 是否显示详细视图
            detailView : tableParams.detailView?tableParams.detailView:false, // 是否显示父子表
            columns : tableParams.columns
        });
    };

    // 得到查询的参数
    oTableInit.queryParams = function(tableParams) {
        var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit : tableParams.limit?tableParams.limit:10, // 页面大小
            offset : tableParams.offset?tableParams.offset:1 // 页码
        }
        // 循环遍历param
        for (var prop in tableParams.param){
            if(tableParams.param.hasOwnProperty(prop)){
                temp[prop] = tableParams.param[prop];
            }
        }
        // for (var prop in temp){
        //     console.log(temp[prop]);
        // }
        return temp;
    };
    return oTableInit;
};
