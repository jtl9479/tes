<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 회원 로그인 -->
	<c:if test="${session_flag == 'session_member' }">
		<script type="text/javascript">
  		alert("${session_nick}" +"님 환영합니다")
  		location.href="member_Main"
  	</script>
	</c:if>

<!-- 시설 판매자 로그인 -->
	<c:if test="${session_flag == 'session_fmanager' }">
		<script type="text/javascript">
		alert("${session_name}" +"님 환영합니다")
  		location.href="fac_Main"
  	</script>
	</c:if>

<!-- 관리자 로그인 -->
	<c:if test="${session_flag == 'admin' }">
		<script type="text/javascript">
  		alert("관리자님 환영합니다")
  		location.href="admin_main"
  	</script>
	</c:if>
	
<!-- 실패 -->
	<c:if test="${session_flag == 'fail' }">
		<script type="text/javascript">
  		alert("로그인 실패했습니다")
  		location.href="login"
  	</script>
	</c:if>



</body>
</html>