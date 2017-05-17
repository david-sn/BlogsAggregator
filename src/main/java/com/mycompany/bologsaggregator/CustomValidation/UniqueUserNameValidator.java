package com.mycompany.bologsaggregator.CustomValidation;

import com.mycompany.bologsaggregator.Hibernate.DAO.UserDAO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;


public class UniqueUserNameValidator  implements ConstraintValidator<UniqueUserName, String>{

    @Autowired
    private UserDAO userDAO;
    
    @Override
    public void initialize(UniqueUserName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (userDAO==null) {
            return true;
        }
        return userDAO.getUsersByName(value)==null;
        
    }
    
    
}
