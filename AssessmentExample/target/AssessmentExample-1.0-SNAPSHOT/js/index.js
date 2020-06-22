$(function() {
	
	var vue = new Vue({
		el: '#app',
		data: {
			assessmentInfo: []
		},
		mounted: function() {
			this.init();
		},
		methods: {
			
			init:function(){
				var that = this;
				if(that.assessmentInfo!=null && that.assessmentInfo!=""){
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
				this.$http.get('/queryAssessment?no='+no).then(function(res) {
					if(res.data.code != 0){
						alert(res.data.msg);
						throw new  SyntaxError();
					}

						Vue.set(that.assessmentInfo, 0, res.data.data);
						console.log(that.assessmentInfo);
					}),
					function(res) {
						alert('服务器链接失败！');

					}
			},
		}
	})
})
