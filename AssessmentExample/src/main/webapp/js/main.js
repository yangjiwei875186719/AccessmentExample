$(function() {
	
	var vue = new Vue({
		el: '#app',
		data: {
			user: []
		},
		mounted: function() {
			this.init();
		},
		methods: {
			
			init:function(){
				var loginUser= localStorage.getItem("loginUser");
				console.log(loginUser);
				Vue.set(this.user, 0, JSON.parse(loginUser));
				// var that = this;
				// this.$http.get('/CreditAssessmentOS/json/user.json').then(function(res) {
				// 	if(res.data.code != 0){
				// 		alert(res.data.msg);
				// 		throw new  SyntaxError();
				// 	}
				// 	console.log(res);
				// 	// that.user = res.body.data
				// 	Vue.set(that.user, 0, res.data.data);
					
				// 	}),
				// 	function(res) {
				// 		alert('服务器链接失败！');
				
				// 	}
					
					
			}
			
		}
	})
})
