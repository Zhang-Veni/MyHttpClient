
/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package space.zdq.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Document;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.io.SAXReader;

import space.zdq.message.IMessage;
import space.zdq.message.TextMessage;
import space.zdq.message.request.ObjectToXML;
import space.zdq.message.response.XMLToObject;

public class WeChatHttpRequest {

    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
//        对文本的校验
       IMessage textMessage=new TextMessage();
       textMessage.setFromUserName("fromUserName");
       textMessage.setToUserName("toUserName");
       textMessage.setCreateTime(123456);
       textMessage.setMsgId(1);
       textMessage.setMsgType("text");
       String strxml=ObjectToXML.objectToXML(textMessage);
       System.out.println(strxml);
        
        
        try {
        	//需要添加需要认证的参数
            HttpGet httpGet = new HttpGet("http://localhost/WeChatTest/coreServlet");
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            // The underlying HTTP connection is still held by the response object
            // to allow the response content to be streamed directly from the network socket.
            // In order to ensure correct deallocation of system resources
            // the user MUST call CloseableHttpResponse#close() from a finally clause.
            // Please note that if response content is not fully consumed the underlying
            // connection cannot be safely re-used and will be shut down and discarded
            // by the connection manager.
            try {
                System.out.println(response1.getStatusLine());
                HttpEntity entity1 = response1.getEntity();
                // do something useful with the response body
                // and ensure it is fully consumed
                EntityUtils.consume(entity1);
            } finally {
                response1.close();
            }

            HttpPost httpPost = new HttpPost("http://localhost:80/WeChatTest/coreServlet");
            //List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            //username=vip&password=secret
         //   nvps.add(new BasicNameValuePair("username", "vip"));
         //   nvps.add(new BasicNameValuePair("password", "secret"));
            
            //httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            StringEntity myEntity = new StringEntity(strxml,"UTF-8");
            httpPost.setEntity(myEntity);
            CloseableHttpResponse response2 = httpclient.execute(httpPost);

            try {
                System.out.println(response2.getStatusLine());
                HttpEntity entity2 = response2.getEntity();
                // do something useful with the response body
                // and ensure it is fully consumed
              
                
                
                String result = IOUtils.toString(response2.getEntity().getContent(), "UTF-8");
                System.out.println(result);
            
                IMessage tm= (IMessage) XMLToObject.XMLToObjec(textMessage, result);
                System.out.println(tm);
                
                EntityUtils.consume(entity2);
            } finally {
                response2.close();
            }
        } finally {
            httpclient.close();
        }
    }

}
