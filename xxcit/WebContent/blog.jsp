<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>留言簿-小小草IT科技社</title>
<link href="BlogPostAssets/styles/blogPostStyle.css" rel="stylesheet" type="text/css">
<!-- <link href="css/bootstrap.css" rel="stylesheet" type="text/css"> -->
<link href="css/bootstrap-3.3.4.css" rel="stylesheet" type="text/css">
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
 
<script src="http://use.edgefonts.net/montserrat:n4:default;source-sans-pro:n2:default.js" type="text/javascript"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

<script type="text/javascript">
			function changePage() {
				var currPage = document.getElementById("currPage").value;
				window.self.location = "MessageServlet?method=view&currPage="
						+ currPage;
			}
</script>

</head>

<body>
 
<div id="mainwrapper"> 
  <header style="background:url(img/3-151115230206.jpg);width:auto;height:190px;"></header>
      

<jsp:include page="head.jsp"></jsp:include>


    <section id="mainContent"> <br>
      <!--************************************************************************
    Main Blog content starts here
    ****************************************************************************-->
      <h1 style="color:#036684"><!-- Blog title -->留言簿</h1>
      <h3 style="color:#036684"><!-- Tagline -->尽情向管理员发牢骚吧！（各种资源，各种提问...）</h3>
      
   
      				<form action="MessageServlet" method="post" onsubmit="return message(this);">
					<input type="hidden" name="method" value="save">
					<table border="0" width="500" align="center" cellpadding="1" cellspacing="1"  bgcolor="#F0F0F0">
						
						
						<tr>
							<td height="10"></td>
						</tr>
						
					
						<tr bordercolor="#FFFFFF">
							<td align="right"></td>
							<td>
							
								<textarea rows="8" cols="90" name="content"></textarea>
							</td>
						</tr>
						<tr bordercolor="#FFFFFF">
							<td colspan="2"  align="right"                     height="50">
								<input type="submit" value="留 言" />
							</td>
						</tr>
					</table>
				</form>
      
      
      <div style="border:0px solid gray;height:50px;"></div>
      <div style="border:1px solid gray;"></div>
 
      <div style="boeder:0px solid gray; height:30px;"></div>
 
      <div style="height:30px;"></div>
    </section>
    <section id="sidebar"> 
      <!--************************************************************************
    Sidebar starts here. It contains a searchbox, sample ad image and 6 links
    ****************************************************************************-->
     <div class="well">
     <!--   <input type="text" placeholder="Search">-->
         </div>
       
      <div id="adimage" style="border:0px solid black;"></div>
     <nav>
        <ul>
          <li><a href="#" title="Link">link1</a></li>
          <li><a href="#" title="Link">link2</a></li>
          <li><a href="#" title="Link">Link3</a></li>
          <li><a href="#" title="Link">Link4</a></li>
          <li><a href="#" title="Link">Link5</a></li>
          <li><a href="#" title="Link">Link6</a></li>
        </ul>
      </nav>
    </section>
 		<table align="center" border="0" width="750" cellpadding="0"
			cellspacing="0">
			<c:choose>
						
				 <c:when test="${empty pageModel.list}">
					<tr>		
						<td align="center">
							没有留言内容!
						</td>
					</tr>
				</c:when>
			<c:otherwise>
			
			
			<!-- 循环输出留言信息 -->
				<c:forEach items="${pageModel.list}" var="m">
					<tr><td>
						<!-- 留言板内容 -->
						<table border="0" width="750" align="center" cellpadding="0"
							cellspacing="0">
							<tr bordercolor="#FFFFFF" bgcolor="#F0F0F0">
							<%-- <td height="22">
								<!-- 留言标题 -->
							<font class="user">${m.user.username}</font>
													
							</td> --%>
												
							<td colspan="2" align="left" class="td2">
							<img src="${m.user.img_head}" width="36" height="36">
													
							<a href="#" title="Link">${m.user.username}</a>
						
							

							<fmt:formatDate pattern="yyyy-dd-MM HH:mm:ss"
								value="${m.createTime}" />
													
												
							</td>
									
							</tr>
							<tr bordercolor="#FFFFFF" bgcolor="#FFFFFF">
							<td colspan="2">
							<!-- 留言内容 -->
							<div class="td1">${m.content}</div>
							</td>
								</tr>
							<tr bordercolor="#FFFFFF" bgcolor="#FFFFFF">
								<td align="right">
													
									<a href="MessageServlet?method=revert&id=${m.id}">回复</a>
								<!-- 判断管理员用户是否登录 -->
								<c:if test="${!empty admin && m.user.username!=user.username}">	
									<a href="ManagerServlet?method=delete&id=${m.id}">删除</a>
								</c:if>
								
								<!-- 判断是否本人登录 -->
							
								<c:if test="${m.user.username==user.username}">	
									<a href="MessageServlet?method=update&id=${m.id}">修改</a>
									<a href="MessageServlet?method=delete&id=${m.id}&user=${user.username}">删除</a>
								</c:if>
								</td>
								</tr>
								
								
								<!-- 判断是否存在回复信息 -->
								<c:if test="${!empty m.revert}">
												<%--  <c:forEach>标签用于通用数据循环，它有以下属性
													属 性 	            描 述 			是否必须 	缺省值
													items 	进行循环的项目 	否 		无
													begin 	开始条件 	否 	0
													end 	结束条件 	否 	集合中的最后一个项目
													step 	步长 	否 	1
													var 	代表当前项目的变量名 	否 	无
													varStatus 	显示循环状态的变量 	否 	无 --%>
								
								
								<c:forEach items="${m.revert}" var="revert">	 
								
								<%--  <c:forEach items="${m.revert }" var="revert">	 --%> 										
								<tr><td colspan="2">
								<div class="hf" align="center">
								<table border="0" cellpadding="1" cellspacing="1" width="690">
								 <tr>
								<td align="left" valign="middle">
								<img src="${revert.userid.img_head}" width="18" height="18">
								 <font class="hf-title">
								<a href="#" title="Link">${revert.userid.username}</a>
									回复：
								</font>
								</td>
														 
								<td align="right">

															
								</td>
								</tr>
								<tr>
								<td colspan="2" height="2" bgcolor="#F0F0F0"></td>
								</tr>
								<tr>
									<td colspan="2">${revert.content}</td>
								</tr>
								<tr>
									<td colspan="2" align="right" class="td2">回复时间 ：
										<fmt:formatDate pattern="yyyy-dd-MM HH:mm:ss"
										value="${revert.revertTime}" />
										<a href="MessageServlet?method=rerevert&id=${revert.id}">回复</a>
																		<!-- 判断管理员用户是否登录 -->
								<%-- <c:if test="${!empty admin && revert.userid.username!=user.username}">	
									<a href="ManagerServlet?method=delete&id=${revert.id}">删除</a>
								</c:if>
								
								<!-- 判断是否本人登录 -->
								<c:if test="${revert.userid.username==user.username}">	
									<a href="MessageServlet?method=revertdelete&id=${revert.id}&user=${user.username}">删除</a>
								</c:if>			 --%>	
									</td>
								</tr>
									<!-- 判断是否存在回复信息 -->		
										 <c:if test="${!empty revert.rerevert}">
											<!-- 输出回复信息 -->
												
										<c:forEach items="${revert.rerevert }" var="rerevert">											
											<tr><td colspan="2">
												<div class="hf" align="center">
												<table border="0" cellpadding="1" cellspacing="1" width="500">
												 <tr>
														<td align="left" valign="middle">
														<img src="images/admin.jpg" width="18" height="18">
														 <font class="hf-title">
														 <a href="#" title="Link">${rerevert.re_userid.username}</a>
														 回复
														 <a href="#" title="Link">${rerevert.re_user.username}</a>
														 </font></td>
														 
													</tr>
													<tr>
														<td colspan="2" height="2" bgcolor="#F0F0F0"></td>
													</tr>
													<tr>
														<td colspan="2">${rerevert.content}</td>
													</tr>
									
													<tr>
														<td colspan="2" align="right" class="td2">回复时间 ：
														<fmt:formatDate pattern="yyyy-dd-MM HH:mm:ss"
													value="${rerevert.revertTime}" />
														  <a href="RevertServlet?method=reply&id=${rerevert.id}">回复</a> 					 
												<%--  		
														
														<!-- 判断管理员用户是否登录 -->
													<c:if test="${!empty admin && rerevert.re_userid.username!=user.username}">	
														
														<a href="ManagerServlet?method=delete&id=${revert.id}">删除</a>
													</c:if>
													
													<!-- 判断是否本人登录 -->
													<c:if test="${rerevert.re_userid.username==user.username}">	
								
														<a href="MessageServlet?method=delete&id=${rerevert.id}&user=${user.username}">删除</a>
													</c:if> --%>
													</td>
													</tr>

												</table>
												</div>
											</td></tr>
											
											</c:forEach>
											</c:if> 
													
													
												</table>
												</div>
											</td></tr>
											
											</c:forEach>
											</c:if> 
										</table>
									</td></tr>
								</c:forEach>
								<tr bordercolor="#FFFFFF" bgcolor="#F0F0F0" align="center">
									<td height="8">
									</td>
								</tr>
								<tr bordercolor="#FFFFFF" >
									<td height="10"></td>
								</tr>
								<!-- 分页条 -->
								<tr bordercolor="#FFFFFF" bgcolor="#FFFFFF">
									<td colspan="2">
									<table border="0" width="750" align="center">
										<tr>
										<td align="right">
											总记录数：${pageModel.totalRecords}
											当前${pageModel.currPage}/${pageModel.totalPage}页
											<a href="MessageServlet?method=view&currPage=${pageModel.previousPage}">
												上一页
											</a>
											<a href="MessageServlet?method=view&currPage=${pageModel.nextPage}">
												 下一页
												 
											</a>
											<select id="currpage" onchange="changePage()">
												<c:forEach begin="1" end="${pageModel.totalPage}"
													varStatus="vs">
													<c:choose>
														<c:when test="${pageModel.currPage ne vs.count}">
															<option value="${vs.count}">
																第${vs.count}页
															</option>
														</c:when>
														<c:otherwise>
															<option value="${vs.count}" selected="selected">
																第${vs.count}页
															</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</select>
										</td>
										</tr>
									</table>
									</td>
								</tr>
							</c:otherwise>
						</c:choose>
						<tr bordercolor="#FFFFFF" >
							<td height="10"></td>
						</tr>
						<tr bordercolor="#FFFFFF" bgcolor="#FFFFFF">
							
						</tr>
					</table>
					
 
    <footer> 
      <!--************************************************************************
    Footer starts here
    ****************************************************************************-->
      <article>
       <!-- <h3>Footer1</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>--> 
      </article>
      <article>
       <!-- <h3>Footer2</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>--> 
      </article>
      
      
    </footer>
  </div>
  <div id="footerbar" style="background:url(img/3-151115230206.jpg);height:30px;"> </div>
</div>
  <div class="center-block" style="margin-left:467px;"><p>copyright @ IT science and Technology Society of  Nantong University</p></div>
            <div class="center-block" style="margin-left:420px;"><p>地址：江苏省崇川区啬园路9号南通大学工程训练中心 <a href="">Furious IT工作室</a>设计制作维护</p></div> 
       
<script src="js/jquery-1.11.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
</body>
</html>
