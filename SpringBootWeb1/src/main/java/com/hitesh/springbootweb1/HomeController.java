package com.hitesh.springbootweb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("input1") int num1, @RequestParam("input2") int num2, ModelAndView mv){
        int result = num1 + num2;

        mv.addObject("result", result);
        mv.setViewName("result");

        return mv;
    }

    @RequestMapping("addAlien")
    public ModelAndView addAlien(@ModelAttribute Alien alien, ModelAndView mv){

        mv.addObject("alien", alien);
        mv.setViewName("result");

        return mv;
    }
}
