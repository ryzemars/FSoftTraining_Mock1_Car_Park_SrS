package com.example.fsofttrainingcarparkproject.custom.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Calendar;
import java.util.Date;

public class BirthDateValidator implements ConstraintValidator<BirthDate, Date> {
    @Override
    public boolean isValid(final Date valueToValidate, final ConstraintValidatorContext context) {
        Calendar dateInCalendar = Calendar.getInstance();
        dateInCalendar.setTime(valueToValidate);

        //TODO: nếu nhỏ hơn 18 tuổi thì in ra phải từ 18 tuổi, nhưng nếu tuổi = số âm thì phải in ra không được nhập ngày tương lai
        //⇉ Chỗ này chỉ cần thêm logic để allow tuổi âm, sau đó thêm @PastOrPresent ngay trên trường employeeBirthday là được
        return (Calendar.getInstance().get(Calendar.YEAR) - dateInCalendar.get(Calendar.YEAR) >= 18 || Calendar.getInstance().get(Calendar.YEAR) - dateInCalendar.get(Calendar.YEAR) <= 0);
    }
}
