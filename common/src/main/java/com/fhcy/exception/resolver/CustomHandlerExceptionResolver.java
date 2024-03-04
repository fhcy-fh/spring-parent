package com.fhcy.exception.resolver;

import org.springframework.web.servlet.HandlerExceptionResolver;

public abstract class CustomHandlerExceptionResolver implements HandlerExceptionResolver {

    private String localeParamName = "locale";

    public String getLocaleParamName() {
        return localeParamName;
    }

    public void setLocaleParamName(String localeParamName) {
        this.localeParamName = localeParamName;
    }

    public abstract boolean support(Exception ex);
}