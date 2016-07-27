package com.mvc.validators

import com.mvc.model.Person
import org.springframework.validation.Errors
import org.springframework.validation.Validator

/**
 * Created by tm1c14 on 27/07/2016.
 */
class PersonValidator implements Validator{
    @Override
    boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz)
    }

    @Override
    void validate(Object target, Errors errors) {
        Person person = (Person)target

        if(!person?.name) {
            errors.rejectValue("name", 'person.name.empty', 'Please provide a name')
        }
    }
}
