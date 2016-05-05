package com.spring.web.mvc.validator;

import com.spring.business.UserService;
import com.spring.dto.UserDTO;
import com.spring.util.CommonUtil;
import com.spring.web.mvc.command.UserCommand;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/28/16
 * Time: 15:36
 * To change this template use File | Settings | File Templates.
 */

@Component
public class UserValidator implements Validator{

    private transient final Logger logger = Logger.getLogger(UserValidator.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserCommand.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserCommand command = (UserCommand)o;
        UserDTO pojo = command.getPojo();
        trimmingFields(pojo);
        checkRequiredFields(pojo, errors);
        validateEmail(pojo, errors);
        checkUniqueUserName(pojo, errors);
    }

    /**
     * Perform removing white spaces at the start and end of each String instances.
     * @param pojo
     */
    private void trimmingFields(UserDTO pojo){
        if(StringUtils.isNotEmpty(pojo.getUserName())){
            pojo.setUserName(pojo.getUserName().trim());
        }
        if(StringUtils.isNotEmpty(pojo.getPassword())){
            pojo.setUserName(pojo.getPassword().trim());
        }
        if(StringUtils.isNotEmpty(pojo.getEmail())){
            pojo.setUserName(pojo.getEmail().trim());
        }
    }

    /**
     * Check required fields before proceeding to the Controller for CRUD actions.
     * @param pojo
     * @param errors
     */
    private void checkRequiredFields(UserDTO pojo, Errors errors){
        if(StringUtils.isEmpty(pojo.getUserName())){
            errors.rejectValue("pojo.userName", "UserName must be not empty!");
        }
        if(StringUtils.isEmpty(pojo.getPassword())){
            errors.rejectValue("pojo.password", "Password must be not empty!");
        }
        if(StringUtils.isEmpty(pojo.getUserName())){
            errors.rejectValue("pojo.email", "Email must be not empty!");
        }
    }

    /**
     * Validate email format before proceeding to the Controller for CRUD actions.
     * @param pojo
     * @param errors
     */
    private void validateEmail(UserDTO pojo, Errors errors){
        if(StringUtils.isNotBlank(pojo.getEmail())){
            if(!CommonUtil.isValidEmail(pojo.getEmail())){
                errors.rejectValue("pojo.email", "Invalid Email!");
            }
        }
    }

    /**
     * Validate unique UserName before proceeding to the Controller for CRUD actions.
     * @param pojo
     * @param errors
     */
    private void checkUniqueUserName(UserDTO pojo, Errors errors){
        if(StringUtils.isNotEmpty(pojo.getUserName())){
            UserDTO userDTO = this.userService.findByUserName(pojo.getUserName());
            if(userDTO != null){
                boolean hasExisted = false;
                if(pojo.getUserId() != null){
                    if(pojo.getUserId().equals(userDTO.getUserId())){
                        hasExisted = true;
                    }
                }else{
                    hasExisted = true;
                }
                if(hasExisted){
                    errors.rejectValue("pojo.userName", "user.userName.duplicated");
                }
            }
        }
    }
}
