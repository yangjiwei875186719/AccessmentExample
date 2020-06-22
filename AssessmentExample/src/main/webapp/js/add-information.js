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
			
			init:function(){
				var that = this;
				if(that.userInfo!=null && that.userInfo!=""){
					$(".result").hide();
				}
			},
			submit: function(e) {
				var no = $("#no").val();
				
				if(no=="" || no.length != 18){
					alert("无输入或格式不正确！");
					throw new  SyntaxError();
				}
				var that = this;
				this.$http.get('/queryUserInfo?no='+no).then(function(res) {
					if(res.data.code != 0){
						alert(res.data.msg);
						throw new  SyntaxError();
					}
					res.data.data.defaultRecord=res.data.data.defaultRecord == 'N'?"无违约记录":"有违约记录";
					Vue.set(that.userInfo, 0, res.data.data);
					}),
					function(res) {
						alert('服务器链接失败！');

					}
			},
			toUpdate: function(e){
				sessionStorage.setItem("user",JSON.stringify(this.userInfo[0]));
				
				window.location = "update-information.html"
			},

		}
	})

	$("#btnUpload").openLoadForm("正在上传数据,请稍等。。。",function(openId){
		//var file = $("#file")[0].files[0];
		var formData = new FormData($("#upForm")[0]);
		//console.log(file)
		$.ajax({
			url: '/fileUpload',
			type: "post",
			data: formData,

			contentType:false, //- 必须false才会自动加上正确的Content-Type
			processData: false, //- 必须false才会避开jQuery对 formdata 的默认处理,XMLHttpRequest会对 formdata 进行正确的处理
			dataType: 'json',
			success: function(res) {
				console.log(res);
				if (res.code == 0) {
					alert('上传成功！');
				}else{
					alert(res.msg);
				}
				$.closeLoadForm(openId);
			},
			error:function(res){
				console.log(res);
				$.closeLoadForm(openId);
			}

		});

	});
})
