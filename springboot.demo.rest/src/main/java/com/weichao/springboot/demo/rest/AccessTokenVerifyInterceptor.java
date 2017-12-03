package com.weichao.springboot.demo.rest;

import com.weichao.springboot.demo.rest.service.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessTokenVerifyInterceptor extends HandlerInterceptorAdapter {

    private final static Logger LOG = LoggerFactory.getLogger(AccessTokenVerifyInterceptor.class);

    @Autowired
    private ValidationService validationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("AccessToken executing ...");
        String accessToken = request.getHeader("token");
        LOG.info("access token : {}", accessToken);
//        boolean flag = false;
//        // token
//        String accessToken = request.getParameter("token");
//        if (StringUtils.isNotBlank(accessToken)) {
//            // 验证
//            ValidationModel v = validationService.verifyAccessToken(accessToken);
//            // 时间过期
//            // 用户验证
//            if (v != null) {
//                User user = userService.findById(v.getUid());
//                if(user != null) {
//                    request.setAttribute(CommonConst.PARAM_USER, user);
//                    LOG.info("AccessToken SUCCESS ...  user:" + user.getUserName() + " - " + accessToken);
//                    flag = true;
//                }
//            }
//        }
//
//        if (!flag) {
//            response.setStatus(HttpStatus.FORBIDDEN.value());
//            response.getWriter().print("AccessToken ERROR");
//        }
//
//        return flag;

//        HttpSession session = request.getSession();
//        if (session.getAttribute(SESSION_KEY) != null)
//            return true;
//
//        // 跳转登录
//        String url = "/login";
//        response.sendRedirect(url);
//        return false;

        return super.preHandle(request, response, handler);
    }

    public ValidationService getValidationService() {
        return validationService;
    }
}
