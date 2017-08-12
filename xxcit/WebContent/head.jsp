<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<nav class="navbar navbar-default navbar-fixed-top" style="height:80px;">
   <div class="container-fluid">
     <!-- Brand and toggle get grouped for better mobile display -->
     <div class="navbar-header">
       <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#topFixedNavbar1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
       <p style="color:gray;">小小草IT科技社</p><img src="img/u_2926000199_1130071887&fm_26&gp_6.png" alt=""></div>
     <!-- Collect the nav links, forms, and other content for toggling -->
     <div class="collapse navbar-collapse" id="topFixedNavbar1">
     
       <ul class="nav nav-pills" style="margin:20px;">
        
         <li class=""><a href="index.jsp">社团首页<span class="sr-only">(current)</span></a></li>
         <li><a href="introduction.jsp">社团介绍</a></li>
     
         <li><a href="appearance.jsp">社团风采</a></li>
         <li><a href="activity.jsp">社团活动</a></li>
         <li><a href="message_list.jsp">留言簿</a></li>
         <li><a href="joinus.jsp">加入我们</a></li> 
          <li><p style="color:#F9F9F9;">登录&nbsp;&nbsp;&nbsp;&nbsp;</p></li>
         <li><p style="color:#F9F9F9;">注册&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p></li>
         <li><p style="color:#F9F9F9;">管理员入口&nbsp;&nbsp;&nbsp;&nbsp;</p></li>
         <li> <p style="color:#F9F9F9;">登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p></li>
         <li> <p style="color:#F9F9F9;">注册&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p></li>
         <li> <p style="color:#F9F9F9;">管理员入口&nbsp;&nbsp;</p></li>
      
				<c:choose>
	 				<c:when test="${empty user}">
	 					<li><a href="Mlogin.jsp"><p style="color:green;">登录</p></a></li>
	 					<li><a href="Menroll.jsp"><p style="color:orange;">注册</p> </a>  </li>
	 					<li><a href="Mlogin.jsp"><p style="color:red;">管理员入口</p></a></li>
	 					
	 				</c:when>
	 				<c:when test="${!empty admin}">
	 					
	 					<li><a href=""><p style="color:orange;">管理员：${user.username}</p></a> </li>
	 					
	 					<li><a href="UserServlet?method=exit"><p style="color:red;">退出登录</p> </a></li>
	 					
	 				</c:when>
	 				<c:otherwise>
	 				
	 					<li><a href=""><p style="color:orange;">用户：${user.username}</p></a> </li>
	 					
	 					<li><a href="UserServlet?method=exit"><p style="color:red;">退出登录</p> </a></li>
	 					
	 				</c:otherwise>
	 			</c:choose>
 	
       </ul>
         
      
       
     </div>
   </div>
</nav>
 
   

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="js/jquery-1.11.2.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed --> 
<!-- <script src="file:///F|/LittleTree/corporation/js/bootstrap.js"></script> -->
<script src="js/bootstrap-3.3.4.js" type="text/javascript"></script>


    