package com.hyul.model;

public class SajuCalendar {
	/**
	 * 
	 * 데이터 포맷 : XML
	 * End Point : http://apis.data.go.kr/B090041/openapi/service/LrsrCldInfoService
	 * 일반 인증키 : R5uuB2ijZC1E0kOdgo%2B6NnhkfIFJ3EQwGoF7TFJuJHX0AbfPSTEzSQGEVW3qcdpQlFJ0X2GPJZ2UwHTb2reH4w%3D%3D
	 * (Encoding)
	 * 일반 인증키 : R5uuB2ijZC1E0kOdgo+6NnhkfIFJ3EQwGoF7TFJuJHX0AbfPSTEzSQGEVW3qcdpQlFJ0X2GPJZ2UwHTb2reH4w==
	 * (Decoding)
	 * 
	 * 1.양력일정보 조회 명세 (음력 입력 시 양력으로 날짜 변환이 필요) 
     * <response>
	 * <header>
	 * <resultCode>00</resultCode>
	 * <resultMsg>NORMAL SERVICE.</resultMsg>
	 * </header>
	 * <body>
	 * <items>
	 * <item>
	 * <lunDay>22</lunDay>
	 * <lunIljin>계미(癸未)</lunIljin>
	 * <lunLeapmonth>평</lunLeapmonth>
	 * <lunMonth>09</lunMonth>
	 * <lunNday>30</lunNday>
	 * <lunSecha>을미(乙未)</lunSecha>
	 * <lunWolgeon>병술(丙戌)</lunWolgeon>
	 * <lunYear>2015</lunYear>
	 * <solDay>03</solDay>
	 * <solJd>2457330</solJd>
	 * <solLeapyear>평</solLeapyear>
	 * <solMonth>11</solMonth>
	 * <solWeek>화</solWeek>
	 * <solYear>2015</solYear>
	 * </item>
	 * </items>
	 * <numOfRows>10</numOfRows>
	 * <pageNo>1</pageNo>
	 * <totalCount>1</totalCount>
	 * </body>
	 * </response>
     * 
     * 평균응답시간 : 0.5ms
     * 초당 최대 트랜잭션 : 30 tps
     * 일일 트래픽 : 10000 (27년 = 9855일)
     * 1900 ~ 2037년 구축 시 1주일 (하루 10분)
     * 
     * http://apis.data.go.kr/B090041/openapi/service/LrsrCldInfoService/getSolCalInfo?
     * lunYear=2015
     * &lunMonth=01
     * &lunDay=01
     * &ServiceKey=서비스키
     * 
	 *	https://apis.data.go.kr/B090041/openapi/service/LrsrCldInfoService/getSolCalInfo?
	 * serviceKey=R5uuB2ijZC1E0kOdgo%2B6NnhkfIFJ3EQwGoF7TFJuJHX0AbfPSTEzSQGEVW3qcdpQlFJ0X2GPJZ2UwHTb2reH4w%3D%3D
	 * &lunYear=2015
	 * &lunMonth=09
	 * &lunDay=22
     * 
     * ## data를 get 요청해서 받아온 다음에 DB를 구축한다.
     *
     * ## 연주, 월주, 일주를 구하는 조정 알고리즘 적용 여부
     * 절입조정
     * 위의 양/음력 날짜에 대한 간지로 끝나는 게 아니라,
     * 전통명리학에 따라 사주를 세우게 된다면 동경 135도 절기력을 기준으로 절입조정은 필수
     * 
     * 절기 Data
     * https://astro.kasi.re.kr/life/post/calendarData
     * 
     * 서머타임 (적용 O)
     * 서머타임은 과거 한국정부에서 주로 여름철에 표준시간을 가감해 당겨쓰는 제도
     * 
     * 야자시/조자시 (적용 X)
     * 자시를 해당일의 자시를 두개로 쪼개서 (야자시 / 오후 11시 30분 - 오전12시 30분), 
     * (조자시 / 오전 12시 30분 - 오전 1시 30분) 두 가지로 나눠 
     * 야자시인 경우 해당일, 조자시인경우 다음날로 판단하여 사주팔자를 산출하는 방식
     * 
     * ## 조정을 거쳐 사주를 구했으면 그 안에서 오행을 추출
     * 
     * 사주는 양력을 기준으로 24절기가 나뉘고, 절기에 따라 사주팔자가 정해짐 
     * 때문에 달력은 음력을 양력으로 변환하기 위해 필요하고 
     * 천문연구원의 절기 인입 시기에 따라 절기를 구분하고, 
     * 절기에 따른 양력일자로 사주 팔자를 구해야 함
     * 
	 * 표준시 : E135 한국.일본
	 * 경 도 :	E126.58
	 * (출생지 서울)
	 * 경도조정 :	-32분
	 * 써머타임 :	해당없음.
	 * 절입조정 :	해당없음.
	 * 야자시 :	해당없음.
	 * 균시차조정 :	-11분
	 * 기준시각 :	1991-01-24 19:23
	 * 
	 * 동경 127도 30분 사용시기
	 * 1908.02.01. ~ 1911.12.31.
	 * 1954.03.21 ~ 1961.08.09.
	 * 그 외는 모두 동경 135도 사용
	 * 써머타임 실시시기
	 * 1948.06.01. 00:00 ~ 1948.09.13. 00:00
	 * 1949.04.03. 00:00 ~ 1949.09.11. 00:00
	 * 1950.04.01. 00:00 ~ 1950.09.10. 00:00
	 * 1951.05.06. 00:00 ~ 1951.09.09. 00:00
	 * 1955.05.05. 00:00 ~ 1955.09.09. 00:00
	 * 1956.05.20. 00:00 ~ 1956.09.30. 00:00
	 * 1957.05.05. 00:00 ~ 1957.09.22. 00:00
	 * 1958.05.04. 00:00 ~ 1958.09.21. 00:00
	 * 1959.05.03. 00:00 ~ 1959.09.20. 00:00
	 * 1960.05.01. 00:00 ~ 1960.09.18. 00:00
	 * 1987.05.10. 02:00 ~ 1987.10.11. 03:00
	 * 1988.05.08. 02:00 ~ 1988.10.09. 03:00
	 * 
	 * 절기달력(썬샤인어닝)
	 * http://xn--vj1b09xs1b16ct2c.com/share/calender/24SolarTerms.php?y=1900
	 * 
	 * 천문연구원 자료(아... 한자...)
	 * https://astro.kasi.re.kr/almanac/pageView/26?file=/file/astro_almanac_pdf/20231023135218580.pdf
	 * 
	 * 음력은 양력으로 바꾸고 (음력 > 양력 전환)
	 * 양력은 절기 달력으로 바꾸고 (양력 > 절기 전환)
	 * 절기를 기준으로 사주 구하고
	 * 사주를 바탕으로 오행을 구하면 된다
	 * 
	 */
	
	public void getCalendarData() {
		
	}
	
	
	
}
