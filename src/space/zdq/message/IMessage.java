package space.zdq.message;

public interface IMessage {
	public String getToUserName();
	public void   setToUserName(String toUserName) ;
	public String getFromUserName() ;
	public void   setFromUserName(String fromUserName);
	public long   getCreateTime() ;
	public void   setCreateTime(long createTime) ;
	public String getMsgType() ;
	public void   setMsgType(String msgType);
	public long   getMsgId() ;
	public void   setMsgId(long msgId);


}
