package com.mvc.traits

import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by tm1c14 on 27/07/2016.
 */
@Component
class GlabalHandlerExceptionResolver implements HandlerExceptionResolver{
    @Override
    ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mav = new ModelAndView()
        mav.setViewName('errors/runtimeError')
        return mav
    }
}
