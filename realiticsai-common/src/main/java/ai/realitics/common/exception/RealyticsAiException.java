package ai.realitics.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class RealyticsAiException extends Exception {
	private static final long serialVersionUID = -543671475416882384L;

	protected List<MessageCode> messageCodes;

	public RealyticsAiException() {
		super();
		this.messageCodes = new ArrayList<MessageCode>();
	}

	public RealyticsAiException(MessageCode messageCode) {
		super();
		this.messageCodes = new ArrayList<MessageCode>();
		this.messageCodes.add(messageCode);
	}

	public RealyticsAiException(List<MessageCode> messageCodes) {
		super();
		this.messageCodes = new ArrayList<MessageCode>(messageCodes);
	}

	public RealyticsAiException(String message) {
		super(message);
		this.messageCodes = new ArrayList<MessageCode>();
	}

	public RealyticsAiException(String message, MessageCode messageCode) {
		super(message);
		this.messageCodes = new ArrayList<MessageCode>();
		this.messageCodes.add(messageCode);
	}

	public RealyticsAiException(String message, List<MessageCode> messageCodes) {
		super(message);
		this.messageCodes = new ArrayList<MessageCode>(messageCodes);
	}

	public RealyticsAiException(Throwable cause) {
		super(cause);
		this.messageCodes = new ArrayList<MessageCode>();
	}

	public RealyticsAiException(Throwable cause, MessageCode messageCode) {
		super(cause);
		this.messageCodes = new ArrayList<MessageCode>();
		this.messageCodes.add(messageCode);
	}

	public RealyticsAiException(Throwable cause, List<MessageCode> messageCodes) {
		super(cause);
		this.messageCodes = new ArrayList<MessageCode>(messageCodes);
	}

	public RealyticsAiException(String message, Throwable cause) {
		super(message, cause);
		this.messageCodes = new ArrayList<MessageCode>();
	}

	public RealyticsAiException(String message, Throwable cause, MessageCode messageCode) {
		super(message, cause);
		this.messageCodes = new ArrayList<MessageCode>();
		this.messageCodes.add(messageCode);
	}

	public RealyticsAiException(String message, Throwable cause, List<MessageCode> messageCodes) {
		super(message, cause);
		this.messageCodes = new ArrayList<MessageCode>(messageCodes);
	}

	public List<MessageCode> getMessageCodes() {
		return messageCodes;
	}

	public void setMessageCodes(List<MessageCode> messageCodes) {
		this.messageCodes = messageCodes;
	}

	public String toStackTrace() {
		final StringWriter sw = new StringWriter();
		final PrintWriter pw = new PrintWriter(sw, true);
		this.printStackTrace(pw);

		return sw.getBuffer().toString();
	}

}
