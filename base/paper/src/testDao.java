import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import vo.Author;
import vo.Person;
import dao.PersionDBDao;
import dao.inter.PersionDao;


public class testDao {
  public static void main(String[] args) {
/*	PersionDao pd = new PersionDBDao();
    List<Persion> li =	pd.queryPersionById(1);
    for(int i = 0;i < li.size();i++){
    	System.out.print(li.get(i));
    }
	pd.deletePersionById(1);*/
	  
	     Configuration cfg = new Configuration();
		 SessionFactory sf = cfg.configure().buildSessionFactory();
		 Session session = sf.openSession();
		 session.beginTransaction();
		 Person p = (Person)session.get(Person.class,1);
		 System.out.print(p.getXh());
		 System.out.print("jj"); 
		 session.getTransaction().commit();
		 session.close();
		 sf.close();
}
}
