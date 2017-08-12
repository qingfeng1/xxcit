<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>注册-小小草IT科技社</title>
<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet" type="text/css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
 <script type="text/javascript">
    	function reg(form){
        	if(form.elements["username"].value == ""){
				alert("用户名不能空！");
				return false;
        	}
        	if(form.elements["password"].value == ""){
				alert("密码不能空！");
				return false;
        	}
        	if(form.elements["repassword"].value == ""){
				alert("确认密码不能空！");
				return false;
        	}
        	if(form.elements["repassword"].value != form.elements["password"].value){
				alert("两次密码输入不一致！");
				return false;
        	}
        	if(form.elements["paramCode"].value == ""){
				alert("请输入验证码");
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
 
 <a href="index.jsp">返回首页</a>
 
<div class="container">
  <div class="row text-center">
    <div class="col-md-6 col-md-offset-3"><p style="color:#3B9F3B;">欢迎您注册成为网站会员，如果您已拥有账户，可在此<a href="Mlogin.jsp">登录</a></p></div>
  </div>
  <hr>
  <div class="row text-center">
    <div class="text-justify col-sm-4" style="background:url(img/f7ad220cc14d5c96946436da0a04871c.jpg); height:400px;border:0px solid #7CFC00;padding:20px;margin:0px 190px 0px 190px;" > 
    <br><br>
    <br>
    <br>
    
    <form action="UserServlet" method="post" onsubmit="return reg(this);">
  		<input type="hidden" name="method" value="guestReg" />
	    <table align="center" width="100%" border="0" bgcolor="#C1C1C1" cellpadding="1" cellspacing="1">
	    	
	    	<tr >
	    	
	    	
	    		<td align="right">用户名：</td>
	    		<td>
	    			<input type="text" name="username"/><font color="red"> *</font>
	    			不能有空格，可以是中文，长度在3-50字节以内
	    		</td>
	    	</tr>
	    	

	    	<tr >
	    		<td align="right">密 码：</td>
	    		<td>
	    			<input type="password" name="password" >
	    			<font color="red"> *</font>
	    			英文字母或数字，不少于6位
	    		</td>
	    	</tr>
	    	
	    	<tr >
	    		<td align="right">确认密码：</td>
	    		<td>
	    			<input type="password" name="repassword">
	    		
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
						
	    	
	    	<tr >
	    		<td colspan="2" align="center" height="50">
	    			<input type="submit" value="注册"/>
	    			<input type="reset" value="重置"/>
	    		</td>
	    	</tr>
	    </table>
    </form>
    
   
       </div><br><br>
       <div class="center-block" style="margin-left:50px;"><p>copyright @ IT science and Technology Society of  Nantong University</p></div>
            <div class="center-block" style="margin-left:40px;"><p>地址：江苏省崇川区啬园路9号南通大学工程训练中心 <a href="">Furious IT工作室</a>设计制作维护</p></div> 
       
    
   
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="js/jquery-1.11.2.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script src="js/bootstrap.js"></script>
</div></div>
 </body>
</html>
