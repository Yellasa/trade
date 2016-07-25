package com.liantuo.trade.web.filter;

import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 访问信息
 */
public class SessionFilter extends OncePerRequestFilter {

    protected final Logger LOGGER = LoggerFactory.getLogger(SessionFilter.class);

    // 字符编码
    private String encoding = "UTF-8";

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (encoding != null) {
            // 设置request字符编码
            request.setCharacterEncoding(encoding);
            // 设置response字符编码
            response.setContentType("text/html;charset=" + encoding);
        }
        String parameterMap = "";
        try {
            parameterMap = ObjectJsonUtil.object2String(request.getParameterMap());
        } catch (Exception e) {
        	this.LOGGER.error("", e);
        }
//        String[] sessionStr = {request.getRemoteAddr(), request.getRemotePort() + "", request.getRemoteHost(), request.getRemoteUser(), request.getPathInfo(), request.getRequestURL().toString(), parameterMap};
        // 请求的信息
        LOGGER.info("Session>>Addr:{},Port:{},Host:{},User:{},PathInfo:{},URL:{},ParameterMap:{}",
                request.getRemoteAddr(),
                request.getRemotePort(),
                request.getRemoteHost(),
                request.getRemoteUser(),
                request.getPathInfo(),
                request.getRequestURL().toString(),
                parameterMap);
        super.doFilter(request, response, filterChain);
    }

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
        encoding = getFilterConfig().getInitParameter("encoding");
    }

}
