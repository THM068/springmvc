package com.mvc.controllers

import com.mvc.validators.PersonValidator
import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.ModelAttribute

import java.text.SimpleDateFormat

/**
 * Created by tm1c14 on 28/07/2016.
 */
@ControllerAdvice
class GlobalControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat('dd/MM/yyyy')
        dateFormat.setLenient(false)
        //binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true))
        binder.addValidators(new PersonValidator())
    }

//    @ExceptionHandler(Exception.class)
//    public String handlerError() {
//        return 'errors/runtimeError'
//    }

    @ModelAttribute('currentDate')
    public String getCurrentDate() {
        return '27/09/2016-->'
    }

}
