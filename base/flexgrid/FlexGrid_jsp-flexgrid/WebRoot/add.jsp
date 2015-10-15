<%
     request.setCharacterEncoding("UTF-8");
     String path = request.getContextPath();
     String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   
    
     String username=request.getParameter("username");
     String password=request.getParameter("password");
     String age=request.getParameter("age");
     if(age==null||age==""){
        age = "0" ;
     }
     String address=request.getParameter("address");
            
     dao.StudentDAO ctl=new dao.StudentDAO();
     dao.Student users=new dao.Student();
     users.setAddress(address);
     users.setAge(Integer.parseInt(age));
     users.setUsername(username);
     users.setPassword(password);
     
     if(ctl.save(users)){
     out.clear();
     out.print("true");
     }else{
     out.clear();
     out.print("false");
     }  
     %>
     