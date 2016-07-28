package com.mvc.configurator

import com.mvc.model.Person
import com.mvc.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.convert.converter.Converter

/**
 * Created by tm1c14 on 28/07/2016.
 */
class PersonConverter implements Converter<String, Person> {
    PersonService personService

   public void setPersonService(PersonService p) {
       this.personService = p
   }

    @Override
    public Person convert(String source) {
        return personService.find(source)
    }
}
