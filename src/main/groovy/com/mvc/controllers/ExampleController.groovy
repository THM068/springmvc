package com.mvc.controllers

import com.mvc.model.Person
import com.mvc.services.PersonService
import com.mvc.validators.PersonValidator
import org.bouncycastle.cert.ocsp.Req
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.SessionAttributes

import javax.validation.Valid

/**
 * Created by tm1c14 on 25/07/2016.
 */
@RequestMapping(value = "/example")
@RestController
//@SessionAttributes
class ExampleController {


    PersonService personService

    @Autowired
    public ExampleController(PersonService personService) {
        this.personService = personService
    }

    @RequestMapping(value = "/person", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public Person save(@Valid @ModelAttribute Person person, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            println 'The person contain an error'
        }
        //throw new RuntimeException('There was an error')
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

    @RequestMapping(value = '/all', produces = "application/json", method = RequestMethod.GET)
    public List<Person> findAll() {
        def result = personService.findAll()
        return  result
    }

    @RequestMapping(value = '/addPerson', produces = "application/json", method =RequestMethod.POST)
    public void addPerson(@ModelAttribute Person person) {

    }

    @RequestMapping(value = '/name/{userId}', produces = 'application/json', method = RequestMethod.GET)
    public Person withUserId(@PathVariable('userId') Person person) {
        return person
    }



}
