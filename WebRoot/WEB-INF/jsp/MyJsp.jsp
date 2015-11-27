<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page"> 
 <script src="${pageContext.request.contextPath}/resources/scripts/jquery-1.11.3.min.js"></script> 
 <script> 
$(document).ready(function(){ 
    $("#btnGet").click(function(){ 
    	//alert("hello"); 
        $.ajax({ 
            type: 'GET', 
            url : 'client/qiuqi',   //通过url传递name参数
            dataType : 'json', 
            data: {title: "Mr"},   //通过data传递title参数
            success : function(data) { 
                alert(data.name);   
            }, 
            error : function(data) {   
                alert(data.responseText); 
            }   
        });  
    }); 
}); 

function upRetOrdProduct(){
	alert("hello");   
	//$("#qrtyth").attr("disabled","disabled");
	$("#qrtyth").removeAttr("href");
	$("#qrtyth").removeAttr("onclick");
}


</script> 
</head> 
<body> 
${hello} 
${client.name} 
<br/> 
<input id="btnGet" type="button" value="get client" /> 
<br/>
<a href="#" onclick="upRetOrdProduct(); return false;" class="btn_80 marginauto" id="qrtyth">确认</a>
</body> 

</html>
