package com.mxs.huobi.constant;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateFormatConstant {
    public static final SimpleDateFormat FORMAT_FOR_LOG = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    public static final SimpleDateFormat FORMAT_FOR_EXCEPTION = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter FORMAT_FOR_CANDLESTICK = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT);
}
