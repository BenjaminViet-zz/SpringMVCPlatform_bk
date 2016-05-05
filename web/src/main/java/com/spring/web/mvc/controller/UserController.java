package com.spring.web.mvc.controller;

import com.spring.business.UserGroupService;
import com.spring.business.UserService;
import com.spring.dto.UserGroupDTO;
import com.spring.util.Constants;
import com.spring.web.mvc.command.UserCommand;
import com.spring.web.mvc.validator.UserValidator;
import com.spring.web.util.SpringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/28/16
 * Time: 13:52
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class UserController {

    private final transient Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserGroupService userGroupService;
    @Autowired
    private UserValidator userValidator;

    @RequestMapping("/user/newUser.html")
    public ModelAndView addNew(@ModelAttribute(Constants.FORM_MODEL_KEY)UserCommand command,
                               BindingResult bindingResult){

        ModelAndView mav = new ModelAndView("/user/addNew");
        String crudaction = command.getCrudaction();

        if(StringUtils.isNotEmpty(crudaction)){
            if(crudaction.equalsIgnoreCase(Constants.INSERT_UPDATE)){
                userValidator.validate(command, bindingResult);
                if(!bindingResult.hasErrors()){
                    this.userService.saveAndEncodePassword(command.getPojo());
                    mav.addObject("insert_success", true);
                    mav.addObject("success", "User " + command.getPojo().getUserName() + " registered successfully");
                }
//                else{
//                    mav.addObject("insert_success", false);
//                    mav.addObject("success", "User " + command.getPojo().getUserName() + " failed to register!");
//                }

            }
        }
        referenceData(command, mav);
        return mav;
    }

    private void referenceData(UserCommand command, ModelAndView mav){
        mav.addObject("userGroupList", this.userGroupService.findAll());
    }
}
