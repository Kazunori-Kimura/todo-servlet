package todo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 変換系メソッドのヘルパークラス
 *
 * @author kimurakazunori
 *
 */
public final class ConvertHelper {
	// ConvertHelperはstaticクラスなのでインスタンス化できない
	private ConvertHelper() {}

	/**
	 * Date -> String (yyyy-MM-dd)
	 *
	 * @param day
	 * @return
	 */
	public static String formatDate(Date day) {
		if (day == null) {
			return "";
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(day);
	}

	/**
	 * String (yyyy-MM-dd) -> Date
	 *
	 * @param raw
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String raw) throws ParseException {
		if (raw == null || raw == "") {
			return null;
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.parse(raw);
	}
}
