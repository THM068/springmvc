package com.mvc.configurator
import org.springframework.core.convert.converter.Converter

import java.text.ParseException
import java.text.SimpleDateFormat;
/**
 * Created by tm1c14 on 28/07/2016.
 */
class StringToDateConverter implements Converter<String, Date> {
    @Override
    Date convert(String source) {
        Date tmpDate = null
        try {
            println 'Converting date '
            tmpDate = new SimpleDateFormat('dd/MM/yyyy').parse(source)
        }
         catch (ParseException ex) {
             ex.printStackTrace()
         }

        return tmpDate
    }
}
