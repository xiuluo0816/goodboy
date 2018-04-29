<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form action="rate/add" id="addForm" method="post">
	<div class="form-group">
		<label class="col-sm-2 control-label">机构名称</label>
		<div class="col-sm-8">
			<input name="organizationName" class="form-control" value="${user.organizationName}" readonly = "true">
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">机构号</label>
		<div class="col-sm-8">
			<input name="organizationCode" class="form-control" value="${user.organizationCode}" readonly = "true">
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">利率种类</label>
		<div class="col-sm-8">
			<select class="form-control" name="rateType">
				<option value="0">活期</option>
				<option value="1">定期</option>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">利率期限</label>
		<div class="col-sm-8">
			<select class="form-control" name="terminable">
				<option value="活期">活期</option>
				<option value="3-month">三个月</option>
				<option value="3-month">六个月</option>
				<option value="1-year">一年</option>
				<option value="2-year">两年</option>
				<option value="3-year">三年</option>
				<option value="5-year">五年</option>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">年利率</label>
		<div class="col-sm-8">
			<input name="annualInterestRate" class="form-control" placeholder="请输入数字, 只支持到小数点后4位">
		</div>
	</div>


</form>