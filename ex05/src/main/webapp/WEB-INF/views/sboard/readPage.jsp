<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>

<%@ include file="../include/header.jsp" %>

	<div class="row">
		<div class="col-md-12">
			<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>
				
				<form role="form" method="post">
					<input type="hidden" name="bno" value="${boardVo.bno }">
					<input type="hidden" name="page" value="${cri.page }">
					<input type="hidden" name="perPageNum" value="${cri.perPageNum }">
					<input type="hidden" name="searchType" value="${cri.searchType }">
					<input type="hidden" name="keyword" value="${cri.keyword }">
				</form>
				
				
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">Title</label>
							<input type="text" name="title" class="form-control" value="${boardVo.title }" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Content</label>
							<textarea class="form-control" name="content" rows="3" readonly="readonly">${boardVo.content }</textarea>
						</div>
						<div class="form-group">
							<label for="exampleIinputEmail1">Writer</label>
							<input type="text" name="writer" class="form-control" value="${boardVo.writer }" readonly="readonly">
						</div>
					</div>
					<!-- /.box-body -->
					
					<div class="box-footer">
					
						<ul class="mailbox-attachments clearfix uploadedList">
						</ul>
						
						<c:if test="${login.uid == boardVo.writer }">
							<button type="submit" class="btn btn-warning">Modify</button>
							<button type="submit" class="btn btn-danger">REMOVE</button>
						</c:if>
						<button type="submit" class="btn btn-primary" id="listAll">LIST ALL</button>
						
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
			
				<div class="box box-success">
					<div class="box-header">
						<h3 class="box-title">ADD NEW REPLY</h3>
					</div>
					<c:if test="${not empty login }">
						<div class="box-body">
							<label for="newReplyWriter">Writer</label>
							<input class="form-control" type="text" placeholder="USER ID" id="newReplyWriter">
							<label for="newReplyText">ReplyText</label>
							<input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText">
						</div>
						<!-- /.box-body -->
						<div class="box-footer">
							<button type="submit" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
						</div>
					</c:if>
					
					<c:if test="">
						<div class="box-body">
							<div>
								<a href="javascript:goLogin();">Login Please</a>
							</div>
						</div>
					</c:if>
				</div>
			</div>
			
			<ul class="timeline">
				<li class="time-label" id="repliesDiv">
					<span class="bg-green">Replies List <small id="replycntSmall"> [${boardVo.replycnt }]</small></span>
				</li>
			</ul>
			<div class="text-center">
				<ul id="pagination" class="pagination pagination-sm no-margin">
				
				</ul>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div id="modifyModal" class="modal modal-primary fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content -->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-body" data-rno>
					<p><input type="text" id="replytext" class="form-control"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
					<button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	
	

