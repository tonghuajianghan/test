/*import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;
import vo.*;
import dao.inter.*;

public class test {
	public static void main(String []args){
		System.out.println("hello");
		PersionDao pd=DaoFactory.getPaperDao();
		List<Paper> list=pd.queryPaperByPage(10);
		for(int i=0;i<list.size();i++)
		{
			System.out.println("id:"+list.get(i).getId()+"  name:"+list.get(i).getLwtm());
		}
		AuthorDao ad=DaoFactory.getAuthorDao();
		Author au=new Author();
		Paper p=new Paper();
		p.setLwtm("����3");
		pd.savePaper(p);
		
		}
		List<Paper> list=pd.queryPaperByProperty("lwtm", "����");
		Iterator<Paper> it=list.iterator();
		Paper p=new Paper();
		while(it.hasNext()){
			p=it.next();
			System.out.println("��ţ�"+p.getId()+"   ���ƣ�"+p.getLwtm());
		}
		
		au.setXm("����");
		au.setPaper(p);
		ad.saveAuthor(au);
	}
}
*/