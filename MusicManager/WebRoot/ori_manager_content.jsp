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
<script src="js/manager/ori_manager.js"></script>



</head>

<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			用户信息管理
		</div>
		<table id="usertab"
			data-toolbar="#toolbar"
  			data-search="true"
  			data-show-refresh="true"
			data-show-toggle="true">
		</table>
		
		
	</div>
	

</body>
</html>
