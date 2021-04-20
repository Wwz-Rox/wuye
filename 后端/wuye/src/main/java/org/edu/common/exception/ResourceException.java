package org.edu.common.exception;

/** <br>
 * 标题: 业务异常，系统框架进行业务aop处理。<br>
 * 描述: <br>
 * 公司: www.tydic.com<br>
*/
public class ResourceException extends RuntimeException {

	public static final ThreadLocal<ResourceException> MQ_THREAD_EXCEPTION = new ThreadLocal<ResourceException>();
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
	 * @Deprecated public ResourceException(String msgId, String... args) { this.args = args; this.msgCode = msgId; }
	 */

	public ResourceException(String msgId, String message) {
		super(message);
		this.msgCode = msgId;
		MQ_THREAD_EXCEPTION.set(this);
	}

	public ResourceException(String msgId, String message, Throwable cause) {
		super(message, cause);
		this.args = new String[1];
		args[0] = message;
		this.msgCode = msgId;
		MQ_THREAD_EXCEPTION.set(this);
	}

}
