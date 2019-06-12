<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<head>
<title>音乐管理</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-table.min.css">

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script><script src="js/bootstrap-table.min.js"></script>
<script src="js/bootstrap-table-locale-all.min.js"></script>
<script src="js/song/sup_song.js"></script>
<!-- 功能逻辑 -->
<base href="<%=basePath%>">	
	
</head>

<body>
	<div class="panel panel-default">
		<div class="panel-heading">音乐信息管理</div>
		<div id="toolbar">
			<button id="add" type="button" class="btn btn-primary"
				data-toggle="modal" data-target="#addModal">添加</button>
			<input type="text" id="ID" style="display:none"/>
		</div>
		<table id="usertab" data-toolbar="#toolbar" data-search="true"
			data-show-refresh="true" data-show-toggle="true" data-show-columns="true"
			>
		</table>


	</div>
	<!-- 添加信息模块 -->
	<div>
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">音乐信息</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<label for="songname" class="col-sm-4 control-label">
								歌单名： </label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="add_name"
									placeholder="请输入歌曲名" />
							</div>

						</div>


						<div class="row">
							<label for="title" class="col-sm-4 control-label"> 手机副标题:
							</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="add_title"
									placeholder="请输入标题" />
							</div>
						</div>


						<div class="row">
							<label for="sort" class="col-sm-4 control-label"> 排序: </label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="add_sort"
									placeholder="请输入排序" />
							</div>
						</div>

						<div class="row">
							<label for="status" class="col-sm-4 control-label"> 状态: </label>
							<div class="col-sm-8">
								<select id="add_status" class="form-control">
									<option value='0'>设计中</option>
									<option value='1'>发布</option>
								</select>
							</div>
						</div>

						

					</div>
					<!-- /.modal-body -->
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="add_song_Btn"
							data-dismiss="modal">添加</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">
							关闭</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<!-- 修改用户信息 -->
		<div>
			<div class="modal fade" id="modifymodal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">修改音乐信息</h4>
						</div>

						<div class="modal-body">
							<div class="row">
								<label for="songname" class="col-sm-4 control-label">
									歌单名： </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="modify_name"
										placeholder="请输入歌曲名" />
								</div>

							</div>


							<div class="row">
								<label for="title" class="col-sm-4 control-label">
									手机副标题: </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="modify_title"
										placeholder="请输入标题" />
								</div>
							</div>


							<div class="row">
								<label for="sort" class="col-sm-4 control-label"> 排序: </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="modify_sort"
										placeholder="请输入排序" />
								</div>
							</div>

							<div class="row">
								<label for="status" class="col-sm-4 control-label"> 状态:
								</label>
								<div class="col-sm-8">
									<select id="modify_status" class="form-control">
										<option value='0'>设计中</option>
										<option value='1'>发布</option>
									</select>
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								id="modify_song_Btn" data-toggle="modal"
								data-target="#modifymodal2" data-dismiss="modal">提交更改</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
		</div>

		<!-- 确认提交修改-->
		<div>
			<div class="modal fade" id="modifymodal2" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>

						</div>

						<div class="modal-body">
							<div class="text" style=" text-align:center;">确认修改?</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								id="modify_confirm_Btn" data-dismiss="modal">确认</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">返回</button>

						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
		</div>

		<!-- 删除确认 -->
		<div>
			<div class="modal fade" id="deletemodal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>

						</div>

						<div class="modal-body">
							<div class="text" style=" text-align:center;">确认删除？</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								id="delete_confirm_Btn" data-dismiss="modal">确认</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">返回</button>

						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
		</div>

	<!-- 文件上传 -->
	<div>
			<div class="modal fade" id="uploadmodal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">上传文件</h4>
						</div>

						<div class="modal-body">
							<div class="row">
								<label for="adress" class="col-sm-4 control-label">
									选择文件: </label>

								<div class="col-sm-8">
									<form id="fileSubmitForm" action="<%=basePath%>Up2Servlet"
										method="post" enctype="multipart/form-data" target="nm_iframe">
										<input type="file" name="txt" id="file"><br/> 
									</form>
									<iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>
								</div>
							</div>
						</div>
						<!-- /.modal-body -->
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary" id="formSubmit" data-dismiss="modal">确认</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>

						</div>
						<!-- /.modal-footer -->

					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
		</div>
		
</body>
</html>
