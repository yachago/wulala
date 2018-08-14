<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery_dev.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">
li{
  list-style-type:lower-alpha;
}
#a1{
	width:100px;
	height:100px;
	background:red;
	position:relative;
	animation:myfirst 30s;
	-webkit-animation:myfirst 30s; /* Safari and Chrome */
}

#td td{
    text-align:center;
    vertical-align:middle;
}
#td th{
    text-align:center;
    vertical-align:middle;
}
#show{
    width:800px;
    height:500px;
    margin-left:500px;
}
#choose{
    width:100%;
    height:auto;
}
#kk{
   
  
}
@keyframes myfirst
{
	0%   {background:red; left:0px; top:0px;}
	25%  {background:yellow; left:1400px; top:0px;}
	50%  {background:black; left:500px; top:500px;}
	75%  {background:green; left:0px; top:400px;}
	100% {background:red; left:0px; top:0px;}
}

@-webkit-keyframes myfirst /* Safari and Chrome */
{
	0%   {background:red; left:0px; top:0px;}
	25%  {background:pink; left:200px; top:0px;}
	50%  {background:blue; left:200px; top:200px;}
	75%  {background:green; left:300px; top:800px;}
	100% {background:red; left:200px; top:0px;}
}
</style>
<script src="js/jquery_dev.js"></script>
</head>
<body>
<h1 style="color:black;">你好啊</h1>
<div id="a1"><p1>小可爱</p1></div>
<div id="show">
  <c:choose>
  <c:when test="${empty  chooseEmp}">
  <div id="kk"> 
  <table class="table table-hover" id="td" style="width:800px;">
<tr>
<th>员工编号</th>
<th>员工姓名</th>
<th>员工年龄</th>
<th>员工雇佣日期</th>
<th></th>
</tr>
<c:forEach items="${allEmp}" var="fuck">
<tr>
<td>${fuck.empId}</td>
<td>${fuck.empName}</td>
<td>${fuck.empAge}</td>
<td>${fuck.hireDate}</td>
</tr>
<script>
$("#s${user.userId}").click(function(){
	   var id=${user.userId};
	   $.get("del",{id:id},function(){
		   location.reload();
	   });
});
</script>

</c:forEach>
</table>
  </div>
  </c:when> 
  <c:otherwise>
  <div id="kk">
<table class="table table-hover" id="td" style="width:800px;">
<tr>
<th>员工编号</th>
<th>员工姓名</th>
<th>员工年龄</th>
<th>员工雇佣日期</th>
<th></th>
</tr>
<c:forEach items="${chooseEmp}" var="emp">
<tr>
<td>${emp.empId}</td>
<td>${emp.empName}</td>
<td>${emp.empAge}</td>
<td>${emp.hireDate}</td>
</tr>
</c:forEach>
</table>
  </div>
  </c:otherwise>
</c:choose>
 </div>

</body>
</html>