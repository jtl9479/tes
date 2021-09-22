<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>회원가입 폼 템플릿</title>
        <link rel="stylesheet" href="./css/Sign_up.css">
        <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script type="text/javascript" src="/js/member/sign_up.js"></script>
        <script type="text/javascript">
        	
        	$(function(){
        		
        		$("#id_chk_btn").click(function(){
        			
        			alert($("#id").val());
        			$.ajax({
        				url:"/id_check",
        				type:"post",
						data:{
							"id_check":$("#id").val()
						},  
						success:function(data){
							if(data.check == 0){
								alert("중복되는 아이디가 있습니다")
								$("#id").val("").focus();
								
							}else{
								alert("사용할수 있습니다")
								$("#id").val(data.m_id)
								$("#pw").focus();
							}
						},
						error:function(){
							alert("실패")				
						}
        			})
        			
        		})
        		
        	})
        
        </script> 
        <style type="text/css">
        	
        	input {
				color: black;			
			}
        
        </style>
    </head>
    <body>
        <div class="wrap">
            <div class="form-wrap">
                <h1 id="title_h1">회원가입</h1>
                <div class="button-wrap">
                    <div id="btn"></div>
                    <ul>
                        <li class="togglebtn" id="btn1" onclick="customer()">고객
                        </li>
                        <li class="togglebtn" id="btn2" onclick="corporation()">기업</li>

                    </ul>
                   
                </div>
                <div id="register_input">
                    <form id="customer" action="register_member" class="input-group" method="post" >
                        <div>
                            <input type="text" id="id" name="m_id" placeholder="ID">
                            <button type="button" id="id_chk_btn">중복검사</button>
                            <hr>
                            <span id="id_check"></span>
                            <input type="password" id="pw" name="m_pw" placeholder="PASSWORD">
                            <hr>
                            <span id="pw_check"></span>
                            <input type="password" id="pw1" name="pw1" placeholder="PASSWORD 재입력">
                            <hr>
                            <span id="pw_check1"></span>
                            <input type="text" id="name" name="m_name" placeholder="이름">
                            <hr>
                            <input type="text" id="nick" name="m_nickname" placeholder="닉네임">
                            <hr>
                            <input type="text" id="email" name="m_email" placeholder="이메일">
                            <hr>
                            <span id="email_check"></span>
                            <input type="submit" id="submit_btn" value="SIGN IN">
                            <br>
                        </div>
                    </form>
                    <form id="corporation" action="register_fac" class="input-group" method="post">
                        <div>
                            <input type="text" id="id" name="fm_id" placeholder="ID">
                            <button type="button" id="id_chk_btn">중복검사</button>
                            <hr>
                            <input type="password" id="pw" name="fm_pw" placeholder="PASSWORD">
                            <hr>
                            <input type="password" id="pw1" name="pw1" placeholder="PASSWORD 재입력">
                            <hr>
                            <span style="visibility: hidden;">비밀번호가 일치하지 않습니다</span>
                            <input type="text" id="ins_name" name="fm_name" placeholder="시설관리자 명">
                            <hr>
                            <input type="text" id="ins_address" name="fm_add1" placeholder="시설관리자 주소">
                            <hr>
                            <input type="text" id="ins_phone" name="fm_phone" placeholder="시설관리자 전화번호">
                            <hr>
                            <span style="visibility: hidden;">전화번호양식이 잘못되었습니다</span>
                            <input type="submit" id="submit_btn" value="SIGN IN">
                            <br>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script>
            var x = document.getElementById("customer");
            var y = document.getElementById("corporation");
            var z = document.getElementById("btn");
            
            
            function customer(){
                x.style.left = "50px";
                y.style.left = "450px";
                z.style.left = "0";
            }
            function corporation(){
                x.style.left = "-400px";
                y.style.left = "50px";
                z.style.left = "115px";
            }
        </script>
    </body>
</html>