<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<head>
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-table.min.css">

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-table.min.js"></script>
<script src="js/bootstrap-table-locale-all.min.js"></script>
<script src="js/manager/sup_manager.js"></script>  <!-- 功能逻辑 -->



</head>

<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			用户信息管理
		</div>
		<div id="toolbar">
			<button id="add" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
			添加
			</button>
			<button id="remove" type="button" class="btn btn-primary" disabled='disabled' style="background:red " data-toggle="modal" data-target="#deletemodal" >
			删除
			</button>
			<button id="modify" type="button" class="btn btn-primary"  disabled='disabled'>
			修改
			</button>
			
		</div>
		<table id="usertab"
			data-toolbar="#toolbar"
  			data-search="true"
  			data-show-refresh="true"
			data-show-toggle="true">
		</table>
		
		
	</div>
	<!-- 添加信息模块 -->
<div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">
					用户信息
				</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<label for="username" class="col-sm-4 control-label">
						用户名：
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="user_name" placeholder="请输入用户名："/>	
					</div>
					
				</div>
				<div class="row">
					<label for="password" class="col-sm-4 control-label">
						密码：
					</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="password" placeholder="请输入密码:"/>	
					</div>
					
				</div>
				
				<div class="row">
					<label for="sex" class="col-sm-4 control-label">
						性别:
					</label>
					<div class="col-sm-8">
						<select id="sex" class="form-control">
							<option value='0'>男</option>
							<option value='1'>女</option>
						</select>
					</div>	
				</div>
				
				<div class="row">
					<label for="age" class="col-sm-4 control-label">
						年龄:
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="age" placeholder="请输入年龄"/>	
					</div>		
				</div>
				
				<div class="row">
					<label for="phone" class="col-sm-4 control-label">
						电话:
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="mobilephone" placeholder="请输入电话"/>	
					</div>		
				</div>
				
				<div class="row">
					<label for="address" class="col-sm-4 control-label">
						住址:
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="address" placeholder="请输入住址"/>	
					</div>		
				</div>
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="add_user_Btn" data-dismiss="modal">
					添加
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					关闭
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
	<!-- 修改用户信息 -->
<div>
	<div class="modal fade" id="modifymodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
            </div>
           
			<div class="modal-body">
				<div class="row">
					<label for="username" class="col-sm-4 control-label">
						用户名：
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="user_name2" placeholder="请输入修改用户名："/>	
					</div>
					
				</div>
				<div class="row">
					<label for="password" class="col-sm-4 control-label">
						密码：
					</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="password2" placeholder="请输入修改密码:"/>	
					</div>
					
				</div>
				
				<div class="row">
					<label for="sex" class="col-sm-4 control-label">
						性别:
					</label>
					<div class="col-sm-8">
						<select id="sex2" class="form-control">
							<option value='0'>男</option>
							<option value='1'>女</option>
						</select>
					</div>	
				</div>
				
				<div class="row">
					<label for="age" class="col-sm-4 control-label">
						年龄:
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="age2" placeholder="请输入修改年龄"/>	
					</div>		
				</div>
				
				<div class="row">
					<label for="phone" class="col-sm-4 control-label">
						电话:
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="mobilephone2" placeholder="请输入修改电话"/>	
					</div>		
				</div>
				
				<div class="row">
					<label for="address" class="col-sm-4 control-label">
						住址:
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="address2" placeholder="请输入修改住址"/>	
					</div>		
				</div>
				
			</div>
            <div class="modal-footer">
            	<button type="button" class="btn btn-primary" id="modify_user_Btn" data-toggle="modal" data-target="#modifymodal2" data-dismiss="modal">提交更改</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->
</div>	

<!-- 确认提交修改-->
<div>
	<div class="modal fade" id="modifymodal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                
            </div>
           		
			<div class="modal-body">
				<div class="text" style=" text-align:center;">确认修改?</div>				
			</div>
            <div class="modal-footer">
            	<button type="button" class="btn btn-primary" id="modify_user_Btn2" data-dismiss="modal">确认</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button> 
                
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->
</div>	

<!-- 删除确认 -->
<div>
	<div class="modal fade" id="deletemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                
            </div>
           		
			<div class="modal-body">
				<div class="text" style=" text-align:center;">确认删除？</div>				
			</div>
            <div class="modal-footer">
            	<button type="button" class="btn btn-primary" id="delete_user_Btn2" data-dismiss="modal">确认</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->
</div>	

</body>
</html>
