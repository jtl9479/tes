<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>회원가입 폼 템플릿</title>
        <link rel="stylesheet" href="./css/Sign_up.css">
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
                    <form id="customer" action="" class="input-group">
                        <div>
                            <input type="text" id="id" name="id" placeholder="ID">
                            <button type="button" id="id_chk_btn">중복검사</button>
                            <hr>
                            <input type="password" id="pw" name="pw" placeholder="PASSWORD">
                            <hr>
                            <input type="password" id="pw1" name="pw1" placeholder="PASSWORD 재입력">
                            <hr>
                            <span style="visibility: hidden;">비밀번호가 일치하지 않습니다</span>
                            <input type="text" id="name" name="name" placeholder="이름">
                            <hr>
                            <input type="text" id="nick" name="nick" placeholder="닉네임">
                            <hr>
                            <input type="text" id="email" name="email" placeholder="이메일">
                            <hr>
                            <span style="visibility: hidden;">이메일양식이 잘못되었습니다</span>
                            <input type="submit" id="submit_btn" value="SIGN IN">
                            <br>
                        </div>
                    </form>
                    <form id="corporation" action="" class="input-group">
                        <div>
                            <input type="text" id="id" name="id" placeholder="ID">
                            <button type="button" id="id_chk_btn">중복검사</button>
                            <hr>
                            <input type="password" id="pw" name="pw" placeholder="PASSWORD">
                            <hr>
                            <input type="password" id="pw1" name="pw1" placeholder="PASSWORD 재입력">
                            <hr>
                            <span style="visibility: hidden;">비밀번호가 일치하지 않습니다</span>
                            <input type="text" id="ins_name" name="ins_name" placeholder="시설이름">
                            <hr>
                            <input type="text" id="ins_address" name="ins_address" placeholder="시설주소">
                            <hr>
                            <input type="text" id="ins_phone" name="ins_phone" placeholder="시설전화번호">
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