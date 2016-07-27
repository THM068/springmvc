package com.mvc.traits

import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * Created by tm1c14 on 27/07/2016.
 */
trait ExceptionHandlers {

    @ExceptionHandler(Exception.class)
    public String handlerError() {
        return 'errors/runtimeError'
    }
}
