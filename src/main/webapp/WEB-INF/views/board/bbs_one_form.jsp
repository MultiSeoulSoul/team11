<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background: yellow;
}
</style>
</head>
<body>

	<!-- 메뉴바 포함 -->
   <jsp:include page="../common/menubar.jsp"/>
    
    <div class="content">
        <br>
        <br>
        <div class="innerOuter">
			<h3>게시글 검색 페이지</h3>
			<hr>
			
			<a href="bbs_list"><button id="b1">게시물 전체 목록 페이지</button></a>
			<a href="bbs"><button id="b1">첫페이지로</button></a>
			<br>
		
			<form action="bbs_one" method="get">
				<table border="1" class="table table-dark table-hover">
					<tr>
						<td class="t1">검색할 게시글 번호 :</td>
						<td><input name="no" value="1"></td>
					</tr>
					<tr>
						<td colspan="2" class="t1">
							<button id="b2" class="btn btn-danger">검색할 no 데이터 전송</button>
						</td>
					</tr>
				</table>
			</form>

		</div>
		<br>
		<br>
	</div>
    
    
    <!-- 푸터바 포함 -->
    <jsp:include page="../common/footer.jsp"/>
</body>
</html>