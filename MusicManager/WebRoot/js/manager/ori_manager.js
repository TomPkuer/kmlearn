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
        
        


    });


	

});

