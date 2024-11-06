package com.hyul.model;

public class Service_hyul {
	// Controller_hyul에서부터 매개변수 2개가 넘어옴
	// category, hyulName
//	public static void main(String[] args) {
//		Service_hyul obj = new Service_hyul();
//		
//		obj.getHyulMapData("LU", "LU11");
//	}
	
	public void getHyulMapData(String _category, String _hyulName) {
		DAO_hyul dao_hyul = new DAO_hyul(); 
		DTO_hyul dto_hyul = dao_hyul.selHyul(_category, _hyulName);
		
		String category = dto_hyul.getCategory();
		String hyulName = dto_hyul.getHyulName();
		String hyulPos = dto_hyul.getHyulPos();
		String hyulSelect = dto_hyul.getHyulSelect();
		String wayToChim = dto_hyul.getWayToChim();
		String hyulEffect = dto_hyul.getHyulEffect();
		String imaPath = dto_hyul.getImgPath();
		
//		System.out.println(category + hyulName + hyulPos + hyulSelect + wayToChim + hyulEffect + imaPath);
//		System.out.println(category);
//		System.out.println(hyulName);
//		System.out.println(hyulPos);
//		System.out.println(hyulSelect);
//		System.out.println(wayToChim);
//		System.out.println(hyulEffect);
//		System.out.println(imaPath);
	}
	
	
}
