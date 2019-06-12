// JavaScript Document
$(function($){
		   
	var $table = $("#usertab");
	$table.bootstrapTable({
        height: '600px',
        //设置请求的URL，向后台拉取数据
        url: "/MusicManager/getDevListController.do",
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
       
        


    });


});

