package org.edu.common.exception;

/** 公共返回操作码 */
public class BaseRspConstants {

	/** 系统成功 */
	public static final String RSP_CODE_SUCCESS				 = "0000";

	public static final String RSP_DESC_SUCCESS				 = "成功";

	/** 系统失败 */
	public static final String RSP_CODE_FAILUR				 = "8888";

	public static final String RSP_DESC_FAILUR				 = "失败";

	/** 入参校验失败 */
	public static final String RSP_CODE_PARAMETERS_ERROR	 = "7777";

	public static final String RSP_DESC_PARAMETERS_ERROR	 = "入参校验失败";

	/** DAO层数据库异常:10001 */
	public static final String RSP_CODE_DAO_ERROR			 = "10001";

	/** 原子服务异常:10002 */
	public static final String RSP_CODE_ATOM_SERVICE_ERROR	 = "10002";

	/** 业务服务异常:10003 */
	public static final String RSP_CODE_BUSI_SERVICE_ERROR	 = "10003";

	/** 组合服务异常:10004 */
	public static final String RSP_CODE_INTFCE_SERVICE_ERROR = "10004";

	/** 调用第三方接口出错:10005 */
	public static final String RSP_CODE_CALL_THIRD_SERVICE	 = "10005";

	/** 响应数据空:20001 */
	public static final String RSP_CODE_DATA_NULL			 = "20001";

}
