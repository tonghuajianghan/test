package jhtest;

/**
 * @author jh
 * @date 2014-10-9
 * @Description: 
 */
public class testR {
	
	/**
	 * @Description: 实现一个lite版的字符串替换函数
	 * @param str
	 * @param sub
	 * @param rep
	 * @return 
	 * @date 2014-10-9
	 *
	 */
	public char[] strreplace(char[] str, char[] sub, char[] rep){
		int i = 0;
		int j = 0;
		//模式匹配
		while(i<str.length && j< sub.length){
			if(str[i] == sub[j]){
				
				++i;
				++j;
				
				if(j >= sub.length){
					//多个sub处理
					int l = 0;
					for(int z = i - j;z < i;z++){						    
							str[z] = rep[l];
							l++;												
					}
					j = 0;
				}
			}else{
				i = i - j + 1;
				//j = 0;
			}
			
		}					
		return str;		
	}
	//测试
	public static void main(String[] args) {
		testR tr = new testR();
		char[] str = {'b','c','b','c','d'};
		char[] sub = {'b','c'};
		char[] rep = {'g','h'};
		char[] jh = tr.strreplace(str,sub,rep);
		for(int i = 0; i < jh.length ; i++){
			System.out.print(jh[i]);
		}
		
	}
}
