package fan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fan.service.AssetService;
import fan.service.MainTainService;
import fan.support.JSONReturn;

@Controller
@RequestMapping(value = "/asset")
public class AssetController extends AbstractController {
	private static final long serialVersionUID = 6593482305728942711L;
	
	@Autowired
	private MainTainService maintainService;
	
	@Autowired
	private AssetService assetService;
	
	@ResponseBody
	@RequestMapping(value= "/addAsset")
	public JSONReturn addAsset(@RequestParam long stateID,@RequestParam long typeID, @RequestParam String name, @RequestParam String address, @RequestParam String warranty,
			@RequestParam String person,@RequestParam String college,@RequestParam String madetime,@RequestParam String description,HttpServletRequest request){
		return assetService.addAsset(stateID, typeID, name, address, warranty, person, college, madetime, description, acctName(request));
	}
	
	@ResponseBody
	@RequestMapping(value = "/findSelectState")
	public JSONReturn findSelectState(){
		return maintainService.findSelectState();
	}

}
