package com.fhcy.exception.resolver;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class DelegateCustomHandlerExceptionResolver extends AbstractHandlerExceptionResolver {

    private List<CustomHandlerExceptionResolver> resolvers = new ArrayList<>();

    /**
     * HandlerExceptionResolverComposite.setOrder(0)
     * {@link WebMvcConfigurationSupport#handlerExceptionResolver}
     */
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response, Object handler, Exception ex) {
        for (CustomHandlerExceptionResolver resolver : resolvers) {
            if (resolver.support(ex)) {
                return resolver.resolveException(request, response, handler, ex);
            }
        }
        return null;
    }

    public List<CustomHandlerExceptionResolver> getResolvers() {
        return resolvers;
    }

    public void setResolvers(List<CustomHandlerExceptionResolver> resolvers) {
        this.resolvers = resolvers;
    }
}