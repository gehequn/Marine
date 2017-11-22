/**
 * Created by gehequn on 2017/5/9.
 */
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
function registerAjax() {
    $.ajax({
        url:"/Register/register",
        type:"POST",
        dateType:"json",
        data:$(".registerForm").serialize(),
        success:function (data) {
            if (data.flag == 0) {
                window.location.href="/Welcome/init";
            } else {
                alert(data.message);
            }
        },
        error:function (xhr) {
            alert(xhr.responseText);
        }
    });
}
