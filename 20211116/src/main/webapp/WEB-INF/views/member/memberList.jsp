<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<style>
	th{
		background-Color: skyblue;
	}
</style>
</head>
<body>
<jsp:include page="../home/header.jsp" />
	<div align="center">
		<div><h1>멤 버 목 록</h1></div>
		<div>
			<table border="1">
				<tr>
					<th width="200">아이디</th>
					<th width="150">이  름</th>
					<th width="200">전화번호</th>
					<th width="400">주   소</th>
					<th width="200">권   한</th>
				</tr>
				<c:forEach items="${members }" var="member">
					<tr>
						<td align="center">${member.id }</td>
						<td align="center">${member.name }</td>
						<td align="center">${member.tel }</td>
						<td>&nbsp;${member.address }</td>
						<td align="center">${member.author }</td>
					</tr>
				</c:forEach>
			</table>
		</div><br>
	<button type="button" onclick="location.href='home.do'">홈으로</button>
	</div>
</body>
</html>