package com.rsotar.backendninja.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

  private static final Logger log = LoggerFactory.getLogger(RequestTimeInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    request.setAttribute("startTime", System.currentTimeMillis());
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
		  throws Exception {

    long startTime = (long) request.getAttribute("startTime");
    String requestUrl = request.getRequestURL().toString();
    log.info("URL To: " + requestUrl + " in: " + (System.currentTimeMillis() - startTime) + " ms ");
  }
}
