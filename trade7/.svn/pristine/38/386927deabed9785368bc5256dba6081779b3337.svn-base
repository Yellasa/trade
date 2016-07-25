package com.liantuo.trade.seqno;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class IdFormat
{
    interface Format
    {
        public abstract void format(Object obj, StringBuffer stringbuffer);
    }

    class StringFormat implements Format
    {
        private String val;

        public void format(Object data, StringBuffer buf)
        {
            if (val == null)
            {
                throw new IllegalArgumentException("input is null.");
            }
            else
            {
                buf.append(val);
                return;
            }
        }

        StringFormat(String value)
        {
            super();
            val = value;
        }
    }

    class NumberFormat implements Format
    {

        private int length;
        private long SEED;

        public void format(Object data, StringBuffer buf)
        {
            if (data == null || !(data instanceof Number))
            {
                throw new IllegalArgumentException("input is not a number: " + data);
            }
            else
            {
                String str = (new Long(SEED + ((Number) data).longValue())).toString();
                buf.append(str.substring(str.length() - length));
                return;
            }
        }

        NumberFormat(int length)
        {
            super();
            SEED = 0x5f5e100L;
            this.length = length;
            SEED = (long) Math.pow(10D, length);
        }
    }

    class DateTimeFormat implements Format
    {

        private DateFormat dateFormat;

        public void format(Object data, StringBuffer buf)
        {
            if (data != null && !(data instanceof Date))
                throw new IllegalArgumentException("input is not a date: " + data);
            Date d = (Date) data;
            if (d == null)
                d = new Date();
            buf.append(dateFormat.format(d));
        }

        DateTimeFormat(String format)
        {
            super();
            dateFormat = new SimpleDateFormat("yyyyMMdd");
            dateFormat = new SimpleDateFormat(format);
        }
    }

    class FieldFormat implements Format
    {

        private String fName;

        public void format(Object data, StringBuffer buf)
        {
            if (data == null || !(data instanceof IdFactory))
                throw new IllegalArgumentException("input is not a id factory: " + data);
            Class c = data.getClass();
            try
            {
                Method get = c.getMethod("get" + fName, null);
                Object o = get.invoke(data, null);
                if (o == null)
                    throw new IllegalArgumentException("field '" + fName + "'s value is null: " + data);
                buf.append(o);
            }
            catch (Exception e)
            {
                throw new IllegalArgumentException("cannot get field '" + fName + "'s value: " + data);
            }
        }

        FieldFormat(String fName)
        {
            super();
            this.fName = Character.toUpperCase(fName.charAt(0)) + fName.substring(1);
        }
    }

    private String pattern;
    private String datePattern;
    private Format format[];

    public static IdFormat getInstance(String pattern)
    {
        return new IdFormat(pattern);
    }

    public String getPattern()
    {
        return pattern;
    }

    public String getDatePattern()
    {
        return datePattern;
    }

    private IdFormat(String pattern)
    {
        this.pattern = pattern;
        compile();
    }

    public String format(IdFactory idf, long id, Date d)
    {
        StringBuffer buf = new StringBuffer(32);
        for (int i = 0; i < format.length; i++)
        {
            Format f = format[i];
            if (f instanceof FieldFormat)
                f.format(idf, buf);
            else if (f instanceof NumberFormat)
                f.format(new Long(id), buf);
            else if (f instanceof DateTimeFormat)
                f.format(d, buf);
            else
                f.format(null, buf);
        }

        return buf.toString();
    }

    protected void compile()
    {
        char chars[] = pattern.toCharArray();
        boolean bStart = false;
        StringBuffer buf = new StringBuffer();
        List formats = new ArrayList();
        for (int i = 0; i < chars.length; i++)
            if ('{' == chars[i])
            {
                if (bStart)
                    throw new IllegalArgumentException("invalid pattern: " + pattern);
                bStart = true;
                if (buf.length() > 0)
                {
                    formats.add(new StringFormat(buf.toString()));
                    buf.setLength(0);
                }
            }
            else if ('}' == chars[i])
            {
                if (!bStart)
                    throw new IllegalArgumentException("invalid pattern: " + pattern);
                bStart = false;
                if (buf.length() > 0)
                {
                    formats.add(parse(buf.toString()));
                    buf.setLength(0);
                }
            }
            else
            {
                buf.append(chars[i]);
            }

        if (bStart)
            throw new IllegalArgumentException("invalid pattern: " + pattern);
        if (buf.length() > 0)
        {
            formats.add(new StringFormat(buf.toString()));
            buf.setLength(0);
        }
        format = (Format[]) formats.toArray(new Format[formats.size()]);
    }

    protected Format parse(String t)
    {
        char z = t.charAt(0);
        switch (z)
        {
            case 35: // '#'
                return new NumberFormat(t.length());

            case 36: // '$'
                return new FieldFormat(t.substring(1));
        }
        datePattern = t;
        return new DateTimeFormat(t);
    }
}
