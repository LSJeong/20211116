<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<div align="center">
		<div>
			<ul>
				<li><a class="active" href="home.do"> 홈 </a></li>
				<c:if test="${empty id }">
					<li><a href="loginForm.do"> 로그인 </a></li>
				</c:if>
				<c:if test="${not empty id }">
					<li><a href="logout.do"> 로그아웃 </a></li>
				</c:if>
				<c:if test="${author eq 'ADMIN' }">
					<li><a href="memberList.do"> 멤버목록 </a></li>
				</c:if>
				<li><a href="#"> 공지사항 </a></li>
				<li><a href="#"> 회사소개 </a></li>
				<c:if test="${not empty id }">
					<li><a href="#"> 제품소개 </a></li>
				</c:if>		
				<c:if test="${empty id }">
					<li><a href="#"> 회원가입 </a></li>
				</c:if>
			</ul>		
		</div>
	</div>
</body>
</html>