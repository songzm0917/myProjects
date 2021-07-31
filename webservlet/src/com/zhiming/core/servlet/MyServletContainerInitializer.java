package com.zhiming.core.servlet;

import com.zhiming.core.filter.UserFilter;
import com.zhiming.core.listener.UserListener;
import com.zhiming.core.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

@HandlesTypes({UserService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
        for (Class<?> aClass : set) {
            System.out.println(aClass);
        }

        ServletRegistration.Dynamic servlet = sc.addServlet("userServlet", UserServlet.class);
        servlet.addMapping("/user");

        FilterRegistration.Dynamic filter = sc.addFilter("userFilter", UserFilter.class);

        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");

        sc.addListener(UserListener.class);
    }
}
