package com.hyul.model;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class MapService {
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


/*

CREATE TABLE hyulEffect AS
SELECT DISTINCT
    TRIM(SUBSTR(HYULEFFECT, start_pos, end_pos - start_pos)) AS HYULEFFECT
FROM (
    SELECT 
        HYULEFFECT,
        INSTR(HYULEFFECT || ',', ',', 1, LEVEL) + 1 AS start_pos,
        INSTR(HYULEFFECT || ',', ',', 1, LEVEL + 1) AS end_pos
    FROM 
        hyulMap
    CONNECT BY 
        PRIOR HYULNAME = HYULNAME
        AND LEVEL <= LENGTH(HYULEFFECT) - LENGTH(REPLACE(HYULEFFECT, ',', '')) + 1
        AND PRIOR SYS_GUID() IS NOT NULL
)
WHERE end_pos > start_pos;

SET HEADING OFF;
SET FEEDBACK OFF;
SET COLSEP ',';
SET PAGESIZE 0;
SET LINESIZE 1000;
SPOOL output.csv;

SELECT DISTINCT
    TRIM(SUBSTR(HYULEFFECT, start_pos, end_pos - start_pos)) AS HYULEFFECT
FROM (
    SELECT 
        HYULEFFECT,
        INSTR(HYULEFFECT || ',', ',', 1, LEVEL) + 1 AS start_pos,
        INSTR(HYULEFFECT || ',', ',', 1, LEVEL + 1) AS end_pos
    FROM 
        hyulMap
    CONNECT BY 
        PRIOR HYULNAME = HYULNAME
        AND LEVEL <= LENGTH(HYULEFFECT) - LENGTH(REPLACE(HYULEFFECT, ',', '')) + 1
        AND PRIOR SYS_GUID() IS NOT NULL
)
WHERE end_pos > start_pos;

SPOOL OFF;
 * */
