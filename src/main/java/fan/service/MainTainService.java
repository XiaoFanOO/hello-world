package fan.service;

import fan.support.JSONReturn;

public abstract interface MainTainService {

	/**
	 * 新曾状态
	 * @param name
	 * @param description
	 * @param acctName
	 * @return
	 */
	public abstract JSONReturn addAssetState(String name, String description, String acctName);

	
	

	/**
	 * 获取数据列表的下拉菜单
	 * @return
	 */
	public abstract JSONReturn findSelectState();
	
	/**
	 * 获取资产数据列表
	 * 
	 * @param search
	 * @param page
	 * @param acctName
	 * @return
	 */
	public abstract JSONReturn findAssetList(String search, int page, String acctName);





	

	
}
