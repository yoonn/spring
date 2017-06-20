<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
    
<%@ include file="../include/header.jsp" %>

	<form role="form" action="modifyPage" method="post">
		<input type="hidden" name="page" 	   value="${cri.page}">
		<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
		<input type="hidden" name="searchType" value="${cri.searchType}">
		<input type="hidden" name="keyword"    value="${cri.keyword}">
		
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">BNO</label>
				<input type="text" name="bno" class="form-control" value="${boardVo.bno }" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Title</label>
				<input type="text" name="title" class="form-control" value="${boardVo.title }">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Content</label>
				<textarea class="form-control" name="content" rows="3">${boardVo.content }</textarea>
			</div>
			<div class="form-group">
				<label for="exampleIinputEmail1">Writer</label>
				<input type="text" name="writer" class="form-control" value="${boardVo.writer }" readonly="readonly">
			</div>
		</div>
		<!-- /.box-body -->
	</form>
	
	<div class="box-footer">
		<button class="btn btn-primary">SAVE</button>
		<button class="btn btn-warning">CANCLE</button>
	</div>

<%@ include file="../include/footer.jsp" %>

<script>

$(document).ready(function(){
	
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$(".btn-warning").on("click", function(){
		self.location = "/sboard/list"
						+ "?page=${cri.page}"
						+ "&perPageNum=${cri.perPageNum}"
						+ "&searchType=${cri.searchType}"
						+ "&keyword=${cri.keyword}";
	});
	
	$(".btn-primary").on("click", function(){
		formObj.submit();
	});
	
});
</script>
