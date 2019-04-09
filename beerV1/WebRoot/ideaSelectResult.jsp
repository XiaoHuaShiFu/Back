<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="mine" uri="randomThings" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<html>
  <head>
    <title>Idea Select Result page</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <style type="text/css"> 
  		.center {
  			text-align:center;
  		}
  </style>
  <body>
  	<%@ include file="Header.jsp" %>
    password: ${user.password }
    <br>
    id: ${user.id }
    <br>
    name: ${user.name }
    <br>
    dogName: ${user.dog.name }
    <br>
    member1: ${members[0] }
	<br>
	dogName: ${dogMap[ideaType] }
	<br>
	dogName: ${dogMap[dogTypes[0]] }
	<br>
	type: ${param.ideaType }
	<br>
	header: ${header.host }
	<br>
	method: ${pageContext.request.method }
	<br>
	username: ${cookie.username.value }
	<br>
	DiceRoller: ${mine:rollIt() } 
	<br>
	test:<c:out value='${user.name }'  default="ttttt" />
	<table>
		<c:forEach var="listElement" items="${movieList }" >
			<c:forEach var="movie" items="${listElement }" varStatus="movieLoopCount">
				<tr>
				<td>Count:${movieLoopCount.count }</td>
				</tr>
				<tr>
					<td>${movie}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
	
	<c:choose>
		<c:when test="${user.username == '21312das'}">
			???who are you?
		</c:when>
		<c:when test="${user.username == 'Xiaohuashufu'}">
			Hello xiaohuashifu
		</c:when>
		<c:otherwise>
			Welcome!!!
		</c:otherwise>
	</c:choose>
	
	<c:set var="users" scope="request">
			${user.username}, ${user.password}
	</c:set>
	
	<table>
		<c:forEach var="userInfo" items="${users }">
			<tr>
				<td>${userInfo}</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:remove var="users" scope="request" />
	<table>
		<c:forEach var="userInfo" items="${users }">
			<tr>
				<td>${userInfo}</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:url value="/subjectSelectResuult.jsp" var="inputURL" >
		<c:param name="username" value="${user.username }" />
		<c:param name="password" value="${user.password }" />
	</c:url>
	
	inputURL:${inputURL }
	
	<c:catch var="myException">
		<% int x = 10 / 0 ; %>
	</c:catch>
	
	<br>
	myException:${myException.message }
	
	<br>

	advice:<mine:advice user="${user.username }" />
	
	advice:<mine:advice>
		<jsp:attribute name="user">${user.username }</jsp:attribute>
	</mine:advice>
	
	<br>
	<mine:test1>This is the body of the TestTag:${message }</mine:test1>
	${message }
	
	<br>
	<mine:test2 movies="${movies }"><br><tr><td>${movie }</td></tr></mine:test2>
	
	<br>
	<%-- <mine:test3/> --%>
	
	<%-- <c:import url="http://www.baidu.com" /> --%>
	<c:import url="Footer.jsp">
		<c:param name="subFooter" value="2018.8.21 from xhsf" />
	</c:import>
	
	<myTags:Header password="#660099" userName="12312312">
		See you next time
	</myTags:Header>
	
  </body>
</html>

