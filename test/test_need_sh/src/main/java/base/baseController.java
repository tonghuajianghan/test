/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-10-16 上午11:11:18 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * 基础测试
 *
 * @ClassName: baseController 
 * @author jh 
 * @date 2015-10-16 上午11:16:08 
 *  
 */
@Controller
public class baseController {
	@RequestMapping(value = "/base")
	public String base(){
		return "index";
	}
}
