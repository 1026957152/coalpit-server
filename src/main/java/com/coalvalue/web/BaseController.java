package com.coalvalue.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Controller;


/**
 * Created by zhongkw on 1/7/2015.
 */
@Controller
public class BaseController implements MessageSourceAware {

    protected transient Logger logger = LoggerFactory.getLogger(getClass());

    private MessageSource messageSource;


    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
