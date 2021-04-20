package org.edu.common.exception;

/** @Description: 业务校验失败 */
public class BusinessException extends RuntimeException {

	public static final ThreadLocal<BusinessException> MQ_THREAD_EXCEPTION = new ThreadLocal<BusinessException>();
	private static final long						   serialVersionUID	   = -1814155355569144196L;

	/** 操作编码 */
	private String									   msgCode;

	/** 操作码对应的关键信息 */
	private String[]								   args;

	/** 返回 操作编码
	 * 
	 * @return 操作编码 */
	public String getMsgCode() {
		return msgCode;
	}

	/** 返回 操作码对应的关键信息
	 * 
	 * @return 操作码对应的关键信息 */
	public String[] getArgs() {
		return args;
	}

	public String getMsgInfo() {
		return this.getMessage();
	}

	/** 需要在通常情况下需要输入异常代码，及其所需的相关参数。
	 * 
	 * @param msgId
	 * @param args */
	/*
	 * @Deprecated public BusinessException(String msgId, String... args) { this.args = args; this.msgCode = msgId; }
	 */

	public BusinessException(String msgId, String message) {
		super(message);
		this.msgCode = msgId;
		MQ_THREAD_EXCEPTION.set(this);
	}

	public BusinessException(String msgId, String message, Throwable cause) {
		super(message, cause);
		this.args = new String[1];
		args[0] = message;
		this.msgCode = msgId;
		MQ_THREAD_EXCEPTION.set(this);
	}
}
