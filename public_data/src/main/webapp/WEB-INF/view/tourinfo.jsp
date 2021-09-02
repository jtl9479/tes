<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>한국 관광 공사사진 정보</title>
		<style type="text/css">
			table,th,td{
			border: 1px solid black;
			border-collapse: collapse;
			}
			img{
				width: 150px;
				height: 150px;
				
			}
			span{
				border: 1px solid black;
				margin-right: 5px;
				cursor: pointer;
			}
		</style>
		
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$.ajax({
					url:"/dataApi",
					type:"post",
					data:{//넘길데이터
							
					},
					dataType:"json",//넘겨받을 데이터 타입 json으로 받는다. 넘어오는 string 타입을 json으로 받는다.
					success:function(data){//sb.string
						 var arr= data.response.body.items.item;
						var html = "";
						for(var i=0; i<arr.length; i++){
							html +="<tr>"
							html +="<td>"+arr[i].galContentId+"</td>"
							html +="<td>"+arr[i].galPhotographyLocation+"</td>"
							html +="<td>"+arr[i].galCreatedtime+"</td>"
							html +="<td>"+arr[i].galTitle+"</td>"
							html +="<td>"+"<img src='"+arr[i].galWebImageUrl+"'></td>"
							html +="</tr>"
						}
						$("#arr").html(html)
					},
					error:function(){
						alert("에러");
					}
				})
			})
			
			//넘버링
			function dataBtn(pageNo){
				$.ajax({
					url:"/dataApi",
					type:"post",
					data:{//넘길데이터
							"pageNo":pageNo
					},
					dataType:"json",//넘겨받을 데이터 타입 json으로 받는다. 넘어오는 string 타입을 json으로 받는다.
					success:function(data){//sb.string
						 var arr= data.response.body.items.item;
						var html = "";
						for(var i=0; i<arr.length; i++){
							html +="<tr>"
							html +="<td>"+arr[i].galContentId+"</td>"
							html +="<td>"+arr[i].galPhotographyLocation+"</td>"
							html +="<td>"+arr[i].galCreatedtime+"</td>"
							html +="<td>"+arr[i].galTitle+"</td>"
							html +="<td>"+"<img src='"+arr[i].galWebImageUrl+"'></td>"
							html +="</tr>"
						}
						$("#arr").html(html)
					},
					error:function(){
						alert("에러");
					}
				})
			}
			
			//검색
			function dataApiSearch(){
				$.ajax({
					url:"/dataApi",
					type:"post",
					data:{//넘길데이터
						"word":alert($("#word").val())
					},
					dataType:"json",//넘겨받을 데이터 타입 json으로 받는다. 넘어오는 string 타입을 json으로 받는다.
					success:function(data){//sb.string
						 var arr= data.response.body.items.item;
						var html = "";
						for(var i=0; i<arr.length; i++){
							html +="<tr>"
							html +="<td>"+arr[i].galContentId+"</td>"
							html +="<td>"+arr[i].galPhotographyLocation+"</td>"
							html +="<td>"+arr[i].galCreatedtime+"</td>"
							html +="<td>"+arr[i].galTitle+"</td>"
							html +="<td>"+"<img src='"+arr[i].galWebImageUrl+"'></td>"
							html +="</tr>"
						}
						$("#arr").html(html)
					},
					error:function(){
						alert("에러");
					}
				})
			}

			
		</script>
		
	</head>
		<body>
		
		<label>찾고자 하는 여행지를 입력하세요</label><br>
		<input type="text" id="word">
		<input type="button" value="검색" onclick="dataApiSearch()">
		<hr>
		
		
			<table>
				<tr>
					<th>번호</th>
					<th>위치</th>
					<th>촬영일자</th>
					<th>제목</th>
					<th>이미지</th>
				</tr>
				<tbody id="arr">
				<tr>
					<td>1</td>
					<td>경기도 포천시</td>
					<td>202107</td>
					<td>포천 하늘아래</td>
					<td><img alt="" src="http://tong.visitkorea.or.kr/cms2/website/00/2553300.jpg"/></td>
				</tr>
				</tbody>
			</table>
				 <c:forEach var="pageNo" begin="1" end="10">
					<span onclick="dataBtn(${pageNo })">${pageNo }</span>
			     </c:forEach>
		</body>
</html>