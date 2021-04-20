package org.edu.util;

public class StringUtil {
	/**
	 *  把对象转换成字符串，如果参数是null就返回null
	 * @param obj
	 * @return
	 */
   public static String valueOf(Object obj) {
	   return (obj==null)?null:obj.toString();
   }
   /**
	 * 把对象转换成字符串，如果参数是null就返回空串
	 * @param obj
	 * @return
	 */
  public static String emptyOf(Object obj) {
	   return (obj==null)?"":obj.toString();
  }
}
