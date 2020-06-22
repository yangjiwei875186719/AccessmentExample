$(function() {

	var vue = new Vue({
		el: '#app',
		data: {
			userInfo: []
		},
		mounted: function() {
			this.init();
		},
		methods: {

			init: function() {
				var user = sessionStorage.getItem("user");
				console.log(user);
				var u = JSON.parse(user);
				u.defaultRecord = u.defaultRecord == "无违约记录" ? 'N' : 'Y';
				Vue.set(this.userInfo, 0, u);
			},
			update: function(e) {
				var updateData = {};
				var formData = $('#myform').serializeArray();
				$.each(formData, function() {
					updateData[this.name] = this.value;
				});
				updateData.no=this.userInfo[0].no;
				updateData.name=this.userInfo[0].name;
				updateData.sex=this.userInfo[0].sex;
				updateData.age=this.userInfo[0].age;

				console.log(updateData);
				$.ajax({
					url: '/updateUserInfo',
					type: "post",
					data: updateData,

					dataType: 'json',
					success: function(res) {
						if (res.code == 2) {
							alert("服务器错误!");
							throw new SyntaxError("服务器错误!");
						} else if (res.code == 1) {
							alert("修改失败，请重试");
						} else {
							alert("修改成功");
							window.location = "../page/add-information.html";
						}

					}

				})

			}
		}
	})
})
