<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE html>
<html>
<head>
	<title>小说管理系统</title>
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
	              <%--  <div>
	                    <ul class="nav nav-tabs" role="tablist">
		                    <li role="presentation" class=""><a href="/loving_cms/home/">小说列表</a></li>
	                    </ul>
					</div>--%>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row main_content">
			<%@include  file="../leftmenu.jsp" %>
		<!-- right content -->
		<div class="right-content">
			<form id="searchForm" action="" method="post">
			<input type="hidden" name="_method" value="get" />
			<div class="lujing">
               <span class="zhucaidan">小说管理</span>
               <span class="jiantou">&lt;&lt;</span>
               <span class="zicaidan">小说列表</span>
               <!-- <div class="input-group search">
                   <img id="search" src="resources/img/ico23.png" alt="" />
                   <input type="text" name="key" class="form-control" value="" placeholder="请输入关键字...">
               </div> -->
         		<%-- <div class="form-inline" style="float: right;">
		                	<select class="form-control" id="material">
		                		<option value="">全部资源</option>
		                		<c:forEach var="material" items="${materials}">
		                			<option value="${material.id}" ${categories[0].materialId eq material.id?'selected':''}>${material.name}</option>
		                			<c:if test="${categories[0].materialId eq material.id}">
		                				<c:set var="material" value="${material}" scope="request"></c:set>
		                			</c:if>
		                		</c:forEach>
		                	</select>
		                	<select class="form-control" name="categoryId">
		                		<c:if test="${not empty param.categoryId}">
			                		<c:forEach var="category" items="${categories}">
			                			<option value="${category.id}" ${category.id eq param.categoryId?'selected':''}>${category.name}</option>
			                		</c:forEach>
		                		</c:if>
		                	</select>
		                	<input class="form-control" name="name" value="${param.name}" placeholder="输入资源名称按Enter查询">
		                	<button class="btn btn-default">查询</button>
				</div> --%>
			</div>
		 	<div class="handleBtn">
		 		<input type="hidden" name="regionCode" value="" />
              	<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                   	选择地区 <span class="caret"></span>
               	</button>
                <ul class="regionMenu dropdown-menu" role="menu">
                
                	<li><a href="#" data-code="1001">北京</a></li>
                
                	<li><a href="#" data-code="1002">上海</a></li>
                
                </ul>
                <shiro:hasRole name="admin">  
				  <button type="button" id="add" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span>测试添加admin角色</button>
				</shiro:hasRole> 
				<shiro:hasRole name="teacher">  
				  <button type="button" id="add" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span>测试添加teacher角色</button>
				</shiro:hasRole> 
				<shiro:hasRole name="student">  
				  <button type="button" id="add" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span>测试添加student角色</button>
				</shiro:hasRole>  
				<button type="button" id="add" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span> 添加</button>
				<button type="button" id="edit" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span> 编辑</button>
				<button type="button" id="delete" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span> 删除</button>
           </div>
           <!--table-->
           <!--固定表头,绝对定位-->
           <div class="fixedThead">
               <table class="table table-bordered myTable">
                   <thead>
                   <tr class="fixedTr">
                       <th class="w65"><input id="xuanxiang" name="markedAll" type="checkbox"/> <label for="xuanxiang">选项</label> </th>
                       <th>ID</th>
	                   <th>小说名称</th>
	                   <th>所属分类</th>
	               	   <th>小说作者</th>
	               	   <th>最后更新时间</th>
	               	   <th>小说状态</th>
	               	   <th>操作</th>
                   </tr>
                   </thead>
               </table>
           </div>
           <div class="tableDiv">
			<table class="table table-bordered table-striped table-hover myTable">
				<thead>
					<tr class="originalTr">
						<th class="w65"><input  type="checkbox"/> <label for="xuanxiang">选项</label> </th>
						<th>ID</th>
						<th>小说名称</th>
						<th>所属分类</th>
						<th>小说作者</th>
						<th>最后更新时间</th>
						<th>小说状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
	                   <td><input name="marked" type="checkbox" value="2c9080454f6d5d89014f6d5d89c50000" /></td>
	                   <td>123</td>
	                   <td>人皇</td>
	                   <td>玄幻小说</td>
	                   <td>张三</td>
	                   <td>2015.03.06</td>
	                   <td>连载中</td>
	                   <td>
	                   	<div>
			            	<button type="button" class="btn btn-default imgAdBtn" data-topic="2c9080454f6d5d89014f6d5d89c50000">图片广告管理</button>
			            	<button type="button" class="btn btn-default imgAdBtn" data-topic="2c9080454f6d5d89014f6d5d89c50000">分章查看</button>
			            	<button type="button" class="btn btn-default imgAdBtn" data-topic="2c9080454f6d5d89014f6d5d89c50000">删除</button>
			            </div>
	                   </td> 
	               	</tr>
					<tr>
	                   <td><input name="marked" type="checkbox" value="2c9080454f6d5d89014f6d5d89c50000" /></td>
	                   <td>456</td>
	                   <td>诛仙</td>
	                   <td>玄幻小说</td>
	                   <td>李四</td>
	                   <td>2015.03.06</td>
	                   <td>连载中</td>
	                   <td>
	                   	<div>
			            	<button type="button" class="btn btn-default imgAdBtn">图片广告管理</button>
			            	<button type="button" class="btn btn-default imgAdBtn">分章查看</button>
			            	<button type="button" class="btn btn-default imgAdBtn">删除</button>
			            </div>
	                   </td> 
	               	</tr>
               </tbody>
           </table>
           </div>
           <!--end table-->
           

	<script type="text/javascript">Core.js('./js/pager');</script>

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
	            <div class="modal-body"></div>
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