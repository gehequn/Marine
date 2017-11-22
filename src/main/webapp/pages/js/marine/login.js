/**
 * Created by gehequn on 2017/5/11.
 */
function loginAjax() {
    $.ajax({
        url:"/Login/welcome",
        type:"POST",
        dateType:"json",
        data:$(".loginForm").serialize(),
        success:function (map) {
            if (map.flag == 0){
                window.location.href="/Welcome/init";
            } else {
                alert(map.message);
            }
        }
    });
}