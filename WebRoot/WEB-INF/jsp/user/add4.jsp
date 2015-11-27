<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#button_submit").click(function(){
            
            var name = $("#userName").val();
            var pass = $("#password").val();
            

            var user = {userName:name,password:pass};//拼装成json格式
         
            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/user/addUser6",
                data:user,
                dataType:"json", 
                success:function(data){
                    alert("成功:"+data.userName);
                },
                error:function(e) {
                    alert("出错："+e);
                }
            });
        });
    });
</script>

</head>
<body>
    <form id="userForm">
        <table>
            <tr>
                <td>账号</td>
                <td>
                    <input type="text" id="userName" name="userName">
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input type="password" id="password" name="password">
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>
                    <input type="button" id="button_submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>