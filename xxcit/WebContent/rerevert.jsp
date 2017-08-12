<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>回复</title>
		<link rel="stylesheet" type="text/css" href="images/style.css">
	</head>

	<body background="images/bg1.jpg">
	

		<c:if test="${empty revert}">
			<c:set scope="request" var="error" value="您无权访问此页！！！"></c:set>
			<jsp:forward page="error.jsp"></jsp:forward>
		</c:if>
		
		<div align="center">
			<div align="center" class="div2">
				<table align="center" width="100%" border="0" bgcolor="#C1C1C1"
					cellpadding="1" cellspacing="1">
					<tr>
						<td colspan="2" align="center" height="30" bgcolor="#941F53">
							<font class="title2">回 复 留 言</font>
						</td>
					</tr>
					
					<tr bgcolor="#FAFAFA">
						<td align="right">
							<b>内 容：</b>
						</td>
						<td>
							&nbsp;${revert.content}
						</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						<td align="right" height="25">
							<b>网 友：</b>
						</td>
						<td>
							&nbsp;${revert.userid.username}
						</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						<td align="right">
							<b>回复留言：</b>
						</td>
						<td>
							<form action="MessageServlet" method="post">
								<table border="0">
									<tr>
										<td>
											<input type="hidden" name="method" value="saveOrUpdateReRevert">
											<input type="hidden" name="id" value="${revert.id}">
											<textarea rows="5" cols="50" name="content">
												
											</textarea>
										</td>
										<td align="center" valign="middle">
											<input type="submit" value="回 复" />
										</td>
									</tr>
								</table>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</div>
	
	</body>
</html>
