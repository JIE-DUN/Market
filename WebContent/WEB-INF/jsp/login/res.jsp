<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
</head>
<body>
<div class="width100 hidden_yh" style="border-top: 1px solid #ddd">
    <div class="width1200 hidden_yh center_yh" style="margin-top: 75px">
		<div class="center_yh hidden_yh" style="width: 475px;margin-bottom: 40px;">
			<span style="margin-right: 40px;height: 42px;line-height: 42px;width: 100px;" class="left_yh block_yh tright">用户名：</span>
			<input type="text" id="userName" placeholder="请输入您的用户名" style="border:1px solid #c9c9c9;width: 292px;height: 42px;font-size: 16px;text-indent: 22px;" class="left_yh">
		</div>
		<div class="center_yh hidden_yh" style="width: 475px;margin-bottom: 40px;">
			<span style="margin-right: 40px;height: 42px;line-height: 42px;width: 100px;" class="left_yh block_yh tright">设置密码：</span>
			<input type="password" id="passWord" placeholder="建议至少使用两种字符组合" style="border:1px solid #c9c9c9;width: 292px;height: 42px;font-size: 16px;text-indent: 22px;" class="left_yh">
		</div>
		<div class="center_yh hidden_yh" style="width: 475px;margin-bottom: 40px;">
			<span style="margin-right: 40px;height: 42px;line-height: 42px;width: 100px;" class="left_yh block_yh tright">手机号：</span>
			<input type="text" id="phone" placeholder="建议使用常用的手机" style="border:1px solid #c9c9c9;width: 292px;height: 42px;font-size: 16px;text-indent: 22px;" class="left_yh">
		</div>
		<div class="center_yh hidden_yh" style="width: 475px;margin-bottom: 40px;">
			<span style="margin-right: 40px;height: 42px;line-height: 42px;width: 100px;" class="left_yh block_yh tright">电子邮箱：</span>
			<input type="text" id="email" placeholder="请输入邮箱" style="border:1px solid #c9c9c9;width: 292px;height: 42px;font-size: 16px;text-indent: 22px;" class="left_yh">
		</div>
		<p class="font14 c_66" style="text-indent: 500px;margin-top: 30px;">
		    <input type="checkbox" id="cr">我已阅读并同意<a href="#" class="red">《会员注册协议》</a>和<a href="#" class="red">《隐私保护政策》</a>
		</p>
		<a href="javascript:void(0)" class="ipt_tj con" style="width: 295px;height: 44px;margin-left:500px;">
        	提交
        </a>
		<!-- <input type="submit" value="提交" class="ipt_tj" style="width: 295px;height: 44px;margin-left: 500px;"> -->
    </div>
</div>
<%@include file="/common/ufooter.jsp"%>
</body>
<script>
    $(".con").click(function(){
        var userName = $("#userName").val();
        var passWord = $("#passWord").val();
        var phone = $("#phone").val();
        var email = $("#email").val();
        var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        if(userName==null||userName==''){
            alert("请输入用户名");
            return false;
        }
        if(passWord==null||passWord==''){
            alert("请输入密码");
            return false;
        }
        if(phone.length != 11){
        	alert("手机号不正确");
        	return false;
        }
        if(email==null||email==''){
            alert("请输入邮箱");
            return false;
        }
        if(!reg.test(email)){
            alert("邮箱格式不对");
            return false;
        }
        if(!$("#cr").is(":checked")){
    		alert('请阅读并同意签约《会员注册协议》与《隐私保护政策》');
    		return false;
    	}
        $.ajax({
            type:"POST",
            url:"${ctx}/login/toRes",
            data:{
                "userName":userName,
                "passWord":passWord,
                "phone":phone,
                "email":email
            },
            success:function (result) {
            	if(result.res == 0){
                    alert("用户名已被注册");
                    return false;
                }else if(result.res == 1){
                    alert("邮箱已被注册");
                    return false;
                }else if(result.res == 2){
	                alert("注册成功")
	                window.location.href = "${ctx}/login/uLogin";
                }
            }
        });
    });
</script>
</html>



















