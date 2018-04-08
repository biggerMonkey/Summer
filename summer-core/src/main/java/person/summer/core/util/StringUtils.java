package person.summer.core.util;


/**
 * @author huangwenjun
 * @Date 2018年4月3日
 */
public class StringUtils {

    public static boolean isEmpty(String str) {
        return (str == null || "".equals(str));
    }

    public static String arrayToCommaDelimitedString(Object[] arr) {
        return arrayToDelimitedString(arr, ",");
    }

    public static String arrayToDelimitedString(Object[] arr, String delim) {
        if (ObjectUtils.isEmpty(arr)) {
            return "";
        }
        if (arr.length == 1) {
            return ObjectUtils.nullSafeToString(arr[0]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(delim);
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
