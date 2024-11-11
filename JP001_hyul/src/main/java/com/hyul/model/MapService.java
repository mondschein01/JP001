package com.hyul.model;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class MapService {
	/*
	 * 카테고리와 혈자리 이름 두개를 넘겨 받아서 해당하는 정보를 넘겨 줌
	 * */
	public JSONObject readHyulMapData(String _category, String _hyulName) {
		MapDAO mapDAO = MapDAO.getInstance();
		MapDTO dto_hyul = mapDAO.selHyul(_category, _hyulName);
		
		String category = dto_hyul.getCategory();
		String hyulName = dto_hyul.getHyulName();
		String hyulPos = dto_hyul.getHyulPos();
		String hyulSelect = dto_hyul.getHyulSelect();
		String wayToChim = dto_hyul.getWayToChim();
		String hyulEffect = dto_hyul.getHyulEffect();
		String imgPath = dto_hyul.getImgPath();
		
		Map<String, String> vMap = new HashMap<>();
		vMap.put("category", category);
		vMap.put("hyulName", hyulName);
		vMap.put("hyulPos", hyulPos);
		vMap.put("hyulSelect", hyulSelect);
		vMap.put("wayToChim", wayToChim);
		vMap.put("hyulEffect", hyulEffect);
		vMap.put("imgPath", imgPath);
		
		JSONObject jo = new JSONObject(vMap);

		return jo;
	}
	
	
}
