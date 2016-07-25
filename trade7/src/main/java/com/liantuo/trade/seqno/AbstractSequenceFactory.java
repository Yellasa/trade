package com.liantuo.trade.seqno;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class AbstractSequenceFactory
        implements SequenceFactory {
    protected final LinkedBlockingQueue<Object> sequenceQueue = new LinkedBlockingQueue<Object>();
    protected final Log log = LogFactory.getLog(SequenceFactory.class);
    protected String type;
    private IdFormat format;
    protected IdTable table;

    public AbstractSequenceFactory() {
        type = null;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFormat(String pattern) {
        format = IdFormat.getInstance(pattern);
    }

    public void setTable(IdTable t) {
        table = t;
    }

    public Object generate() {
        try {
            Object obj = generate(null, 1);
            return obj;
        } catch (Exception e) {
            log.error("->>>序列号生成异常", e);
            throw new RuntimeException(e);
        }
    }

    protected Object generate(int count) throws Exception {
        return generate(null, count);
    }

    protected Object generate(String range) throws Exception {
        return generate(range, 1);
    }

    protected Object generate(String range, int count) throws Exception {
        if (type == null)
            throw new RuntimeException("you must setType(String) in tableIdFactory.");
        long start = System.currentTimeMillis();
        long seq = internalGenerate(range, count);
        if (log.isDebugEnabled()) {
//            log.debug("new a seq no spend: " + (System.currentTimeMillis() - start));
        }
        if (count == 1) {
            if (format == null)
                return new Long(seq);
            else
                return format(seq);
        }
        String ret[];
        if (format == null) {
            ret = new String[count];
            for (int i = 0; i < count; i++)
                ret[i] = String.valueOf(seq + (long) i);
            return ret;
        }
        ret = new String[count];
        for (int i = 0; i < count; i++)
            ret[i] = format(seq + (long) i);

        return ret;
    }

    protected String format(long l) {
        return format.format(this, l, new Date());
    }

    protected abstract long internalGenerate(String s, int i) throws Exception;
}