<%@ include file="../include/footer.jsp" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<script id="template" type="text/x-handlebars-template">
	{{#each .}}
	<li class="replyLi" data-rno={{rno}}>
		<i class="fa fa-comments bg-blue"></i>
		<div class="timeline-item">
			<span class="time">
				<i class="fa fa-clock-o"></i>{{prettifyDate regdt}}
			</span>
			<h3 class="timeline-header"><strong>{{rno}}</strong> -{{replyer}}</h3>
			<div class="timeline-body">{{replytext}}</div>
			<div class="timeline-footer">
				<a class="btn btn-primary btn-xs" data-toggle="modal" data-target="#modifyModal">Modify</a>
			</div>
		</div>
	</li>
	{{/each}}

</script>

<script id="templateAttach" type="text/x-handlebars-template">

	<li data-src='{{fullName}}'>
		<span class="mailbox-attachment-icon has-img">
			<img src="{{imgsrc}}" alt="Attachment">
		</span>
		<div class="mailbox-attachment-info">
			<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
		</div>
	</li>
	
</script>

<script>

	/* 게시글 버튼 처리 */
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		
		console.log(formObj);
		
		/* 수정 버튼 */
		$(".box-footer .btn-warning").on("click", function(){
			formObj.attr("action", "/sboard/modifyPage");
			formObj.attr("method", "get");
			formObj.submit();
		});
		
		/* 삭제버튼 */
		$(".box-footer .btn-danger").on("click", function(){
			formObj.attr("method", "post");
			formObj.attr("action", "/sboard/removePage");
			formObj.submit();
		});
		
		/* 리스트 버튼 */
		$("#listAll").on("click", function(){
			formObj.attr("method", "get");
			formObj.attr("action", "/sboard/list");
			formObj.submit();
		});
		
	});
	
	/* Handlebars 적용 start */
	Handlebars.registerHelper("prettifyDate", function(timeValue){
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	});
	/* Handlebars 적용 end */
	
	/* Handlbars를 이용한 댓글 출력 함수 선언 start */
	var printData = function(replyArr, target, templateObject){
		
		var template = Handlebars.compile(templateObject.html());
		
		var html = template(replyArr);
		$(".replyLi").remove();
		target.after(html);
	}
	/* Handlbars를 이용한 댓글 출력 함수 선언  end */
	
	var bno = ${boardVo.bno};
	var replyPage = 1;
	
	/* 페이지 처리 start*/
	function getPage(pageInfo){
		$.getJSON(pageInfo, function(data){
			printData( data.list
					 , $("#repliesDiv")
					 , $('#template')
					 );
			printPaging( data.pageMaker
					   , $(".pagination")
					   );
			
			$("#modifyModal").modal('hide');
			$("#replycntSmall").html("[" + data.pageMaker.totalCount + "]");
		});
	}
	/* 페이지 처리 end*/
	
	/* 페이징 출력 함수 start*/
	var printPaging = function(pageMaker, target){
		
		var str = "";
		
		if(pageMaker.prev){
			str += "<li><a href='"
				 + (pageMaker.startPage-1)
				 + "'> << </a></li>";
		}
		
		for(var i=pageMaker.startPage, len = pageMaker.endPage; i<=len; i++){
			var strClass = pageMaker.cri.page == i?'class=active':'';
			str += "<li "
				 + strClass
				 + "><a href='"
				 + i
				 + "'>"
				 + i
				 + "</a></li>";
		}
		
		if(pageMaker.next){
			str += "<li><a href='"
				 + (pageMaker.endPage + 1)
				 + "'> >> </a></li>";
		}
		
		target.html(str);
	}
	/* 페이징 출력 함수 end*/
	
	/* 댓글 가져오기  start*/
	$("#repliesDiv").on("click", function(){
		
		if($(".timeline li").size() > 1){
			return;
		}
		getPage("/replies/" + bno + "/1");
	});
	/* 댓글 가져오기  end*/
	
	/* 페이지 링크 처리 start*/
	$(".pagination").on("click", "li a", function(event){
		
		event.preventDefault();
		
		replyPage = $(this).attr("href");
		
		getPage("/replies/" + bno + "/" + replyPage);
	});
	/* 페이지 링크 처리 end*/
	
	/* 댓글 추가 이벤트 등록  start*/
	$("#replyAddBtn").on("click", function(){
	
		var replyerObj = $("#newReplyWriter");
		var replytextObj = $("#newReplyText");
		var replyer = replyerObj.val();
		var replytext = replytextObj.val();
		
		$.ajax({
			  type : 'post'
			, url : '/replies/'
			, headers : {
				  "Content-Type" : "application/json"
				, "X-HTTP-Method-Override" : "POST"
			}
			, dataType : 'text'
			, data : JSON.stringify({
				  bno : bno
				, replyer : replyer
				, replytext : replytext
			})
			, success : function(result){
				if(result == 'SUCCESS'){
					alert("등록 되었습니다.");
					replyPage = 1;
					getPage("/replies/" + bno + "/" + replyPage);
					replyerObj.val("");
					replytextObj.val("");
				}
			}
			
		});
	});
	/* 댓글 추가 이벤트 등록  end*/
	
	$(".timeline").on("click", ".replyLi", function(event){
		
		var reply = $(this);
		
		$("#replytext").val(reply.find('.timeline-body').text());
		$(".modal-title").html(reply.attr("data-rno"));
		
	});
	
	$("#replyModBtn").on("click", function(){
		
		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();
		
		$.ajax({
			  type : 'put'
			, url : '/replies/' + rno
			, headers : {
				  "Content-Type" : "application/json"
				, "X-HTTP-Method-Override" : "PUT"
			}
			, data : JSON.stringify({
				replytext : replytext
			})
			, dataType : 'text'
			, success : function(result){
				console.log("result : " + result);
				if(result == 'SUCCESS'){
					alert("수정되었습니다.");
					getPage("/replies/" + bno + "/" + replyPage);
				}
			}
		});
		
	});
	
	$("#replyDelBtn").on("click", function(){
		
		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();
		
		$.ajax({
			  type : 'delete'
			, url : '/replies/' + rno
			, headers : {
				"Content-Type" : "application/json"
				, "X-HTTP-Method-Override" : "DELETE"
			}
			, dataType : 'text'
			, success : function(result){
				console.log("result : " + result);
				if(result == 'SUCCESS'){
					alert("삭제 되었습니다.");
					getPage("/replies/" + bno + "/" + replyPage);
					$(".modal-footer .btn-default").click();
				}
			}
		});
	});
	
	var attachTemplate = Handlebars.compile($("#templateAttach").html());
	
	$.getJSON("/sboard/getAttach/" + bno, function(list){
		$(list).each(function(){
			
			var fileInfo = getFileInfo(this);
			
			var html = attachTemplate(fileInfo);
			
			$(".uploadedList").append(html);
		});
	});
	
</script>
