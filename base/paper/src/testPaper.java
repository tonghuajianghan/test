
//paper³É¹¦
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;


public class testPaper {
public static void main(String[] args) {
	 Configuration cfg = new Configuration();
	 SessionFactory sf = cfg.configure().buildSessionFactory();
	 Session session = sf.openSession();
	 session.beginTransaction();
	 ///////////////////////
	 vo.Paper pa =(vo.Paper)session.get(vo.Paper.class, 1);
	 System.out.print(pa.getLwtm());
	 System.out.print("jj"); 
	 session.getTransaction().commit();
	 session.close();
	 sf.close();
}
}
