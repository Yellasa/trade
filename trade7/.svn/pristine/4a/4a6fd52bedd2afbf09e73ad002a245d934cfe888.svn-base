package com.liantuo.deposit.advanceaccount.web.util;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ebill.framework.http.RequestUtil;
import com.ebill.framework.log.LogUtil;
import com.ebill.framework.res.JsonUtil;

public class ReqUtil
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ReqUtil.class);

    /**
     * 获得Req对象
     * 
     * @param request
     * @return
     */
    public static Req getReqFromRequest(HttpServletRequest request)
    {
        try
        {
            String para = RequestUtil.getString(request, "para");
            LogUtil.info("账务系统接收请求！para:{}", para);
            return JsonUtil.string2Object(RequestUtil.getString(request, "para"), Req.class);
        }
        catch (Exception e)
        {
            LOGGER.error("请求参数解析异常！请求字符串{}", RequestUtil.getString(request, "para"), e);
        }
        return null;
    }

    /**
     * 获得Req对象
     * 
     * @param request
     * @return
     */
    public static Req getReqByJson(String reqJsonStr)
    {
        try
        {
            return JsonUtil.string2Object(reqJsonStr, Req.class);
        }
        catch (Exception e)
        {
            LOGGER.error("请求参数解析异常！请求字符串{}", reqJsonStr, e);
        }
        return null;
    }


    /**
     * 获得请求body
     * 
     * @param <T>
     * @param reqJsonStr
     * @param c
     * @return
     */
    public static <T> T getReqBody(String reqJsonStr, Class<T> c)
    {
        try
        {
            Req req = JsonUtil.string2Object(reqJsonStr, Req.class);
            return JsonUtil.string2Object(req.getBody(), c);
        }
        catch (Exception e)
        {
            LOGGER.error("请求参数主体解析异常！请求字符串{}", reqJsonStr, e);
        }
        return null;
    }

    // public static void main(String a[]){
    // Req r=new Req();
    // r.setBody("asdfadfa");
    // try
    // {
    // System.out.println(JsonUtil.object2String(ReqUtil.getReqByJson(JsonUtil.object2String(r),
    // Req.class)));
    // }
    // catch (Exception e)
    // {
    // }
    // }
}
