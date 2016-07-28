package com.mvc.controllers

import com.mvc.traits.ExceptionHandlers
import org.omg.CORBA.Request
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * Created by tm1c14 on 27/07/2016.
 */
@Controller
@RequestMapping("/resource")
class ResourceController  {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index() {
        return 'resource/index'
    }



    @ExceptionHandler(NullPointerException.class)
    public String handlerError() {
        return 'errors/runtimeError'
    }
}
