package com.liantuo.trade.bus.template;

import com.liantuo.payment.client.pay.PaymentNotify;
import com.liantuo.trade.common.message.MessageBundleService;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * 抽象模板
 *
 * @author dengchao
 */
public abstract class AbstractTradeNotifyTemplate<P> {
    private static Map<Class, Class> bodyClass = new HashMap<Class, Class>();
    private String ip;
    protected P process;

    @Resource(name = "messageBundleServiceImpl")
    private MessageBundleService messageBundleService;

    public void setProcess(P p) {
        process = p;
    }

    public abstract void execute(PaymentNotify notify)
            throws Exception;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Class getBodyClass() {
        if (bodyClass.get(process.getClass()) == null) {
            Class bodyGenType = getGenericType(process.getClass());
            bodyClass.put(process.getClass(), bodyGenType);
            return bodyGenType;
        } else {
            return bodyClass.get(process.getClass());
        }

    }

    @SuppressWarnings("rawtypes")
    private Class<?> getGenericType(Class<?> clazz) {
        Type genType = null;
        if (clazz.getGenericInterfaces().length == 0 || clazz.getGenericInterfaces().length > 1) {
            return getGenericType(clazz.getSuperclass());
        } else {
            genType = clazz.getGenericInterfaces()[0];
            Type[] params = ((ParameterizedType) genType)
                    .getActualTypeArguments();
            return (Class) params[0];
        }
    }

    protected final String getInternalFailureCode(String key) {
        return this.messageBundleService.getCode(key);
    }

    protected final String getInternalFailureMessage(String key, Object... objs) {
        //MessageFormat.format(messageBundleService.getMessage(key),objs);
        return this.messageBundleService.getMessage(key, objs);
    }

}