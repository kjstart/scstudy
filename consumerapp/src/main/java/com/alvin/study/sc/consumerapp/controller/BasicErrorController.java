package com.alvin.study.sc.consumerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
        import org.springframework.boot.web.servlet.error.ErrorAttributes;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import javax.servlet.http.HttpServletRequest;
        import java.util.Map;

@RestController
@RequestMapping("/error")
public class BasicErrorController extends AbstractErrorController {

    @Autowired
    public BasicErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping
    public Map<String, Object> error(HttpServletRequest request) {
        return super.getErrorAttributes(request, super.getTraceParameter(request));
    }
}