package com.prem.smbd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public ModelAndView greet() {
        ModelAndView view = new ModelAndView("hello");
        view.addObject("message", "Helo from spring controller");
        return view;
    }

    @RequestMapping(value = "/welcome1/{username}")
    public ModelAndView welcome1(@PathVariable("username") String username) {
        ModelAndView view = new ModelAndView("welcome1");
        view.addObject("welcome", "Welcome " + username + " from my first welcome page");
        return view;
    }

    @RequestMapping(value = "/welcome2/{firstName}/{lastName}", method = RequestMethod.GET)
    public ModelAndView welcome2(@PathVariable("firstName") String firstName,
                                 @PathVariable(name = "lastName") String lastName) {
        ModelAndView view = new ModelAndView("welcome2");
        view.addObject("welcome2", "hello " + firstName + " " + lastName);
        return view;

    }

    @RequestMapping(value = "/welcome3/{firstname}/{lastname}")
    public ModelAndView welcome3(@PathVariable Map<String, String> names) {
        ModelAndView view = new ModelAndView("welcome3");//jsp
        view.addObject("welcome3", "hello " + names.get(" firstname") + " " + names.get("lastname"));
        return view;
    }

    @RequestMapping(value = "/welcome4", method = RequestMethod.GET)
    public ModelAndView welcome4(@RequestParam("username") String userName) {
        ModelAndView view = new ModelAndView("welcome4");
        view.addObject("welcome4", "hello " + userName);
        return view;
    }

    @RequestMapping(value="/welcome5", method = RequestMethod.GET)
    public ModelAndView welcome5(@RequestParam("firstname")String firstname,
                                 @RequestParam("lastname")String lastname){
        ModelAndView view=new ModelAndView("welcome5");//jsp
        view.addObject("welcome5", "hello "+firstname+ " "+lastname);
        return view;
    }
    @RequestMapping(value = "/welcome6", method = RequestMethod.GET)
    public ModelAndView welcome6(@PathVariable("username") String username){
        ModelAndView view=new ModelAndView("welcome6");
        view.addObject("message6","username is "+username);
        return view;
    }

}

