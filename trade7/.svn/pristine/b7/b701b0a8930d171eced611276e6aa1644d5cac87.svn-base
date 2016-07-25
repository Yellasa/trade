package com.liantuo.trade.common.message;

import com.ebill.framework.datatype.StringUtil;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

@Component(value = "messageBundleServiceImpl")
public class MessageBundleServiceImpl implements MessageBundleService {

    private static ThreadLocal<String> REQUEST_CODE_LOCAL = new ThreadLocal<String>();

    /* 0001前缀的不变，其他前缀根据交易号处理  */
    private static final String SPECIAL_ERROR_CODE_PREFIX = "0001_";

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;
    @Resource
    private ReloadableResourceBundleMessageSource messageCodeSource;

    @Override
    public String getMessage(String key, Object[] param) {
        String msg = messageSource.getMessage(key, param, Locale.CHINA);
        if (StringUtil.isEmpty(msg)) {
            msg = messageCodeSource.getMessage("trade.system.error.unknown", param, Locale.CHINA);
        }
        return msg;
    }

    @Override
    public String getCode(String key) {
        /** FIXME 重新设计：message的中文描述不变，只修改错误码 ，解决模板中交易码问题*/
        if (REQUEST_CODE_LOCAL.get() != null && !REQUEST_CODE_LOCAL.get().startsWith(SPECIAL_ERROR_CODE_PREFIX)) {
//            System.out.println("REQUEST_CODE_LOCAL.get()=========="+REQUEST_CODE_LOCAL.get());
        	String value = getSpecialCode(key);
            if (value != null) {
                return value;
            }
        }
        /*** end ***/

        String code = messageCodeSource.getMessage(key, null, Locale.CHINA);
        if (StringUtil.isEmpty(code)) {
            code = messageCodeSource.getMessage("trade.system.error.unknown", null, Locale.CHINA);
        }
        return code;
    }

    private String getSpecialCode(String key) {
        return messageCodeSource.getMessage(REQUEST_CODE_LOCAL.get() + "_" + key, null, null, Locale.CHINA);
    }

    public void setRequestCode(String reqCode) {
        REQUEST_CODE_LOCAL.set(reqCode);
    }

}