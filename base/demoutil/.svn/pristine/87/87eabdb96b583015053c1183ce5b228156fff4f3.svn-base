package cn.edu.cust.util.action;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import cn.edu.cust.util.db.DAOTemplate;
import cn.edu.cust.util.db.Worker;

public abstract class ActionTemplate<T, I extends Serializable> extends CommonAction {
	
	
	protected DAOTemplate<T> dao;
	
	protected I[] ids;
	
	protected T obj;
	
	protected ArrayList<T> objs;
	
	protected void checkInput(){
		//
	}
	
	public ArrayList<T> getObjs() {
		return objs;
	}
	
	public String load(){
		return work(new Worker(){

			public void doWork() {
				// TODO Auto-generated method stub
				if(log.isInfoEnabled())
					log.info("load: ");
				obj = dao.load(jt, ids[0]);
				if(obj == null){
					throw new BusinessException("您所选择的对象不存在！");
				}
			}
			
		});
	}

	public String list(){
		return work(new Worker(){

			public void doWork() {
				// TODO Auto-generated method stub
				objs = dao.getAll(jt);
			}
			
		});
	}
	
	public String add(){
		return work(new TransactionCallback<Object>(){

			public Object doInTransaction(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				checkInput();
				dao.insert(jt, obj);
				return null;
			}

		});
	}
	
	public String del(){
		return work(new TransactionCallback<Object>(){

			public Object doInTransaction(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				if(ids != null){
					for (int i = ids.length - 1; i >= 0; i--) {
						dao.delete(jt, ids[i]);
					}
				}
				return null;
			}
			
		});
	}
	
	public String update(){
		return work(new TransactionCallback<Object>(){

			public Object doInTransaction(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				checkInput();
				dao.update(jt, obj);
				return null;
			}

		});
	}
}
