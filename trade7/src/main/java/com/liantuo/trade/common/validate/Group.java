package com.liantuo.trade.common.validate;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, Required.class, Format.class})
public interface Group {

}
