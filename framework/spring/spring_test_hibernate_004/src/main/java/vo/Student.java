package vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
//name -> DB table name ,catalog -> DB database name
@Table(name = "student", catalog = "hibernate")
public class Student implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8890616442214103653L;
	
	private int id;
	private String name;
	private int age;
	//                                    ������ɷ�ʽ��strategy = "increment"
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "age", unique = true, nullable = false)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
