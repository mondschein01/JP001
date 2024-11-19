package com.hyul.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class KeywordService {
	KeywordDAO keywordDAO = KeywordDAO.getInstance(); 

	// 추천 키워드 뽑기
	public JSONObject getRecomKeyword() {
		
		String[] keywordAry = keywordDAO.getHyulKeyword();
		
		Map<String, String[]> tmpMap = new HashMap<>();
		tmpMap.put("recommKeyword", keywordAry);
		
		JSONObject jo = new JSONObject(tmpMap);
		
//		for (int i = 0; i < keywordAry.length; i++) {
//			System.out.println(keywordAry[i]);
//		}
		
		return jo;
	}
	
	String category, hyulName, hyulPos, hyulSelect, wayToChim, hyulEffect, imgPath;
	
	// 검색 결과 list_MapDTO로 얻기
	public JSONArray getQueryResult(String q){
		ArrayList<MapDTO> list_mapDTO = keywordDAO.getHyulEffectQuery(q);
		
		JSONArray joAry = new JSONArray();
		
		for (int i = 0; i < list_mapDTO.size(); i++) {
			JSONObject jo = new JSONObject();
			
			category = list_mapDTO.get(i).getCategory();
			hyulName = list_mapDTO.get(i).getHyulName();
			hyulPos = list_mapDTO.get(i).getHyulPos();
			hyulSelect = list_mapDTO.get(i).getHyulSelect();
			wayToChim = list_mapDTO.get(i).getWayToChim();
			hyulEffect = 	list_mapDTO.get(i).getHyulEffect();
			imgPath = list_mapDTO.get(i).getImgPath();
			
			jo.put("category", category);
			jo.put("hyulName", hyulName);
			jo.put("hyulPos", hyulPos);
			jo.put("hyulSelect", hyulSelect);
			jo.put("wayToChim", wayToChim);
			jo.put("hyulEffect", hyulEffect);
			jo.put("imgPath", imgPath);
			
			joAry.add(i, jo);
		}
		
		return joAry;
	}
}
 