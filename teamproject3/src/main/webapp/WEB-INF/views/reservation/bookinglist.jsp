	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!DOCTYPE html>
	<html lang="ko" class="no-js">
	<head>
		<!-- Mobile Specific Meta -->
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Favicon-->
		<link rel="shortcut icon" href="img/fav.png">
		<!-- Author Meta -->
		<meta name="author" content="colorlib">
		<!-- Meta Description -->
		<meta name="description" content="">
		<!-- Meta Keyword -->
		<meta name="keywords" content="">
		<!-- meta character set -->
		<meta charset="UTF-8">
		<!-- Site Title -->
		<title>Noriter</title>

		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
			<!--
			CSS
			============================================= -->
			<link rel="stylesheet" href="css/linearicons.css">
			<link rel="stylesheet" href="css/font-awesome.min.css">
			<link rel="stylesheet" href="css/bootstrap.css">
			<link rel="stylesheet" href="css/magnific-popup.css">
			<link rel="stylesheet" href="css/jquery-ui.css">				
			<link rel="stylesheet" href="css/nice-select.css">							
			<link rel="stylesheet" href="css/animate.min.css">
			<link rel="stylesheet" href="css/owl.carousel.css">				
			<link rel="stylesheet" href="css/main.css">
			<style type="text/css">
				
			</style>
		</head>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		$(function(){
					$("#searchArea-1").change(function(){
						if(${map.sportCategory == ""}){
							location.href = "bookinglist?searchCategory="+$(this).val();
						}else{
							location.href = "bookinglist?sportCategory=${map.sportCategory}&searchCategory="+$(this).val();
						}
					});
			
		});
		function searchAll(){
			location.href = "bookinglist?searchCategory=${map.searchCategory}&sportCategory=${map.sportCategory}&searchWord="+$("#searchWord").val();
		}
		$(function(){
			
			var date = new Date();
			var month = date.getMonth() +1;
			
			var day= (new Date()).getDate();

			var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDate();
			var useDay = "";
			if(month >10){
				useDay = month +"-" + day +"~" + month +"-" + lastDay;
			}else{
				useDay = "0"+month+"-"+day+"~"+"0"+month+"-"+lastDay;
			}
			$(".use_day").text(useDay);
		});
		
		</script>
		<body>	
			<!-- ?????? ??? ?????? ?????? ?????? -->
			<jsp:include page="../include/mainHeader.jsp"></jsp:include>
			<!-- ?????? ??? ?????? ?????? ??? -->
			  
			<!-- ?????? ?????? ?????? ?????? -->
			<section class="about-banner relative">
				<div class="overlay overlay-bg"></div>
				<div class="container">				
					<div class="row d-flex align-items-center justify-content-center">
						<div class="about-content col-lg-12">
							<h1 class="text-white">
								????????? ?????? ????????????!				
							</h1>	
							<p class="text-white link-nav">Complete Your Reservation!</p>
						</div>	
					</div>
				</div>
			</section>
			<!-- ?????? ?????? ?????? ??? -->

			<!-- ?????? ??????????????? ?????? -->
			<section class="destinations-area section-gap">
				<div class="container">
		            <div class="row d-flex justify-content-center">
		                <div class="menu-content pb-40 col-lg-8">
		                    <div class="title text-center">
								<div>
									<form class="form-wrap">
										<a href="bookinglist" class="primary-btn text-uppercase">??????</a>
										<a href="bookinglist?sportCategory=??????&searchCategory=${map.searchCategory }" class="primary-btn text-uppercase">??????</a>									
										<a href="bookinglist?sportCategory=??????&searchCategory=${map.searchCategory }" class="primary-btn text-uppercase">??????</a>	
										<a href="bookinglist?sportCategory=?????????&searchCategory=${map.searchCategory }" class="primary-btn text-uppercase">?????????</a>	
										<a href="bookinglist?sportCategory=????????????&searchCategory=${map.searchCategory }" class="primary-btn text-uppercase">????????????</a>	
									</form>
									<div class="area-1">
										<select id = "searchArea-1">
											<option value="" <c:if test="${map.searchCategory == '' }">selected</c:if>>??????</option>
											<option value="??????" <c:if test="${map.searchCategory == '??????' }">selected</c:if>>??????</option>
											<option value="??????" <c:if test="${map.searchCategory == '??????' }">selected</c:if>>??????</option>
											<option value="??????" <c:if test="${map.searchCategory == '??????' }">selected</c:if>>??????</option>
										</select>
										<input type="text" class="input-area" id="searchWord" name="searchWord">
											<button type="button" onclick="searchAll()" id="" name="" class="primary-btn text-uppercase">??????</button>
										<br>
									</div>
								</div>
		                    </div>
		                </div>
		            </div>						
					<div class="row">
					<c:forEach  items="${map.list }" var = "finfo">
						<div class="col-lg-4">
							<div class="single-destinations">
							
								<div class="thumb">
									<img class = "thumb_img"src="/finfo/${finfo.finfo_pic1 }" alt="">
								</div>
								<div class="details">
									<h4 class="d-flex justify-content-between">
										<span>${finfo.finfo_name }</span>                              	
									</h4>
									<p>
									</p>
									<ul class="package-list">
										<li class="d-flex justify-content-between align-items-center">
											<span>?????????</span>
											<span>${finfo.finfo_add1 }</span>
										</li>
										<li class="d-flex justify-content-between align-items-center">
											<span>????????????</span>
											<span>????????????</span>
										</li>
										<li class="d-flex justify-content-between align-items-center">
											<span>????????????</span>
											<span class = "use_day"></span>
										</li>
										<li class="d-flex justify-content-between align-items-center">
											<span>????????????</span>
											<span class = "use_day"></span>
										</li>
										<li class="d-flex justify-content-between align-items-center">
											<span>????????????</span>
											<a href="booking?finfo_no=${finfo.finfo_no }" class="price-btn">????????????</a>
										</li>													
									</ul>
								</div>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>

				<!-- ?????? ????????? ?????? -->	
				<nav class="blog-pagination justify-content-center d-flex">
					<ul class="pagination">
						<li class="page-item">
							<a href="#" class="page-link" aria-label="Previous">
								<span aria-hidden="true">
									<span class="lnr lnr-chevron-left"></span>
								</span>
							</a>
						</li>
						<c:forEach begin="${map.startPage }" end="${map.endPage }" var = "pageNum">
							<c:if test="${map.page != pageNum}">
								<li class="page-item"><a href="bookinglist?page=${pageNum }&sportCategory=${map.sportCategory}&searchCategory=${map.searchCategory}&searchWord=${map.searchWord}" class="page-link">${pageNum }</a></li>
							</c:if>
							<c:if test="${map.page == pageNum }">
								<li class="page-item active"><a href="bookinglist?page=${pageNum }&sportCategory=${map.sportCategory}&searchCategory=${map.searchCategory}&searchWord=${map.searchWord}" class="page-link">${pageNum }</a></li>
							</c:if>
						</c:forEach>
						<li class="page-item">
							<a href="#" class="page-link" aria-label="Next">
								<span aria-hidden="true">
									<span class="lnr lnr-chevron-right"></span>
								</span>
							</a>
						</li>
					</ul>
				</nav>
				<!-- ?????? ????????? ??? -->

			</section>
			<!-- ?????? ??????????????? ??? -->
			
			<!-- ?????? ?????? -->		
			<footer class="footer-area section-gap">
				<div class="container">
					<div class="row footer-bottom d-flex justify-content-between align-items-center">
						<p class="col-lg-8 col-sm-12 footer-text m-0">
							Copyright &copy;<script>document.write(new Date().getFullYear());</script> ????????? | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by 
							<a href="https://colorlib.com" target="_blank">Colorlib</a></p>
					</div>
				</div>
			</footer>
			<!-- ?????? ??? -->

			<script src="js/vendor/jquery-2.2.4.min.js"></script>
			<script src="js/popper.min.js"></script>
			<script src="js/vendor/bootstrap.min.js"></script>			
			<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>		
 			<script src="js/jquery-ui.js"></script>					
  			<script src="js/easing.min.js"></script>			
			<script src="js/hoverIntent.js"></script>
			<script src="js/superfish.min.js"></script>	
			<script src="js/jquery.ajaxchimp.min.js"></script>
			<script src="js/jquery.magnific-popup.min.js"></script>						
			<script src="js/jquery.nice-select.min.js"></script>					
			<script src="js/owl.carousel.min.js"></script>							
			<script src="js/mail-script.js"></script>	
			<script src="js/main.js"></script>	
		</body>
	</html>