package com.visma.demowholesalers.stereotypes.controllers;

import com.visma.demowholesalers.exceptions.IncorrectRequestException;
import com.visma.demowholesalers.models.MyError;
import com.visma.demowholesalers.models.api.Res;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);


    /**
     * Manually triggered my custome exception catch
     *
     * @param e - IncorrectRequestException (custom)
     * @return
     */
    @ExceptionHandler(IncorrectRequestException.class)
    public @ResponseBody Res customeExceptionInWebServices(IncorrectRequestException e){
        logger.error("Incorrect request received", e);

        return new Res(new MyError(e.getErr()));
    }



    /**
     * General Error handler - responsible to catch any unexpected exception
     *
     * @param req
     * @param e
     * @return error page
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionInWebServices(HttpServletRequest req, Exception e) {
        logger.error("Unknown error occurred while requesting to {}", req.getRequestURL(), e);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");

        return mav;
    }

}
