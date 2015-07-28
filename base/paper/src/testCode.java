import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import vo.Code;
import vo.CodeType;


public class testCode {
  public static void main(String[] args) {
	     Configuration cfg = new Configuration();
		 SessionFactory sf = cfg.configure().buildSessionFactory();
		 Session session = sf.openSession();
		 session.beginTransaction();
		
		 CodeType co =new CodeType();
		 Code coo = new Code() ;
		 
		 coo.setInfo("hh");
		 coo.setName("Œ“");
		 coo.setNumber(678);
		 coo.setType("hhhhh");
			
		 co.setCtype("5555");
		 co.getCodes().add(coo);
		 
		 session.save(coo);
		 session.save(co);
		 
		 session.getTransaction().commit();
		 session.close();
		 sf.close();	  
}
}
