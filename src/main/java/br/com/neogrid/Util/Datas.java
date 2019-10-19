package br.com.neogrid.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Datas {

    public static Date stringToDate(Date data, String formato) {
        try {
            String date = new SimpleDateFormat(formato).format(data);
            return new SimpleDateFormat(formato).parse(date);
        } catch (Exception e) {
            return null;
        }
    }

}