package com.prem.smbd.controller;

import com.prem.smbd.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
      // webDataBinder.setDisallowedFields(new String[] {"dob"});
    }

    @RequestMapping(value ="/welcome7", method= RequestMethod.GET)
    public ModelAndView getUserInfo(){
        ModelAndView view=new ModelAndView("userinfo");
        view.addObject("message","hello from user info");
        return view;
    }

    @RequestMapping(value="info/{username}")
    public ModelAndView info(@PathVariable("username") String username){
        ModelAndView view= new ModelAndView("userinfo");
        view.addObject("message", " user "+username);
        return view;
    }
//opening form
    @RequestMapping(value = "/")
    public ModelAndView openUserForm(){
        ModelAndView view=new ModelAndView("userform");
       // view.addObject("mainMsg", "Welcome to Spring");
        return view;
    }

    @RequestMapping(value = "submitForm1", method = RequestMethod.POST)
    public  ModelAndView submitDorm(@RequestParam Map<String , String> user){
        ModelAndView view=new ModelAndView("userSubmitted");
        view.addObject("info", "Form Submitted "+user.get("firstName")+user.get("lastName"));
        return  view;
    }
    @RequestMapping(value = "submitForm",method = RequestMethod.POST)
    public ModelAndView userDetailSubmit(@ModelAttribute User user, BindingResult result){
        ModelAndView view=new ModelAndView("userDetail");
        if(result.hasErrors()){
           return new ModelAndView("userform");
        }
      //  view.addObject("mainMsg", "Welcome to Spring");
        view.addObject("firstName", user.getFirstName());
        view.addObject("lastName", user.getLastName());
        view.addObject("mobileNum",user.getMobileNum());
        view.addObject("dob",user.getDob());
        return view;
    }
    @ModelAttribute
    public void msgDisplay(Model model){
        model.addAttribute("mainMsg", "Welcome to Spring");
    }


}
