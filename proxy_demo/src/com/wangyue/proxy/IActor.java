package com.wangyue.proxy;

/**
 * 经纪公司对签约艺人的标准
 * 
 * @author WY
 *
 */
public interface IActor {
	
	//基本的表演 @param money
		public void basicAct(float money);
		
		//危险的表演
		public void dangerAct(float money);

}
