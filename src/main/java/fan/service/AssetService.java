package fan.service;

import fan.support.JSONReturn;

public abstract interface AssetService {

	public abstract JSONReturn addAsset(long stateID, long typeID, String name, 
			String address, String warranty, String person, String college, String madetime,
			String description, String acctName);

}
