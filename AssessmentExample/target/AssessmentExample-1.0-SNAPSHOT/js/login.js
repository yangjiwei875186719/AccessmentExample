$("form").submit(function(e) {
 	e.preventDefault();
 });
$("#btnLogin").openLoadForm("正在登录，请稍等。。。",function(openId){
	var usreData = {
		id: "",
		password: "",
		role: ""
	};
	usreData.id = $("#user").val();
	usreData.password = $("#password").val();
	usreData.role = $("#role").val();
	console.log(usreData);
	if (usreData.id == "" || usreData.password == "") {
		alert("用户名或者密码为空!");
		throw new SyntaxError("用户名或者密码为空!");
	}

	$.ajax({
		url: '/login',
		type: "post",
		data: usreData,
		dataType: 'json',
		success: function(res) {
			$.closeLoadForm(openId);
			if (res.code != 0) {
				alert(res.msg);
				throw new SyntaxError(res.msg);
			}

			localStorage.setItem("loginUser",JSON.stringify(res.data));

			alert("登录成功");
			window.location = "../main.html";
		},
		error:function(res){
			console.log(res);
			$.closeLoadForm(openId);
		}

	});

});
