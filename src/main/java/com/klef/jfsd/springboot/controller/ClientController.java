package com.klef.jfsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Viewer;
import com.klef.jfsd.springboot.service.ViewerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController {

    @Autowired
    private ViewerService viewerService;
    
 

    @GetMapping("/")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/signup")
    public ModelAndView signup() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("signup");
        return mv;
    }

    @GetMapping("/insertviewer")
    public ModelAndView insertviewer(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        try {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Viewer ob = new Viewer();
            ob.setUsername(username);
            ob.setEmail(email);
            ob.setPassword(password);

            String result = viewerService.addviewer(ob);
            if (result.equals("Viewer Saved Successfully")) {
                mv.setViewName("signin");
            } else {
                mv.setViewName("signup");
            }
        } catch (Exception e) {
            mv.setViewName("signup");
        }
        return mv;
    }

    @GetMapping("/signin")
    public ModelAndView signin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("signin");
        return mv;
    }

    @GetMapping("/checklogin")
    public ModelAndView checklogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Viewer v = viewerService.checklogin(username, password);

        if (v != null) {
            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("username", v.getUsername());
            session.setAttribute("password", v.getPassword());

            mv.setViewName("search");
        } else {
            mv.setViewName("signin");
        }
        return mv;
    }
  
}
