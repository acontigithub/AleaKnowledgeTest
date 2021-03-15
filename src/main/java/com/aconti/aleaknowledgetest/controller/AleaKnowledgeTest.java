package com.aconti.aleaknowledgetest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author aconti
 */
public class AleaKnowledgeTest extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mav = new ModelAndView("aleaknowledgetest");
        return mav;
    }
    
}