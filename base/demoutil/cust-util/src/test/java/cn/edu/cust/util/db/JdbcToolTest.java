package cn.edu.cust.util.db;


public class JdbcToolTest extends JdbcTool {
	
	void test(){
		System.out.println(Thread.currentThread().getId() + ":jt:" + JdbcTool.getJdbcTemplate().hashCode());
		//System.out.println(Thread.currentThread().getId() + ":tt:" + JdbcTool.getTT().hashCode());
	}

	static Thread thread1 = new Thread(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			new JdbcToolTest().test();
			new JdbcToolTest().test();
		}
		
	};
	
	static Thread thread2 = new Thread(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			new JdbcToolTest().test();
			new JdbcToolTest().test();
		}
		
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		thread1.start();
		thread2.start();
	}

}
