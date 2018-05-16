package fan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import fan.constant.db.StateExist;
import fan.dao.AssetDao;
import fan.model.Asset;
import fan.service.AssetService;
import fan.support.JSONReturn;
import fan.utils.DateTimeUtil;

@Service
@Transactional(readOnly = true)
public class AssetServiceImpl implements AssetService{
	
	@Autowired
	private AssetDao assetDao;

	

	@Transactional
	public JSONReturn addAsset(long stateID, long typeID, String name, String address, String warranty, String person,
			String college, String madetime, String description, String acctName) {
		Asset asset = new Asset(DateTimeUtil.getCurrentTime(), warranty, StateExist.normal.getState(), name, stateID, typeID, 
				address, person, acctName, college, madetime, description, null, null);
		System.out.println("***************");
		System.out.println(asset);
		assetDao.save(asset);
		return JSONReturn.buildSuccess("类型添加成功！");
	}
	
	

}
