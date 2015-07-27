import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import vo.Teacher;

public class testTeacher {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Teacher te = (Teacher) session.get(Teacher.class, 1);
		System.out.print(te.getName());
		System.out.print("jj");
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
