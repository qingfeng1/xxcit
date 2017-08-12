<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>社团首页-小小草IT科技社 </title>

<!-- Bootstrap -->
<!-- <link href="file:///F|/LittleTree/corporation/css/bootstrap.css" rel="stylesheet"> -->
<link href="css/bootstrap-3.3.4.css" rel="stylesheet" type="text/css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
<script type="text/javascript">


	    	function login(form){
	        	if(form.elements["name"].value == ""){
					alert("姓名不能为空");
					return false;
	        	}
	        	if(form.elements["number"].value == ""){
					alert("学号不能为空");
					return false;
	        	}
	        	var phonenumber =form.elements["phonenumber"]
	        	var regExpression = /^(86)?((13\d{9})|(15[0,1,2,3,5,6,7,8,9]\d{8})|(18[0,5,6,7,8,9]\d{8}))$/;
	        	if(!regExpression.test(phonenumber.value)){	
	        		alert("您输入的手机号码有误！");
	        		phonenumber.focus();						
	        		return false;	
	        								



		        }
	        	
	    	}
	    	function message(form){
	    		if(form.elements["title"].value == ""){
					alert("留言标题不能为空！");
					return false;
	        	}
	        	if(form.elements["content"].value == ""){
					alert("留言内容不能空！");
					return false;
	        	}
	    	}
	    	function checkePwd(user){
	    		var str=user;
	    		 //在JavaScript中，正则表达式只能使用"/"开头和结束，不能使用双引号
	    		var Expression=/^[0-9]/; 
	    		var objExp=new RegExp(Expression);		//创建正则表达式对象
	    		if(objExp.test(str)==true){				//通过正则表达式验证
	    			return true;
	    		}else{
	    			return false;
	    		}
	    	}
	    	function cheQQnumber(str){
	    		if(str==""){
		        	document.getElementById("div_user").innerHTML="请输入QQ号码";
		        	document.getElementById("tr_user").style.display="block";
	    		}else if(!checkePwd(str)){
	    			document.getElementById("div_user").innerHTML="QQ号码有误";
		        	document.getElementById("tr_user").style.display="block";

	    		}else{
			        document.getElementById("div_user").innerHTML="";
			        document.getElementById("tr_user").style.display="block";
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

<jsp:include page="head.jsp"></jsp:include>

<div style="height:60px;border:0px solid gray;"></div>
<div class="container">
<div class="row" style="background:url(img/third.jpg)">
    <div class="col-md-3" style="height:600px;border:0px solid gray;"></div>
    <div class="col-md-6" style="height:600px;border:0px solid gray;">
    <div style="height:80px;border:0px solid gray;"></div>
    <div style="height:420px;border:0px solid gray;">
    <form name="apply" action="StudentServlet" method="post" onsubmit="return login(this);">
	<div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-6" style="height:50px;border:0px solid gray;">姓 名：<input type="text" name="name"></div>
        </div>
		
		<div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-6" style="height:50px;border:0px solid gray;">性 别：<input type="text" name="sex"></div>
        </div>
		
        <div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-6" style="height:50px;border:0px solid gray;">学 号：<input type="text" name="number"></div>
        </div>
        <div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-7" style="height:50px;border:0px solid gray;"> 
          学 院：<select name="college" id="">
           <option>文学院</option>
                <option>理学院</option>
                <option>政治学院</option>
                <option>管理学院</option>
                <option>商学院</option>
                <option>教育科学院</option>
                <option>外国语学院</option>
                <option>化学化工学院</option>
                <option>生命科学学院</option>
                <option>机械工程学院</option>
                <option>电子信息学院</option>
                <option>电气工程学院</option>
                <option>计算机科学与技术学院</option>
                <option>建筑工程学院</option>
                <option>纺织服装学院</option>
                <option>医学院</option>
                <option>公共卫生学院</option>
                <option>护理学院</option>
                <option>体育科学学院</option>
                <option>艺术学院</option>
                <option>地理科学学院</option>
                <option>杏林学院</option>
          </select>
          </div>
        </div>
        <div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-6" style="height:50px;border:0px solid gray;">专 业：<input type="text" name="major"></div>
        </div>
        <div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-6" style="height:50px;border:0px solid gray;">班 级：<input type="text" name="st_class"></div>
        </div>
        <div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-9" style="height:50px;border:0px solid gray;">手机号：<input type="text" name="phonenumber">
          </div>
        </div>
		 <div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-9" style="height:50px;border:0px solid gray;">
          QQ号码：<input type="text" name="qqnumber" onBlur="cheQQnumber(this.value)">
           <div class="col-md-9"  id="div_user" style="color:#FF0000;"></div>
          </div>
        </div>
       
        <div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-13" style="height:50px;border:0px solid gray;">
          输入验证码：<input type="text" name="paramCode" onBlur="cheCode(this.value)"> 
           <img id="img" alt="" src="validatecode"  >
           <a href="javascript:_change()">换一张</a>
<div class="col-md-9"  id="div_code" style="color:#FF0000;"></div>
          
          </div>
        </div>
        
        

        
        <div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-6" style="height:50px;border:0px solid gray;">
<div class="row">
              <div class="col-md-6"><button type="submit" class="btn btn-sm btn-default">提交</button> </div>
              <div class="col-md-6"><button type="reset" class="btn btn-sm btn-default">重置</button> </div>
            </div>

          </div>
        </div>
       </form> 
</div>
        
</div>
</div>
</div>
<div class="center-block" style="margin-left:465px;"><p>copyright @ IT science and Technology Society of  Nantong University</p></div>
            <div class="center-block" style="margin-left:420px;"><p>地址：江苏省崇川区啬园路9号南通大学工程训练中心 <a href="">Furious IT工作室</a>设计制作维护</p></div> 


 
     
 
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="js/jquery-1.11.2.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed --> 
<!-- <script src="file:///F|/LittleTree/corporation/js/bootstrap.js"></script> -->
<script src="js/bootstrap-3.3.4.js" type="text/javascript"></script>
</body>
</html>