package fan.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import antlr.StringUtils;
import fan.constant.db.StateExist;
import fan.dao.AssetStateDao;

import fan.model.AssetState;
import fan.service.MainTainService;
import fan.support.JSONReturn;
import fan.utils.DateTimeUtil;

@Service
@Transactional(readOnly = true)
public class MainTainServiceImpl implements MainTainService{
	
	@Autowired
	private AssetStateDao assetStateDao;

	@Transactional
	public JSONReturn addAssetState(String name, String description, String acctName) {
		if(org.apache.commons.lang.StringUtils.isEmpty(name)){
			return JSONReturn.buildFailure("添加失败，状态名称不能为空！");
		}
		AssetState assetState = new AssetState(DateTimeUtil.getCurrentTime() , name, description, 
				StateExist.normal.getState(), acctName); 
		assetStateDao.save(assetState);
		return JSONReturn.buildSuccess("状态添加成功！");
	}

	
		//1.从数据库中将数据查询出来
		
	
		
	


	@Override
	public JSONReturn findSelectState() {
		
		return JSONReturn.buildSuccess(assetStateDao.findSelectState());
	}


	@Override
	public JSONReturn findAssetList(String search, int page, String acctName) {
		// TODO Auto-generated method stub
		return null;
	}





	
	
	

}
