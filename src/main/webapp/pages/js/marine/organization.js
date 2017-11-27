$(document).ready(function(){
    $.ajax({
        url:"/Organization/getTree",
        type:"POST",
        dateType:"json",
        success:function (data) {
            alert(2);
            alert(data);
            $('#treeView').treeview({
                data: data.message
            });
        },
        error:function (xhr) {
            alert(xhr.responseText);
        }
    });
});