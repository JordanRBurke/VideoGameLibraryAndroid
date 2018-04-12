package com.jordanburke.videogamelibrary;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by jordanburke on 4/12/18.
 */

public class DateConverter {

    @TypeConverter
    public static Date fromTimeStamp(Long value) {


        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimeStamp (Date date) {

        return date == null ? null : date.getTime();
    }
}
