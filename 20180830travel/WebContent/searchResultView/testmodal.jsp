<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<title>여행검색</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-latest.min.js"></script> <!--  jquery 라이브러리 -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBGXKB1k8LOAYWW0KCV9G0NNupVvav0XAs"></script> <!-- 구글지도 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/GoogleMapMark.js"></script> <!-- 구글지도생성하는 js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/SearchViewCheck.js"></script>
<!--  스타일 -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/searchView.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/searchView2.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> <!--  아이콘-->  
<!--  달력 --> 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" /><!--  jQuery UI CSS파일-->  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  <!--  jQuery 기본 js파일 -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script><!-- jQuery UI 라이브러리 js파일  -->
</head>
<body>
<!--  타이틀 -->
<div class="w3-display-container" style="margin-bottom:50px">
	<img src="<%=request.getContextPath()%>/w3images/beach3.jpg" style="width:100%">
	<div class="w3-display-bottomleft w3-container w3-amber w3-hover-orange w3-hide-small" style="bottom:10%;opacity:0.7;width:70%">
		<h2><b>${dto.title}<br>${dto.content}</b></h2>
	</div>
</div>
<!--  지도 -->
<!-- <script>createMap('${dto.fromName}','${dto.toName}',${dto.fromLatitude},${dto.toLatitude},${dto.fromLongitude},${dto.toLongitude}) </script> -->
<div class="w3-row w3-container" style="margin:50px 0">
<jsp:include page="/mapmark.jsp"></jsp:include>
<!-- 	<div class="w3-half w3-container">
		<div class="w3-topbar w3-border-amber">
			<div id="map" style="width:100%;height:400px;"></div>
		</div>
	</div> -->
<!--  이미지 슬라이더 -->
<div class="w3-half w3-container">
	<div class="w3-topbar w3-border-amber">
    	<div class="slideshow-container">
			<c:forEach var="l" items="${list}">
				<div class="mySlides fade">
					<div class="numbertext">${l.count}/ ${list.size()}</div>
						<img src="<%=request.getContextPath()%>/img/${l.fileName}" style="width: 100%;height:400px;">
				</div>
			</c:forEach>
			<a class="prev" onclick="plusSlides(-1)">&#10094;</a> 
			<a class="next"	onclick="plusSlides(1)">&#10095;</a>
		</div>
	<br>
		<div style="text-align: center">
			<c:forEach var="l" items="${list}">
				<span class="dot" onclick="currentSlide(${l.count})"></span>
			</c:forEach>
		</div>
	</div>
</div>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/SearchView.js"></script>
<!--  항공편 조회폼 -->
<form action="#" style="max-width:1000px;margin:auto">
   	<div class="input-container">   	
   		<i class="fa fa-user icon"></i>	
   		<div class="dropdown">
    		<input id="dia_bt" class="input-field area" type="text" placeholder="출발지" name="from">
    		<div class="dropdown-content area">
    			<table border=1 class="area">
    				<tr><td class="area">국내</td></tr>
    				<tr><td><a class ="contury" href="#;">서울</a></td><td><a class ="contury" href="#;">부산</a></td><td><a class ="contury" href="#;">제주</a></td></tr>
    				<tr><td class="area">중화권</td></tr>
    				<tr><td><a class ="contury" href="#;">홍콩</a></td><td><a class ="contury" href="#;">타이페이</a></td><td><a class ="contury" href="#;">마카오</a></td><td><a class ="contury" href="#;">상하이</a></td><td><a class ="contury" href="#;">베이징</a></td><td><a class ="contury" href="#;">칭다오</a></td></tr>
    				<tr><td class="area">아시아</td></tr>
    				<tr><td><a class ="contury" href="#;">도쿄</a></td><td><a class ="contury" href="#;">싱가포르</a></td><td><a class ="contury" href="#;">방콕</a></td><td><a class ="contury" href="#;">마닐라</a></td><td><a class ="contury" href="#;">쿠알라룸푸르</a></td><td><a class ="contury" href="#;">하노이</a></td></tr>
    				<tr><td class="area">미주/유럽</td></tr>      
	    			<tr><td><a class ="contury" href="#;">런던</a></td><td><a class ="contury" href="#;">파리</a></td><td><a class ="contury" href="#;">로마</a></td><td><a class ="contury" href="#;">로스앤젤레스</a></td><td><a class ="contury" href="#;">뉴욕</a></td><td><a class ="contury" href="#;">샌프란시스코</a></td></tr>
    			</table>
      		</div>
    	</div>
		<i class="fa fa-user icon"></i>
    	<div class="dropdown2">   
    		<input id="dia_bt2" class="input-field area2" type="text" placeholder="도착지" name="to">
    		<div class="dropdown2-content area2">
      			<table border=1 class="area2">
      				<tr><td class="area2">국내</td></tr>
      				<tr><td><a class ="tocontury" href="#;">서울</a></td><td><a class ="tocontury" href="#;">부산</a></td><td><a class ="tocontury" href="#;">제주</a></td></tr>
      				<tr><td class="area2">중화권</td></tr>
      				<tr><td><a class ="tocontury" href="#;">홍콩</a></td><td><a class ="tocontury" href="#;">타이페이</a></td><td><a class ="tocontury" href="#;">마카오</a></td><td><a class ="tocontury" href="#;">상하이</a></td><td><a class ="tocontury" href="#;">베이징</a></td><td><a class ="tocontury" href="#;">칭다오</a></td></tr>
     				<tr><td class="area2">아시아</td></tr>
      				<tr><td><a class ="tocontury" href="#;">도쿄</a></td><td><a class ="tocontury" href="#;">싱가포르</a></td><td><a class ="tocontury" href="#;">방콕</a></td><td><a class ="tocontury" href="#;">마닐라</a></td><td><a class ="tocontury" href="#;">쿠알라룸푸르</a></td><td><a class ="tocontury" href="#;">하노이</a></td></tr>
      				<tr><td class="area2">미주/유럽</td></tr>      
      				<tr><td><a class ="tocontury" href="#;">런던</a></td><td><a class ="tocontury" href="#;">파리</a></td><td><a class ="tocontury" href="#;">로마</a></td><td><a class ="tocontury" href="#;">로스앤젤레스</a></td><td><a class ="tocontury" href="#;">뉴욕</a></td><td><a class ="tocontury" href="#;">샌프란시스코</a></td></tr>
      			</table>
      		</div>
    	</div>   
  	</div>
  <div class="input-container">
  	<i class="fa fa-envelope icon"></i>
    <input class="input-field testDatepicker" type="text" placeholder="출발날짜" name="fromdate" >
    <i class="fa fa-envelope icon"></i>
    <input class="input-field testDatepicker" type="text" placeholder="도착날짜" name="todate" >
  </div>
  <div class="input-container">	
  	<h2>성인 </h2>
    <a href="javascript:;" class="bt_up fa fa-plus cal no-uline" > </a>
    <input class="num" type="text" placeholder="성인" value="0" readonly="readonly">
    <a href="javascript:;" class="bt_down fa fa-minus cal no-uline" > </a>
    <h2> 좌석 </h2>
    <select name="subjects">
    	<option value="일반">일반</option>
    	<option value="비즈니스">비즈니스</option>
    </select>
  </div>
  <button type="submit" class="btn" id="getBtn">조회</button>
</form>
</body>
</html>