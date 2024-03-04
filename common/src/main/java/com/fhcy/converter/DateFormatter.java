package com.fhcy.converter;

import com.fhcy.enums.ResultCodeEnum;
import com.fhcy.exception.BizException;
import com.fhcy.utils.DateUtils;
import org.springframework.format.Formatter;

import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {

    @Override
    public Date parse(String text, Locale locale) {
        Date date = DateUtils.parse(text.trim());
        if (date == null) {
            throw new BizException(ResultCodeEnum.ERROR.getCode(), String.format("Can not parse date \"%s\"", text));
        }
        return date;
    }

    @Override
    public String print(Date object, Locale locale) {
        return object.toString();
    }
}
