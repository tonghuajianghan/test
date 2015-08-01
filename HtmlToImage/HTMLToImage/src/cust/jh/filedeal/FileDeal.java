/*------------------------------------------------------------------------- 
 * 版权所有：姜晗
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-4-5 上午07:48:28 
 * 版本号：v1.0 
 * 本类主要用途描述： 处理文件类
 * 
-------------------------------------------------------------------------*/
package cust.jh.filedeal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDeal {

	/**
	 * @Title: readTxtFile
	 * @Author: jianghan
	 * @Description: TODO 获取txt文件内容
	 * @param filePath
	 * @return string
	 * 
	 */
	public String txt2String(String filePath){
		File file=new File(filePath);
		if(!file.isFile()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        String result = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result = result + "\n" +s;
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    

	/**
	 * @Title: dealFile
	 * @Author: jianghan
	 * @Description: TODO 通过截取string获得url，将txt中的每个url存储到list中
	 * @param lineTxt
	 * @return
	 * 
	 */
	public List<String> getUrlByString(String lineTxt) {
		List<String> list = new ArrayList<String>();
		String url = null;
		
		//处理获取字符串
		FileDeal filedeal = new FileDeal();
		lineTxt = filedeal.replaceBlank(lineTxt);
		lineTxt = lineTxt.trim();
		
		//获取list
		while (lineTxt != null && lineTxt != "" && lineTxt.length() != 0 ) {
			int j = lineTxt.indexOf(";");
			
				url = lineTxt.substring(0, j);
				if(lineTxt.length() != 0){
					lineTxt = lineTxt.substring(j + 1,lineTxt.length());
				}	
				//System.out.println(url);
				//System.out.println(lineTxt);
				list.add(url);
		}
		/*for(int i = 0; i < list.size(); i++){	
			//System.out.println(list.get(i));
		}*/
		return list;
	}
	/** 
	* @Title: reloadFile 
	* @Author: jianghan
	* @Description: TODO 新建生成文件文件记录文件
	* @param imgPath
	*    
	*/
	public void reloadFile(String imgPath){
		File errorFile = new File(imgPath,"error.txt");
		File rightFile = new File(imgPath,"right.txt");
		try {
			errorFile.createNewFile();
			rightFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/** 
	* @Title: replaceBlank 
	* @Author: jianghan
	* @Description: TODO 处理字符串
	* @param str
	* @return
	*    
	*/
	private String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
	public void clearFile(String filePath){
		File f = new File(filePath);
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			fw.write("");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
