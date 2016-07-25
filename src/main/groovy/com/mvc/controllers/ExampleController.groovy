package com.mvc.controllers

import com.mvc.model.Person
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by tm1c14 on 25/07/2016.
 */
@RequestMapping(value = "/example")
@RestController
class ExampleController {


    @RequestMapping(value = "/person", produces = "application/json", method = RequestMethod.GET)
    public Person save(@ModelAttribute Person person) {
        return person
    }

    @RequestMapping(value = "/person", produces = "application/json", method = RequestMethod.GET, params = ["type=multi"])
    public Person saveMulti(@ModelAttribute Person person) {
        println "calling params=multi"
        return person
    }

    @RequestMapping(value = "/{name}", produces = "application/json", method = RequestMethod.GET)
    public Person withPathvariable(@PathVariable String name) {
       Person p = new Person(name: name)
        return p
    }

}
