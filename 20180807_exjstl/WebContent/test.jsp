<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!--  포맷스트링 제어부분. 출력형태 알면됨. 외우는건 기본문법만. -->
<html>
<head>
  <title>JSTL fmt:formatNumber Tag</title>
</head>
<body>
<h3>Number Format:</h3>
<c:set var="balance" value="120000.2309" />
<p>Formatted Number (1): <fmt:formatNumber value="${balance}"  type="currency"/></p>
<p>Formatted Number (2): <fmt:formatNumber type="number"   maxIntegerDigits="3" value="${balance}" /></p>
<p>Formatted Number (3): <fmt:formatNumber type="number"   maxFractionDigits="3" value="${balance}" /></p>
<p>Formatted Number (4): <fmt:formatNumber type="number"  groupingUsed="false" value="${balance}" /></p>
<p>Formatted Number (5): <fmt:formatNumber type="percent"   maxIntegerDigits="3" value="${balance}" /></p>
<p>Formatted Number (6): <fmt:formatNumber type="percent"   minFractionDigits="10" value="${balance}" /></p>
<p>Formatted Number (7): <fmt:formatNumber type="percent"   maxIntegerDigits="3" value="${balance}" /></p>
<p>Formatted Number (8): <fmt:formatNumber type="number"   pattern="###.###E0" value="${balance}" /></p><!-- 지수로 표현 -->
<p>Currency in USA :
<fmt:setLocale value="en_US"/> <!--  us 달러로 표현 -->
<fmt:formatNumber value="${balance}" type="currency"/></p>
</body>
</html>