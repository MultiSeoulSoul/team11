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
	<jsp:include page="../common/menubar.jsp" />

	<div class="content">
		<br>
		<br>
		<div class="innerOuter">

			회원 검색 처리 요청이 완료되었습니다.<br>
			<!-- 출력용(expression language-EL)  -->
			${dto.id} <br>
			${dto.pw} <br> 
			${dto.name} <br> 
			${dto.tel} <br>



		</div>
		<br>
		<br>
	</div>


	<!-- 푸터바 포함 -->
	<jsp:include page="../common/footer.jsp" />
</body>
</html>




