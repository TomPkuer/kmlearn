// JavaScript Document
$(function($){
		   
	var $table = $("#usertab");
	
	$table.bootstrapTable({
        height: '600px',
        //设置请求的URL，向后台拉取数据
        url: "/MusicManager/getAndroidListController.do",
        //设置Http Get
        method: "GET",
        pagination:true,
        pageNumber:1,
        sidePagination: 'client',//客户端分页
        pageSize: 5,
        
        columns: [
            {
                field: 'select',
                checkbox: true,
                align: "center",
                valign: 'middle',
            }, {
                field: 'deviceID',
                title: '设备编号',
                align: "center",
                valign: 'middle',
            }, {
                field: 'deviceName',
                title: '设备名',
                align: "center",
                valign: 'middle',
            },{
                field: 'deviceType',
                title: '设备类型',
                align: "center",
                valign: 'middle',
                
                formatter: function (value, row, index) {
                    return ((typeof(value) != "undefined") &&
                        (value == 0)) ? "安卓" : "开发板";
                }
            },{
                field: 'time',
                title: '操作时间',
                align: "center",
                valign: 'middle',
            },
            
            
            
            {
                field: 'type',
                title: '设备状态',
                align: "center",
                valign: 'middle',
                //格式化后台数据，将01转化为性别男或女
                formatter: function (value, row, index) {
                    return ((typeof(value) != "undefined") &&
                        (value == 0)) ? "离线" : "在线";
                }

            },
            
        ],
        onCheck:function (row) {
            $("#remove").removeAttr("disabled");
            $("#modify").removeAttr("disabled");
            $("#push").removeAttr("disabled");
            var selects=$table.bootstrapTable('getSelections');
            if(selects.length==1){
            	$("#modify").removeAttr("disabled");
            	$("#push").removeAttr("disabled");
            	}
            if(selects.length>1){
            	$("#modify").attr("disabled","disabled");
            	$("#push").attr("disabled","disabled");
            	}

        },
        onUncheckAll:function () {
        	$("#remove").attr("disabled","disabled");
            $("#modify").attr("disabled","disabled");
            

        },
        onCheckAll:function () {
            $("#remove").removeAttr("disabled");
            var selects=$table.bootstrapTable('getSelections');
            if(selects.length==1)
            	$("#modify").removeAttr("disabled");
        		$("#push").removeAttr("disabled");  	
            if(selects.length>1)
            	$("#modify").attr("disabled","disabled");
            	$("#push").attr("disabled","disabled");
            

        },

        onUncheck:function (row) {
            var selects=$table.bootstrapTable('getSelections');
            
            if (selects.length==0){
                $("#remove").attr("disabled","disabled")
                $("#modify").attr("disabled","disabled")
            	$("#push").attr("disabled","disabled");

             }
                //修改按钮一次只能选中一个进行修改
                if(selects.length==1){
                	document.getElementById("modify").disabled=false;
                	document.getElementById("push").disabled=false;

            }
                
        }
       
        
        


    });
	

		//添加用户功能
	function addDev(){
				var deviceID=$("#add_DevId").val();
				var deviceName = $("#add_DevName").val();
				var deviceType=$("#add_DevType").val();
				var type=$("#add_DevState").val();
				//构建请求参数
				var data= {

                    deviceID:deviceID,
                    deviceName:deviceName,
                    deviceType:deviceType,
                    type:type
                    
                };
				//向后台提交数据
				$.ajax({
					url:"/MusicManager/addDevController.do",
					type:'POST',
					data:data,
					success:function (data) {
						if ((typeof (data)!="undefined")&&(data==0)){
							$table.bootstrapTable('refresh');
						}else{
							alert("设备id重复，请重新输入");
						}
                    },complete:function () {
						$('#addmodal').modal('hide');

                    },
					context:this
				});
                }
      $("#add_confirm_Btn").bind("click",addDev);
      
     //删除设备通过id
	function delDev() {

	    var selects=$table.bootstrapTable("getSelections");
	    if (selects.length==0){
	        return;
        }
        var devIds="";
	    for (var i=0;i<selects.length;i++){
	        devIds=devIds+selects[i].deviceID+",";
        }
        var param={
	        devIds:devIds
        };
	    $.ajax(
            {
                url:"/MusicManager/deleteDevController.do",
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
    $("#delete_confirm_Btn").bind("click",delDev);
    
    //从选中行获取信息，初始化模态框信息  
    function initmodifyUser() {      
        //从表格中获取选中行的信息
    	var selects=$table.bootstrapTable('getSelections');
        var deviceName=selects[0].deviceName;
		var type = selects[0].type;
		var deviceType=selects[0].deviceType;
		//获取选中的用户信息
		var t=document.getElementById("modify_name");//获取设备名称
		t.value=deviceName;
		
		var t2=document.getElementById("modify_type");//获取选中行设备类型
		t2.value=deviceType;
		
		var t3=document.getElementById("modify_state");//获取设备描述
		t3.value=type;
		
		
        //alert(username+sex+age+mobilePhone+address);
	    

    	$("#modifymodal").modal("toggle");	//弹出修改的模态框

    }
    $("#modify").bind("click",initmodifyUser);//绑定按钮事件
    
     //修改用户信息
    function modifyDev(){
    	var selects=$table.bootstrapTable('getSelections');
    	var id=selects[0].deviceID;
    	var deviceName = $("#modify_name").val();
		var deviceType = $("#modify_type").val();
		var state=$("#modify_state").val();
		//alert("!!!");
    	//alert(id+age+sex);
		var data= {
                deviceID:id,
                deviceName: deviceName,
                deviceType:deviceType,
                type:state,
                
            };
		//提交添加信息
		$.ajax({
			url:"/MusicManager/modifyDevController.do",
			type:'POST',
			data:data,
			success:function (data) {
				if ((typeof (data)!="undefined")&&(data==0)){
					$table.bootstrapTable('refresh'); //数据提交成功以后，刷新模态框信息
				}
            },complete:function () {
				$('#modifymodal').modal('hide'); //操作结束后，隐藏模态框
				$('#modify_confirm').modal('hide');

            },
			context:this
		});
   	
    }
    $("#modify_confirm_Btn").bind("click",modifyDev);//事件绑定
    
    
    function pushadv(){
    	var selects=$table.bootstrapTable('getSelections');
    	var id=selects[0].deviceID;
    	var adv=$("#adv_info").val();
    	
    	var data={
    			advertisement:adv,
    			id:id,
    	};
    	$.ajax({
			url:"/MusicManager/sendAdvertisementController.do",
			type:'POST',
			data:data,
			success:function (data) {
				

            },
			context:this
		});
    	alert("发送成功！");
    }
    $("#push_adv_Btn").bind("click",pushadv);
    
   
});





