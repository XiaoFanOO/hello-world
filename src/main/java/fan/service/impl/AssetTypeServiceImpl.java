package fan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fan.constant.db.StateExist;
import fan.dao.AssetTypeDao;
import fan.dto.SelectDto;
import fan.dto.SelectTypeDto;

import fan.model.AssetState;
import fan.model.AssetStype;
import fan.service.AssetTypeService;
import fan.support.JSONReturn;
import fan.utils.DateTimeUtil;

@Service
@Transactional(readOnly = true)
public class AssetTypeServiceImpl implements AssetTypeService{

	@Autowired
	private AssetTypeDao assetTypeDao;

	@Transactional
	public JSONReturn addAssetType(String name, String description, String acctName) {
		if(org.apache.commons.lang.StringUtils.isEmpty(name)){
			return JSONReturn.buildFailure("添加失败，类型名称不能为空！");
		}
		AssetStype assetStype = new AssetStype(name, description, StateExist.normal.getState(), acctName);
		assetTypeDao.save(assetStype);
		return JSONReturn.buildSuccess("类型添加成功！");
	}

	@Override
	public JSONReturn findSelectType() {
		
		return JSONReturn.buildSuccess(assetTypeDao.findSelectType());
		
	}

	
	
}
