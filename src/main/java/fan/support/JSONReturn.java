package fan.support;

import java.io.Serializable;

public class JSONReturn implements Serializable{

	
	private static final long serialVersionUID = 8270616572765517175L;

	/**JSON头*/
	private boolean head;
	
	/**JSON主体*/
	private Object body;
	public boolean isHead() {
		return head;
	}
	public void setHead(boolean head) {
		this.head = head;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	
	public JSONReturn(boolean head, Object body){
		super();
		this.head = head;
		this.body = body;
		
	}
	
	public static final boolean HEAD_SUCCESS = true;
	public static final boolean HEAD_FAILURE = false;
	
	public static JSONReturn build(boolean head, Object body){
		return new JSONReturn(head, body);
	}
	
	public static JSONReturn buildSuccess(Object body) {
		return build(HEAD_SUCCESS, body);
		
	}
	public static JSONReturn buildFailure(Object body){
		return build(HEAD_FAILURE, body);
	}
	public static JSONReturn buildSuccessWithEmptyBody(Object body) {
		return build(HEAD_SUCCESS, "");
	}
	public static JSONReturn buildFailureWithEmptyBody(Object body) {
		return build(HEAD_FAILURE, "");
	}
	
	@Override
	public String toString() {
		return "JSONReturn [head=" + head + ", body=" + body + "]";
	}
	
}
