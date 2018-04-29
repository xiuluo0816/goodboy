<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>利率管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="libs/th2w.core.js" type="text/javascript"></script>
	<script src="libs/jquery/jquery.js" type="text/javascript"></script>
	<script type="text/javascript">
	 	Core.init ({
			url : 'resources',
			css	: ['bootstrap/css/bootstrap.min', 'dialog/css/ui-dialog', './css/layout'],
			js  : ['bootstrap/js/bootstrap.min', 'dialog/js/dialog-plus-min', 'jquery/form', './js/common', './js/buttons']
		});
	</script>
</head>
<script type="text/javascript">Core.js('./js/iface/topic');</script>
<body>
	<div class="header none-margin">
		<div class="header-right">
			<div class="logo"></div>
			<div class="usrDiv"></div>
			<div class="manager">
	                <%--<div>
	                    <ul class="nav nav-tabs" role="tablist">
		                    <li role="presentation" class=""><a href="/loving_cms/home/">小说列表</a></li>
	                    </ul>
					</div>--%>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row main_content">
			<%@ include file="../leftmenu.jsp" %>
		<!-- right content -->
		<div class="right-content">
			<form id="searchForm" action="" method="post">
			<input type="hidden" name="_method" value="get" />
			<div class="lujing">
               <span class="zhucaidan">利率管理</span>
               <span class="jiantou">&lt;&lt;</span>
               <span class="zicaidan">利率管理</span>
			</div>
		 	<div class="handleBtn">
				<button type="button" id="add" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span> 添加</button>
				<button type="button" id="edit" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span> 编辑</button>
				<button type="button" id="delete" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> 删除</button>
           </div>
           <!--table-->
           <!--固定表头,绝对定位-->
           <div class="fixedThead">
               <table class="table table-bordered myTable">
                   <thead>
                   <tr class="fixedTr">
                       <th class="w65"><input id="xuanxiang" name="markedAll" type="checkbox"/> <label for="xuanxiang">选项</label> </th>
					   <th>机构号</th>
					   <th>机构名称</th>
					   <th>利率种类</th>
					   <th>利率期限</th>
					   <th>年利率</th>
                   </tr>
                   </thead>
               </table>
           </div>
           <div class="tableDiv">
			<table class="table table-bordered table-striped table-hover myTable">
				<thead>
					<tr class="originalTr">
						<th class="w65"><input  type="checkbox"/> <label for="xuanxiang">选项</label> </th>
						<th>机构号</th>
						<th>机构名称</th>
						<th>利率种类</th>
						<th>利率期限</th>
						<th>年利率</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="rate" items="${rates}">
						<tr>
							<td><input name="marked" type="checkbox" value="${rate.id}" /></td>
							<td>${user.organizationCode}</td>
							<td>${user.organizationName}</td>
							<td>${rate.rateType eq 0 ? '活期' : '定期'}</td>
							<td>${rate.terminable}</td>
							<td>${rate.annualInterestRate}%</td>
						</tr>
					</c:forEach>
               </tbody>
           </table>
           </div>
           <!--end table-->
          </form>
       		</div> <!-- end right content -->
		</div>
	</div>	
 
	<!--弹出框-->
	<div class="modal fade" id="modal" role="dialog" aria-labelledby="gridSystemModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                <h4 class="modal-title"></h4>
	            </div>
	            <div class="modal-body form-horizontal">
					
	            </div>
	            <div class="modal-footer">
	                <span class="result">操作成功</span>
	                <button type="button" class="btn btn-default cancle" data-dismiss="modal">取消</button>
	                <button type="button" class="btn btn-primary sure">确定</button>
	            </div>
	        </div>
	    </div>
	</div>
	<div class="loading">正在加载中...</div>
</body>
</html>