package com.perets.project.configuration;


import com.perets.project.validation.PageableValidatorImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebMvc
public class WebMvcContext implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver handler = new PageableHandlerMethodArgumentResolver() {

            @Override
            public Pageable resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer,
                                            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
                Pageable p = super.resolveArgument(methodParameter, mavContainer, webRequest, binderFactory);
                String page = webRequest.getParameter("page");
                if (StringUtils.isNotBlank(page) && !StringUtils.isNumeric(page)) {
                    throw new ConstraintViolationException(page, Collections.singleton(new PageableValidatorImpl()));
                }
                return PageRequest.of(p.getPageNumber(), p.getPageSize(), p.getSort());
            }
        };
        handler.setMaxPageSize(100);
        handler.setOneIndexedParameters(true);
        handler.setFallbackPageable(PageRequest.of(0, 3));
        argumentResolvers.add(handler);
    }
}
