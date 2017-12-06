function loginAjax() {
    $.ajax({
        url: "/Login/welcome",
        type: "POST",
        dateType: "json",
        data: $(".loginForm").serialize(),
        success: function (map) {
            if (map.flag == 0) {
                window.location.href = "/Welcome/init";
            } else {
                alert(map.message);
            }
        }
    });
}