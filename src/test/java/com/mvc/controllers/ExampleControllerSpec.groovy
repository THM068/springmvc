package com.mvc.controllers

import com.mvc.model.Person
import com.mvc.services.PersonService
import groovy.json.JsonSlurper
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.RequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.StatusResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
/**
 * Created by tm1c14 on 26/07/2016.
 */
class ExampleControllerSpec extends Specification {
    def personService

    ExampleController exampleController = new ExampleController()
    MockMvc mockMvc  = MockMvcBuilders.standaloneSetup(exampleController).build()

    def setup() {
        personService = Mock(PersonService)
        exampleController.personService = personService
    }

    def 'A person name is returned in json format'() {
        when: 'When the rest url is hit'
            def response = mockMvc.perform(
                    MockMvcRequestBuilders.get('/example/person?name=thando')).andReturn().response
            def content = new JsonSlurper().parseText(response.contentAsString)

        then:
            response.status == HttpStatus.OK.value()
            response.contentType.contains('application/json')
            response.contentType == 'application/json;charset=UTF-8'

            response.contentAsString == '{"name":"thando"}'
            content.name == 'thando'
    }

    def 'A list of people names is returned'() {
        when: 'when the rest url is called'
            def response = mockMvc.perform(MockMvcRequestBuilders.get('/example/all')).andReturn().response

        then:
            response.status == HttpStatus.OK.value()
            response?.contentAsString != null && !response?.contentAsString.isEmpty()
            def content = new JsonSlurper().parseText(response.contentAsString)

            1 * personService.findAll() >> [new Person(name: 'Thomas'), new Person(name: 'Thelma')]

            response.contentType.contains('application/json')
            response.contentType == 'application/json'
            response.contentAsString == '[{"name":"Thomas"},{"name":"Thelma"}]'
    }

    def 'A person can be saved'() {
        when: 'when we hit the url'
          def response = mockMvc.perform(MockMvcRequestBuilders.post('/example/addPerson')
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content('{"name":"tony"}')).andReturn().response
        then:
            response.status == HttpStatus.OK.value()
    }
}
