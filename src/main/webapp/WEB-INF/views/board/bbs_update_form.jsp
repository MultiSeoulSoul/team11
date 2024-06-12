<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//alert('회원가입 페이지입니다. 반갑습니다.!')
</script>
<style type="text/css">
body { /* 컨트롤 + / - 자동주석, 태그선택! */
	background: #037BFC;
}

button {
	background: #18DE02;
}

.t1 { /* .은 클래스 선택!, 여러개선택!  */
	background: yellow;
	width: 150px;
	text-align: center;
}

#b1 { /* #은 아이디 선택!, 특정한 것 한 개만 선택! */
	color: red;
}
#b2{
	color: blue;
	
}
</style>
</head>
<body>


	<!-- 이쪽에 메뉴바 포함 할꺼임 -->
	<jsp:include page="../common/menubar.jsp" />

	<div class="content">
		<br>
		<br>
		<div class="innerOuter">
			<h3>게시글 수정 페이지</h3>
			<hr>
			
			<a href="bbs"><button id="b1">첫페이지로</button></a>
			
			<!-- update board 미완 -->
			<form action="update" method="post">
				<table border="1">
					<tr>
						<td class="t1">번호 :</td>
						<td><input name="no"></td>
					</tr>
					<tr>
						<td class="t1">제목 :</td>
						<td><input name="title"></td>
					</tr>
					<tr>
						<td class="t1">내용 :</td>
						<td><input name="content"></td>
					</tr>
					<tr>
						<td colspan="2" class="t1">
						<button id="b2">게시판 수정 데이터 전송</button>
						</td>
					</tr>
				</table>

			</form>






		</div>
		<br>
		<br>
	</div>


	<!-- 푸터바 포함 -->
	<jsp:include page="../common/footer.jsp" />

</body>
</html>