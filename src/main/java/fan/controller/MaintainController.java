package fan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fan.service.AssetTypeService;
import fan.service.MainTainService;
import fan.support.JSONReturn;

@Controller
@RequestMapping(value = "/maintain")
public class MaintainController extends AbstractController{

	private static final long serialVersionUID = -4447135424104050055L;
	
	@Autowired
	private MainTainService mainTainService;
	
	@Autowired
	private AssetTypeService assetTypeService;
	
	@ResponseBody
	@RequestMapping(value = "add")
	public JSONReturn addAssetState(@RequestParam String name,@RequestParam String description, HttpServletRequest request){
		
		return mainTainService.addAssetState(name, description, acctName(request));
	}
	
	@ResponseBody
	@RequestMapping(value = "/findSelectType")
	public JSONReturn findSelectType(){
		return assetTypeService.findSelectType();
	}
	
	@ResponseBody
	@RequestMapping(value = "findAssetList")
	public JSONReturn findAssetStateList(@RequestParam String search,@RequestParam int page, HttpServletRequest request){
		return mainTainService.findAssetList(search, page, acctName(request));
	}

}
