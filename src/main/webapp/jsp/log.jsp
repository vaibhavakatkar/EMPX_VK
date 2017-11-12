
<%@ page import ="java.sql.*" %>
<%
    try{
        String firstname = request.getParameter("firstname");   
        String password = request.getParameter("password");
        Class.forName("com.mysql.jdbc.Driver");  
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "root");    
        PreparedStatement ps = conn.prepareStatement("Select username,password from loginauth where username=? and password=?");
        ps.setString(1, firstname);
        ps.setString(2, password);
        ps.execute();
     ps.executeQuery();  
     response.sendRedirect("index.jsp");
    }     
     catch(Exception e){       
         out.println("Something went wrong !! Please try again");       
     }      

%>