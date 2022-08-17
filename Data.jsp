<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Data</title>
</head>
<body>
<%
try
{
 Class.forName("com.mysql.jdbc.Driver");
 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/login","root","");
 Statement st=cn.createStatement();
String username = request.getParameter("username");        
String password = request.getParameter("password");        
String confirmpassword = request.getParameter("confirmpassword");

        String s1="insert into logindetails values('"+username+"','"+password+"')" ;   
        
      if(password.equals(confirmpassword))
      {
    	 boolean a=st.execute(s1);
    	  if(true.equals(a))
     
          {
        	%><script type="text/javascript">
			 alert("Registration Successful");
		     location="Login.html";
			 </script>
			<% 
          }
        else{
        	%><script type="text/javascript">
			 alert("Fill the Details Correctly");
		     location="Registration.html";
			 </script>
			<% 
         }
       }
      else{
    	  %><script type="text/javascript">
			 alert("Password and Confirm Password must be the same");
		     location="Registration.html";
			 </script>
			<% 
      }

}
catch(Exception er){System.out.println("error"+er);
}

   %>
   
    </body>
    </html>