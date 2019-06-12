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
<script src="js/dev/sup_dev.js"></script>  <!-- 功能逻辑 -->



</head>

<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			设备信息管理
		</div>
		<div id="toolbar">
			<button id="add" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addmodal">
			添加
			</button>
			<button id="remove" type="button" class="btn btn-primary" disabled='disabled' style="background:red " data-toggle="modal" data-target="#delete_confirm" >
			删除
			</button>
			<button id="modify" type="button" class="btn btn-primary"  disabled='disabled'>
			修改
			</button>
			<button id="push" type="button" class="btn btn-primary" data-toggle="modal" data-target="#advmodal" disabled='disabled' >
			广告推送
			</button>
			
			
		</div>
		<table id="usertab"
			data-toolbar="#toolbar"
  			data-search="true"
  			data-show-refresh="true"
			data-show-toggle="true">
		</table>
		
		
	</div>
	
	
	<!-- 广告 -->
<div>
	<div class="modal fade" id="advmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">编辑广告信息</h4>
            </div>
           
			<div class="modal-body">
				<div class="row">
					<label for="adv_info" class="col-sm-4 control-label">
						广告信息：
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="adv_info" placeholder="请输入广告内容："/>	
					</div>
					
				</div>								
								
			</div>
            <div class="modal-footer">
            	<button type="button" class="btn btn-primary" id="push_adv_Btn" data-dismiss="modal">推送广告</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->
</div>	


	<!-- 添加信息模块 -->
<div>
	<div class="modal fade" id="addmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">
					设备信息
				</h4>
			</div>
			<div class="modal-body">
			
				<div class="row">
					<label for="Devid" class="col-sm-4 control-label">
						设备id：
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="add_DevId" placeholder="请输入设备名："/>	
					</div>
					
				</div>
				
				<div class="row">
					<label for="Devname" class="col-sm-4 control-label">
						设备名：
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="add_DevName" placeholder="请输入设备名："/>	
					</div>
					
				</div>
				
				<div class="row">
					<label for="type" class="col-sm-4 control-label">
						设备类型：
					</label>
					<div class="col-sm-8">
						<select id="add_DevType" class="form-control">
							<option value='0'>安卓</option>
							<option value='1'>开发板</option>
						</select>
					</div>
					
				</div>
				
				
				
				<div class="row">
					<label for="status" class="col-sm-4 control-label">
						状态:
					</label>
					<div class="col-sm-8">
						<select id="add_DevState" class="form-control">
							<option value='0'>离线</option>
							<option value='1'>在线</option>
						</select>
					</div>	
				</div>
				
				
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="add_confirm_Btn" data-dismiss="modal">
					添加
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					关闭
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
	<!-- 修改信息 -->
<div>
	<div class="modal fade" id="modifymodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">修改设备信息</h4>
            </div>
           
			<div class="modal-body">
				<div class="row">
					<label for="modify_name" class="col-sm-4 control-label">
						设备名：
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="modify_name" placeholder="请输入修改用户名："/>	
					</div>
					
				</div>				
				<div class="row">
					<label for="type" class="col-sm-4 control-label">
						类型:
					</label>
					<div class="col-sm-8">
						<select id="modify_type" class="form-control">
							<option value='0'>安卓</option>
							<option value='1'>开发板</option>
						</select>
					</div>	
				</div>				
				
				<div class="row">
					<label for="state" class="col-sm-4 control-label">
						状态:
					</label>
					<div class="col-sm-8">
						<select id="modify_state" class="form-control">
							<option value='0'>离线</option>
							<option value='1'>在线</option>
						</select>
					</div>	
				</div>
								
			</div>
            <div class="modal-footer">
            	<button type="button" class="btn btn-primary" id="modify_dev_Btn" data-toggle="modal" data-target="#modify_confirm" data-dismiss="modal">提交更改</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->
</div>	

<!-- 确认提交修改-->
<div>
	<div class="modal fade" id="modify_confirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                
            </div>
           		
			<div class="modal-body">
				<div class="text" style=" text-align:center;">确认修改?</div>				
			</div>
            <div class="modal-footer">
            	<button type="button" class="btn btn-primary" id="modify_confirm_Btn" data-dismiss="modal">确认</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button> 
                
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->
</div>	

<!-- 删除确认 -->
<div>
	<div class="modal fade" id="delete_confirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                
            </div>
           		
			<div class="modal-body">
				<div class="text" style=" text-align:center;">确认删除？</div>				
			</div>
            <div class="modal-footer">
            	<button type="button" class="btn btn-primary" id="delete_confirm_Btn" data-dismiss="modal">确认</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->
</div>	

</body>
</html>
