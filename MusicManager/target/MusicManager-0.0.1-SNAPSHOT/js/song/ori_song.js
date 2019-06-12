// JavaScript Document
$(function($){
		   
	var $table = $("#usertab");
	$table.bootstrapTable({
        height: '600px',
        //设置请求的URL，向后台拉取数据
        url: "/MusicManager/getSongListController.do",
        //设置Http Get
        method: "GET",
        pagination:true,
        pageNumber:1,
        sidePagination: 'client',//客户端分页
        pageSize: 5,

        columns : [
			{
				field : 'select',
				checkbox : true,
				align : "center",
				valign : 'middle',
			}, {
				field : 'id',
				title : '序号',
				align : "center",
				valign : 'middle',
			}, {
				field : 'songName',
				title : '歌单名称',
				align : "center",
				valign : 'middle',
			},

			{
				field : 'title',
				title : '手机副标题',
				align : "center",
				valign : 'middle'
			},
			{
				field : 'upDate',
				title : '更新时间',
				align : "center",
				valign : 'middle'
			},
			{
				field : 'sort',
				title : '排序',
				align : "center",
				valign : 'middle'
			},
			{
				field : 'status',
				title : '状态',
				align : "center",
				valign : 'middle',
				//格式化后台数据，将01转化为修改或发布
				formatter : function(value, row, index) {
					return ((typeof (value) != "undefined") &&
					(value == 0)) ? "设计中" : "发布";
				}
			},

        ],
        
        


    });


	

});

