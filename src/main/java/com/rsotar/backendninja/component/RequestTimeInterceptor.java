package com.rsotar.backendninja.component;

import com.rsotar.backendninja.entity.Log;
import com.rsotar.backendninja.repository.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

  private static final Logger logger = LoggerFactory.getLogger(RequestTimeInterceptor.class);

  private LogRepository logRepository;

  @Autowired
  public RequestTimeInterceptor(@Qualifier("logRepository") LogRepository logRepository) {
	this.logRepository = logRepository;
  }

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

	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String username = "";
	if (auth != null && auth.isAuthenticated()) {
		username = auth.getName();
	}
	Log log =  new Log(new Date(), auth.getDetails().toString(), username, requestUrl);
	logRepository.save(log);
	logger.info("URL To: " + requestUrl + " in: " + (System.currentTimeMillis() - startTime) + " ms ");
  }
}
