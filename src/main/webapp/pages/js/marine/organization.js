$(document).ready(function(){
    $.ajax({
        url:"/Organization/getTree",
        type:"POST",
        dateType:"json",
        success:function (data) {
            if (data.flag == 0){
                alert(data.message);
                $('#treeView').treeview({
                    data: data.message
                });
            }
        },
        error:function (xhr) {
            alert(xhr.responseText);
        }
    });
});