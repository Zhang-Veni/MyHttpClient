package space.zdq.message.response;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.commons.io.IOUtils;
import space.zdq.message.IMessage;

public class XMLToObject {

	public XMLToObject() {
		// TODO Auto-generated constructor stub
	}
	public static Object XMLToObjec(IMessage msg,String xml)
	{
		XStream xs=new XStream(new DomDriver());
		xs.alias("xml",msg.getClass());
		System.out.println(msg.getClass());
		return xs.fromXML(xml);
	
	}
	
}
