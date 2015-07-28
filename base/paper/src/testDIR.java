import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import vo.DIR;


public class testDIR {
  public static void main(String[] args) {
	     Configuration cfg = new Configuration();
		 SessionFactory sf = cfg.configure().buildSessionFactory();
		 Session session = sf.openSession();
		 session.beginTransaction();
		 DIR D = (DIR)session.get(DIR.class,1);
		 System.out.print(D.getID());
		 System.out.print("jj"); 
		 session.getTransaction().commit();
		 session.close();
		 sf.close();	  
}
}
