package pl.prz.l6.systempotwierdzaniawizyt.validators;

import pl.prz.l6.systempotwierdzaniawizyt.DTO.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation){
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserDTO userDTO = (UserDTO) obj;

        return userDTO.getPassword().equals(userDTO.getRepeatPassword());
    }
}