$(function () {
    var item = localStorage.getItem("loginUser");
    if(item==null){
        parent.window.location = "/login-1.html"
    }
})