/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-10-13 上午10:43:06 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
 
/** 
 *  
 * 	java文件转换成xml文件
 * 
 * 	Marshal
 *
 * @ClassName: Object2XmlDemo 
 * @author jh 
 * @date 2015-10-13 上午10:50:23 
 *  
 */
public class Object2XmlDemo {
	public static void main(String[] args) {

		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("suo");
		customer.setAge(29);

		try {
			File file = new File("d:\\file1.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
