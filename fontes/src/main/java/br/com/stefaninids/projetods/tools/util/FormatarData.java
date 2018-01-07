package br.com.stefaninids.projetods.tools.util;

import java.sql.Timestamp;
import java.util.Calendar;

public class FormatarData {
	public static Timestamp toTimestamp(String dataStr, int hora, int minuto, int segundo){
		Calendar data = Calendar.getInstance();
		
		data.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dataStr.substring(8, 10)));
		data.set(Calendar.MONTH, Integer.parseInt(dataStr.substring(5, 7)) - 1);
		data.set(Calendar.YEAR, Integer.parseInt(dataStr.substring(0, 4)));
		data.set(Calendar.HOUR_OF_DAY, hora);
		data.set(Calendar.MINUTE, minuto);
		data.set(Calendar.SECOND, segundo);
		
		return new Timestamp(data.getTime().getTime());
	}
}
