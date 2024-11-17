package com.hyul.model;

import java.util.Map;

public class SajuService {
	SajuDAO sajuDAO; // 
	
	public SajuService() {
		sajuDAO = SajuDAO.getInstance();
	}
	
	
	Map<String, String> userWuxing;

	/**
	 * 사용자로부터 '생년월일시'를 입력 받는다.
	 * 사주 달력으로 천간과 지지를 구한다.
	 * 천간과 지지에 담긴 오행의 갯수를 구한다.
	 */
	public Map<String, String> getWuxing(Map<String, String[]> _userInputData) {
		
		return userWuxing;
	}
	
	/**
	 * 오행의 갯수로 오행 상태를 구한다.
	 * 수, 금, 지, 화, 목, 토의 갯수에 따라 균형, 부족, 과다 상태를 도출할 수 있다.
	 */
	public void getWuxingState(Map<String, String> _userWuxing) {
		
	}
	
	/**
	 * 오행 상태에 따라 적절한 혈을 DB에서 구한다.
	 * 예시) 수가 부족하면 방광이 안 좋으므로 CV3 중극 (中極), LI9 상렴 (上廉) 등을 추천
	 */
	public void getRecommedableHyul(String... args) {
		String queryString = "SELECT * FROM hyulMap WHERE ";
		
		// hyulEffect LIKE '%방광%' AND hyulEffect LIKE '%신장%';
		for (int i = 0; i < args.length; i++) { // ? = '%args[i]%'
			queryString += "hyulEffect LIKE '%"+args[i]+ "%' ";
			if (i != 0) {
				queryString += "AND ";
			}
		}
		
		// args의 length에 따라 queryStringd 최종적으로 아래와 같아짐
		// "SELECT * FROM hyulMap WHERE hyulEffect LIKE '%args[i]%" 혹은
		// "SELECT * FROM hyulMap WHERE hyulEffect LIKE '%args[i]%' AND ..."
		// sajuDAO를 이용해서 DB로부터 데이터를 가져옴
		// return
	}
	
	
}
