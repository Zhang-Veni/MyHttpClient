package space.zdq.message;
public class TextMessage extends BaseMessage {
	private String Content;
	
	public TextMessage() {
		// TODO Auto-generated constructor stub
		MsgType="text";
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		this.Content = content;
	}
	public String getMsgType() {
		return MsgType;
	}
	public long getMsgId() {
		return MsgId;
	}
	public void setMsgId(long msgId) {
		MsgId = msgId;
	}
	public String toString()
	{
		return super.toString()+Content;
		
	}
}
