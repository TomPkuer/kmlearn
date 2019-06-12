(function($) {

	function login(event) {
		event.preventDefault();

		var userName = $("#username").val(); //获取用户名

		var password = $("#userpwd").val(); //获取密码

		//Ajax向后台提交用户名、密码

		$.post("/MusicManager/loginController.do", {
			username : userName,
			password : password
		},

			function(data) {
				if ((typeof (data) != "undefined") && (null != data) && (0==data)) {
					//登录成功后隐藏登录表单
//					$(".contain").hide();
//					//跳转到用户列表界面
//					$("#content").load("/UserManager/listUserController.do");
					
						window.location.href="ori_manager.html";//跳转普通管理员界面
						//alert("commmon"); 
				}else if((typeof (data) != "undefined") && (null != data) && (1==data)){
						window.location.href="sup_manager.html";//跳转超级管理员界面
						//alert("super");
				}else {
						alert("用户名或密码错误！");
					}
					
					
				 

			});
	}

	$("#loginbtn").bind("click", login); //为loginbtn绑定事件
	
	//cookie记录用户名密码
	

})($);