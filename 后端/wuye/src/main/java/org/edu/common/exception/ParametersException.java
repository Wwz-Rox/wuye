package org.edu.common.exception;


/** <br>
 * 标题: 入参校验异常。<br>
 * 描述: <br>
*/
public class ParametersException extends ResourceException {

	private static final long serialVersionUID = -1;

	public ParametersException(String msg) {
		super(BaseRspConstants.RSP_CODE_PARAMETERS_ERROR, BaseRspConstants.RSP_DESC_PARAMETERS_ERROR + ": " + msg);
	}
}
