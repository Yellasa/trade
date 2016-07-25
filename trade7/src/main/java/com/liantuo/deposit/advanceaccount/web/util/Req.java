package com.liantuo.deposit.advanceaccount.web.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ebill.framework.res.JsonUtil;


public class Req implements java.io.Serializable
{

    private static final long serialVersionUID = -208351707959169444L;
    Logger LOGGER =LoggerFactory.getLogger(Req.class);
    /**
     * @Fields head : 报文头
     */

    /**
     * @Fields body : Json格式的请求主体
     */
    private String body;


    public String getBody()
    {
        return body;
    }

    public <T> T getBody(Class<T> c) throws Exception
    {
    	LOGGER.info("请求参数:{}",body);
        return JsonUtil.string2Object(body, c);
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public static Req genReq( Object body) throws Exception
    {
        Req req = new Req();
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerSubtypes(body.getClass());
        req.setBody(mapper.writeValueAsString(body));
        return req;
    }
}
