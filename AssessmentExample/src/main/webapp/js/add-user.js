$(function(){
	$("#btnUpload").openLoadForm("正在上传数据,请稍等。。。",function(openId){
		var formData = new FormData($("#upForm")[0]);
		$.ajax({
			url: '/addSalesmanUpload',
			type: "post",
			data: formData,
			//async: false,
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
	
});