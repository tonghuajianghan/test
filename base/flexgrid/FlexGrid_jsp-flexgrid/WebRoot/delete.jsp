<%
     request.setCharacterEncoding("UTF-8");
     String path = request.getContextPath();
     String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   
    
     dao.StudentDAO ctl=new dao.StudentDAO();
     dao.Student users=new dao.Student();
      
     String id[]=request.getParameterValues("id");
     if(id!=null){
     for(int i=0;i<id.length;i++){
        users= ctl.findById(Integer.parseInt(id[i]));
        if(ctl.delete(users)){
        }
       }
      response.sendRedirect("index.html"); 
     }else{
      response.sendRedirect("index.html"); 
     }
 
     %>
     