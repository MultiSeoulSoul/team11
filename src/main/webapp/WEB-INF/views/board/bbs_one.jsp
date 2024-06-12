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

			게시물 검색 처리 요청이 완료되었습니다.<br>
			<!-- 출력용(expression language-EL)  -->
			${bag.no} <br>
			${bag.title} <br>
			${bag.content} <br>
			${bag.writer} <br>



		</div>
		<br>
		<br>
	</div>


	<!-- 푸터바 포함 -->
	<jsp:include page="../common/footer.jsp" />
</body>
</html>




