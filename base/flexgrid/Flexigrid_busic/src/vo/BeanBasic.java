package vo;

public class BeanBasic {
  private int id = 1;
  private String name = "hanhan";
  public int getId() {
	 return id;
  }
  public void setId(int id) {
	  this.id = id;
  }
  public String getName() {
	  return name;
  }
  public void setName(String name) {
	  this.name = name;
  } 
/*  public BeanBasic(){
	 System.out.println("这是benabasic的构造函数");
	 BeanBasic bb = new BeanBasic();
	 bb.setId(34);
	 bb.setName("danshen");
	 
  }*/
}
