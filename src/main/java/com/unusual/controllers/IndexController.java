package com.unusual.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Igor on 9/25/2019.
 */
@Controller
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private @ResponseBody
    String index() {
        System.out.println("Ulazak u kontroler za /index");
        return "index";
    }


}
