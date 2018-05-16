package fan.service;

import fan.support.JSONReturn;

public abstract interface AssetTypeService {

	
	public abstract JSONReturn addAssetType(String name, String description, String acctName);

	public abstract JSONReturn findSelectType();

	
	
	

}
