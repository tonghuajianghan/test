/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-10-13 下午1:06:27 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/** 
 * Unmarshaller
 *
 * @ClassName: Xml2ObjectDemo 
 * @author jh 
 * @date 2015-10-13 下午1:06:53 
 *  
 */
public class Xml2ObjectDemo {
	public static void main(String[] args) {
		try {
			File file = new File("D:\\file1.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
