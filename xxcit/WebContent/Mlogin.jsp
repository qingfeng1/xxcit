<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录-小小草IT科技社</title>

<!-- Bootstrap -->
<!-- <link href="css/bootstrap.css" rel="stylesheet"> -->
<link href="css/bootstrap-3.3.4.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-responsive.css" rel="stylesheet" type="text/css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
    <script type="text/javascript">
    function login(form){
    	if(form.elements["username"].value == ""){
			alert("用户名不能空！");
			return false;
    	}
    	if(form.elements["password"].value == ""){
			alert("密码不能空！");
			return false;
    	}
    	if(form.elements["paramCode"].value == ""){
			alert("验证码不能空！");
			return false;
    	}
	}

    function cheCode(str){
		if(str==""){
        	document.getElementById("div_code").innerHTML="请输入验证码";
        	document.getElementById("tr_code").style.display="block";

		}else{
	        document.getElementById("div_code").innerHTML="";
	        document.getElementById("tr_code").style.display="block";
		}
	}
	
	


	function _change() {
		/*
		1. 得到img元素
		2. 修改其src为/day11_3/VerifyCodeServlet
		*/
		var imgEle = document.getElementById("img");
		imgEle.src = "validatecode?a=" + new Date().getTime();
		

	}
    
    </script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid"> 
    <!-- Brand and toggle get grouped for better mobile display -->
    <p style="color:gray;">欢迎来到小小草IT科技社</p>
    <div class="navbar-header">
       <a href="index.jsp">返回首页</a> &nbsp;&nbsp;
      如果您还未注册，请在此 <a href="Menroll.jsp">注册</a>
    </div>
   
      
      <div class="col-sm-12 text-center" style="height:500px;border:0px solid gray;background:url(img/7065230ad9fe0e846f902db49278f057.jpg);background-size:height:500px;weight:800px;"> 
      <div style="height:100px;"></div>
      <h1 style=" text-align:center;color:white;">Login</h1><br>
           
        <form action="UserServlet" method="post" onsubmit="return login(this);">
					<input type="hidden" name="method" value="userLogin">
					<table border="0" width="750" align="center" cellpadding="1" cellspacing="1"  bgcolor="#F0F0F0">
					
						<tr>
							<td height="20"></td>
						</tr>
						<tr>
							<td align="right">用户名：</td>
							<td>
								<input type="text" name="username">
							</td>
						</tr>
						<tr >
							<td align="right">密 码：</td>
							<td>
								<input type="password" name="password" class="input1">
							</td>
						</tr>
						<tr >
							<td align="right">验证码：</td>
							<td>
								<input type="text" name="paramCode" class="input1" onBlur="cheCode(this.value)">
								 <img id="img" alt="" src="validatecode"  >
          						 <a href="javascript:_change()">换一张</a>
          						 <div class="col-md-9"  id="div_code" style="color:#FF0000;"></div>
							</td>
						</tr>
						
	
        </div>
						<tr bordercolor="#FFFFFF">
							<td colspan="2" align="center" height="50">
								<input type="submit" value="登 录" />
								<input type="reset" value="重 置" />
							</td>
						</tr>
					</table>
				</form>
           
           
            
</div>
<br><br><br>
 <div class="center-block" style="margin-left:467px;"><p>copyright @ IT science and Technology Society of  Nantong University</p></div>
            <div class="center-block" style="margin-left:420px;"><p>地址：江苏省崇川区啬园路9号南通大学工程训练中心 <a href="">Furious IT工作室</a>设计制作维护</p></div> 
       

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="js/jquery-1.11.2.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed --> 
<!-- <script src="js/bootstrap.js"></script> -->
<script src="js/bootstrap-3.3.4.js" type="text/javascript"></script>
</div></nav>

</body>

</html>
