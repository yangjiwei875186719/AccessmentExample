$(function() {
	
	var vue = new Vue({
		el: '#app',
		data: {
			assessment: []
		},
		mounted: function() {
			this.init();
		},
		methods: {
			
			init:function(){
				var that = this;
				if(that.assessment!=null && that.assessment!=""){
					$(".result").hide();
				}
			},submit: function(e) {
				var no = $("#no").val();
				if(no=="" || no.length != 18){
					alert("无输入或格式不正确！");
					throw new  SyntaxError();
				}
				var that = this;
				this.$http.get('/queryAssessment?no='+no).then(function(res) {
					if(res.data.code != 0){
						alert(res.data.msg);
						throw new  SyntaxError();
					}
						Vue.set(that.assessment, 0, res.data.data);
					if(res.data.data.remarks != "无备注"){
						$("#btn").hide();
					}
						console.log(that.assessment);
					}),
					function(res) {
						alert('服务器链接失败！');

					}
			},
			ensure: function(e) {
				var money = prompt("输入放贷金额", "0");
				var loginUser = JSON.parse(localStorage.getItem("loginUser"));
				var record = {
					no:this.assessment[0].no,
					salesmanId : loginUser.id,
					loan:money
				}
				if(!/^[0-9]*$/.test(money) || money < 0){
					alert("请输入正确数字！");
					throw new SyntaxError("数字格式不正确");
				}
				console.log(record);
				var that = this;
				$.ajax({
					url: '/lending',
					type: "post",
					data: record,
					dataType: 'json',
					success: function(res) {
						if (res.code != 0) {
							alert(res.msg);
							throw new SyntaxError(res.msg);
						}

						alert("放贷成功");
						that.assessment[0].remarks = "已被放贷，金额：￥"+money;
						console.log(that.assessment[0]);
					},
					error:function(res){
						console.log(res);
					}

				});


			}
		}
	})
})
