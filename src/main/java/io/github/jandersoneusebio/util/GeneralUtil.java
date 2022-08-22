package io.github.jandersoneusebio.util;

import java.util.List;
import java.util.Objects;

public class GeneralUtil {

	public static boolean isNullOrEmpty(List<?> list) {
		return Objects.isNull(list) || list.isEmpty();
	}
	
	public static boolean isNullOrEmpty(String str) {
		return Objects.isNull(str) || str.trim().isEmpty();
	}
	
}
