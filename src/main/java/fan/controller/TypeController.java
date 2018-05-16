package fan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fan.service.AssetTypeService;
import fan.support.JSONReturn;

@Controller
@RequestMapping(value = "/type")
public class TypeController extends AbstractController{
	private static final long serialVersionUID = 9172951302440355149L;

	@Autowired
	private AssetTypeService assetTypeService;
	
	@ResponseBody
	@RequestMapping(value = "/addType")
	public JSONReturn addAssetType(@RequestParam String name,@RequestParam String description, HttpServletRequest request){
		
		return assetTypeService.addAssetType(name, description, acctName(request));
	}
	
}
