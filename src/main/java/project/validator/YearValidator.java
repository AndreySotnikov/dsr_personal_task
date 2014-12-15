package project.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

/**
 * Created by Андрей on 15.12.2014.
 */
public class YearValidator implements ConstraintValidator<ValidYear, Integer> {
    @Override
    public void initialize(ValidYear validYear) {

    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        Date date = new Date();
        int cur_date = date.getYear()+1900;
        return (integer==null)?true:(integer<=cur_date)?true:false;
    }
}
