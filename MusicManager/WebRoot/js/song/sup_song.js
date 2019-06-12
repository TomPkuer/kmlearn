// JavaScript Document
$(function($) {

	var $table = $("#usertab");
	$table.bootstrapTable({
		height : '600px',
		//设置请求的URL，向后台拉取数据
		url : "/MusicManager/getSongListController.do",
		//设置Http Get
		method : "GET",
		pagination : true, //是否分页
		pageNumber : 1, //首页页码
		sidePagination : 'client', //客户端分页
		pageSize : 5, //每一页数据条数

		columns : [
			{
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
			//增加操作栏
			{
				field : 'operate',
				title : '操作',
				align : 'center',
				events : operateEvents,
				formatter : operateFormatter,
			},


		],
		onClickRow : function(row, $element) {

			var t = document.getElementById("modify_name"); //点击当前行，获取设备名
			t.value = row.songName;

			var t2 = document.getElementById("modify_title"); //获取设备标题
			t2.value = row.title;

			var t3 = document.getElementById("modify_sort"); //获取设备分类
			t3.value = row.sort;

			var t4 = document.getElementById("modify_status"); //获取设备状态
			t4.value = row.status;

			var t5 = document.getElementById("ID"); //获取设备ID

			t5.value = row.id;
		},
	});



	//添加音乐功能
	function addSong() {
		var songName = $("#add_name").val();
		var title = $("#add_title").val();
		var sort = $("#add_sort").val();
		var status = $("#add_status").val();
		//var imgurl = getObjectURL($("#file")[0].files[0]);
		//alert(imgurl);

		//构建请求参数

		var data = {
			songName : songName,
			title : title,
			sort : sort,
			status : status
		};
		//向后台提交数据
		$.ajax({
			url : "/MusicManager/addSongController.do",
			type : 'POST',
			data : data,
			success : function(data) {
				//提交成功刷新表格信息
				if ((typeof (data) != "undefined") && (data == 0)) {
					$table.bootstrapTable('refresh');
				}
			},
			complete : function() {
				$('#addModal').modal('hide');

			},
			context : this
		});
	}
	$("#add_song_Btn").bind("click", addSong);//点击按钮绑定事件






});
//操作栏添加功能按钮
function operateFormatter(value, row, index) {
	return [
		'<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">编辑</button>',
		'<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">删除</button>',
		'<button type="button" class="RoleOfC btn btn-default  btn-sm" style="margin-right:15px;">推送</button>',

	].join('');
}
window.operateEvents = {
	'click .RoleOfA' : function(e, value, row, index) {
		initModifySong();
	},
	'click .RoleOfB' : function(e, value, row, index) {
		initdel();
	},
	'click .RoleOfC' : function(e, value, row, index) {
		uploadfile();
	}
};
function uploadfile(){
	$("#uploadmodal").modal("toggle");
}

//修改初始化，弹出修改设备模态框
function initModifySong() {
		$("#modifymodal").modal("toggle");//弹出修改设备的模态框

}
//提交修改音乐信息请求
function modifySong() {
	var $table = $("#usertab");
	var id = $("#ID").val();
	var songName = $("#modify_name").val();
	var title = $("#modify_title").val();
	var sort = $("#modify_sort").val();
	var status = $("#modify_status").val();
	//alert(id+age+sex);
	var data = {
		id : id,
		songName : songName,
		title : title,
		sort : sort,
		status : status
	};
	$.ajax({
		url : "/MusicManager/modifySongController.do",
		type : 'POST',
		data : data,
		success : function(data) {
			if ((typeof (data) != "undefined") && (data == 0)) {
				$table.bootstrapTable('refresh');
			}
		},
		complete : function() {
			//完成提交后模态框隐藏
			$('#modifymodal').modal('hide');
			$('#modifymodal2').modal('hide');

		},
		context : this
	});

}
$("#modify_confirm_Btn").bind("click", modifySong);

//弹出删除确认模态框
function initdel() {
	$("#deletemodal").modal("toggle");

}
//删除用户
function delSong() {
	var $table = $("#usertab");
	var songIds = $("#ID").val();
	var param = {
		songIds : songIds
	};
	$.ajax(
		{
			url : "/MusicManager/deleteSongController.do",
			type : 'POST',
			data : param,
			success : function(data) {
				if ((typeof (data) != "undefined") && (data == 0)) {
					$table.bootstrapTable('refresh');
				}


			},
			complete : function() {
				$("#remove").attr("disabled", "disabled");
				$('#deletemodal').modal('hide');
			},
			centext : this
		});


}
$("#delete_confirm_Btn").bind("click", delSong);
//表单提交
function checkForm(){
	$("#fileSubmitForm").submit();
	alert("提交完成");
}
$("#formSubmit").bind("click", checkForm);
