package com.aconti.aleaknowledgetest.controller;

import com.aconti.aleaknowledgetest.business.Classifier;
import com.aconti.knowledgetest.utility.PokemonHeightComparator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author aconti
 */
public class HeightController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mav = new ModelAndView("aleaknowledgetest");
        String[] arr = new Classifier().getBest5(new PokemonHeightComparator());
        mav.addObject("pokemon0", arr[0]);
        mav.addObject("pokemon1", arr[1]);
        mav.addObject("pokemon2", arr[2]);
        mav.addObject("pokemon3", arr[3]);
        mav.addObject("pokemon4", arr[4]);
        return mav;
    }
}
