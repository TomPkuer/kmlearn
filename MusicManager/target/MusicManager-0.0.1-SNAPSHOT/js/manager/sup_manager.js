// JavaScript Document
$(function($){
		   
	var $table = $("#usertab");
	$table.bootstrapTable({
        height: '600px',
        //设置请求的URL，向后台拉取数据
        url: "/MusicManager/getUserListController.do",
        //设置Http Get
        method: "GET",
        pagination:true,//是否分页
        pageNumber:1,//首页页码
        sidePagination: 'client',//客户端分页
        pageSize: 5,//每一页数据量

        columns: [
            {
                field: 'select',
                checkbox: true,
                align: "center",
                valign: 'middle',
            }, {
                field: 'id',
                title: '编号',

                align: "center",
                valign: 'middle',
            }, {
                field: 'userName',
                title: '用户名',
                align: "center",
                valign: 'middle',
            },
            {
                field: 'sex',
                title: '性别',
                align: "center",
                valign: 'middle',
                //格式化后台数据，将01转化为性别男或女
                formatter: function (value, row, index) {
                    return ((typeof(value) != "undefined") &&
                        (value == 0)) ? "男" : "女";
                }

            },
            {
                field: 'age',
                title: '年龄',
                align: "center",
                valign: 'middle'

            },
            {
                field: 'mobilephone',
                title: '电话',
                align: "center",
                valign: 'middle'
            },
            {
                field: 'address',
                title: '住址',
                align: "center",
                valign: 'middle'
            }
        ],
        onCheck:function (row) {
            $("#remove").removeAttr("disabled");
            $("#modify").removeAttr("disabled");
            var selects=$table.bootstrapTable('getSelections');
            if(selects.length==1)
            	$("#modify").removeAttr("disabled");
            if(selects.length>1)
            	$("#modify").attr("disabled","disabled");

        },
        onUncheckAll:function () {
        	$("#remove").attr("disabled","disabled");
            $("#modify").attr("disabled","disabled");
            if(selects.length==1)
            	$("#modify").removeAttr("disabled");

        },
        onCheckAll:function () {
            $("#remove").removeAttr("disabled");
            $("#modify").removeAttr("disabled");
            var selects=$table.bootstrapTable('getSelections');
            if(selects.length==1)
            	$("#modify").removeAttr("disabled");
            if(selects.length>1)
            	$("#modify").attr("disabled","disabled");
            
            

        },

        onUncheck:function (row) {
            var selects=$table.bootstrapTable('getSelections');
            if (selects.length==0){
                $("#remove").attr("disabled","disabled")
                $("#modify").attr("disabled","disabled")
                }
                //修改按钮一次只能选中一个进行修改
                if(selects.length==1){
                	document.getElementById("modify").disabled=false;
            }

        }
        
        


    });


		//添加用户功能
	function addUser(){
				var userName = $("#user_name").val();
				var password = $("#password").val();
				var sex = $("#sex").val();
				var age=$("#age").val();
				var mobilePhone=$("#mobilephone").val();
				var address=$("#address").val();
				//构建请求参数
				var data= {

                    userName: userName,
                    password: password,
                    sex: sex,
                    age: age,
                    mobilePhone: mobilePhone,
                    address: address
                };
				$.ajax({
					url:"/MusicManager/addUserController.do",
					type:'POST',
					data:data,
					success:function (data) {
						if ((typeof (data)!="undefined")&&(data==0)){
							$table.bootstrapTable('refresh');
						}
                    },complete:function () {
						$('#myModal').modal('hide');

                    },
					context:this
				});
                }
      $("#add_user_Btn").bind("click",addUser);
      
     //删除用户通过id
	function delUser() {

	    var selects=$table.bootstrapTable("getSelections");
	    if (selects.length==0){
	        return;
        }
        var userIds="";
	    for (var i=0;i<selects.length;i++){
	        userIds=userIds+selects[i].id+",";
        }
        var param={
	        userIds:userIds
        };
	    $.ajax(
            {
                url:"/MusicManager/deleteUsersController.do",
                type:'POST',
                data:param,
                success:function (data) {
                    if ((typeof (data)!="undefined")&&(data==0)){
                        $table.bootstrapTable('refresh');
                    }
                    

                    },complete:function () {       				
                    $("#remove").attr("disabled","disabled");                  
                    $('#deletemodal').modal('hide');
                },
                centext:this

            });


    }
    $("#delete_user_Btn2").bind("click",delUser);
    //初始化修改界面的模态框，从表格获取数据
    function initmodifyUser() {
    	
	       
        //从表格中获取选中行的信息
    	var selects=$table.bootstrapTable('getSelections');
        var username=selects[0].userName;
		var sex = selects[0].sex;
		var age=selects[0].age
		var mobilePhone=selects[0].mobilephone;
		var address=selects[0].address
		//获取选中的用户信息
		var t=document.getElementById("user_name2");
		t.value=username;
		
		var t2=document.getElementById("age2");
		t2.value=age;
		
		var t3=document.getElementById("sex2");
		t3.value=sex;
		
		var t4=document.getElementById("mobilephone2");
		t4.value=mobilePhone;
		
		var t5=document.getElementById("address2");
		t5.value=address;
		
		
		
		
        
        //alert(username+sex+age+mobilePhone+address);
	    

    	$("#modifymodal").modal("toggle");

    }
    $("#modify").bind("click",initmodifyUser);
    
    function modifyUser(){
    	var selects=$table.bootstrapTable('getSelections');
    	var id=selects[0].id;
    	var userName = $("#user_name2").val();
		var password = $("#password2").val();
		var sex = $("#sex2").val();
		var age=$("#age2").val();
		var mobilePhone=$("#mobilephone2").val();
		var address=$("#address2").val();
    	//alert(id+age+sex);
		var data= {
                id:id,
                userName: userName,
                password: password,
                sex: sex,
                age: age,
                mobilePhone: mobilePhone,
                address: address
            };
		$.ajax({
			//向提交修改数据
			url:"/MusicManager/modifyUserController.do",
			type:'POST',
			data:data,
			success:function (data) {
				if ((typeof (data)!="undefined")&&(data==0)){
					$table.bootstrapTable('refresh');
				}
            },complete:function () {
				$('#modifymodal').modal('hide');
				$('#modifymodal2').modal('hide');

            },
			context:this
		});
   	
    }
    $("#modify_user_Btn2").bind("click",modifyUser);
    

});

