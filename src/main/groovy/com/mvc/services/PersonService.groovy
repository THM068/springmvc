package com.mvc.services

import com.mvc.model.Person
import org.springframework.stereotype.Component

/**
 * Created by tm1c14 on 26/07/2016.
 */
@Component
class PersonService {

    public List<Person> findAll() {
        return [new Person(name: 'thomas'), new Person(name: 'Kerrie')]
    }

    public Person find(String id) {
        return new Person(name: 'Thando MAfela', birthday: new Date())
    }
}
