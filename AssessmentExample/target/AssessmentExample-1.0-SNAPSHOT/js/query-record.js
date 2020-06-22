$(function() {
	
	var vue = new Vue({
		el: '#app',
		data: {
			record: []
		},
		mounted: function() {
			this.init();
		},
		methods: {
			
			init:function(){
				var that = this;
				if(that.record!=null && that.record!=""){
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
				this.$http.get('/queryRecord?no='+no).then(function(res) {
					if(res.data.code != 0){
						alert(res.data.msg);
						throw new  SyntaxError(res.data.msg);
					}
						Vue.set(that.record, 0, res.data.data);
						console.log(that.record);
					}),
					function(res) {
						alert('服务器链接失败！');

					}
			},
		}
	})
})
