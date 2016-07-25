package com.liantuo.trade.dispatcher.process;

import java.util.Map;

public class ProcessVersion {

    private ProcessDef processDef;

    public Process getProcessDef(Map<String, String> map) {
        String key = map.get("version");
        return (Process) processDef.getProcessMap().get(key);
    }

    public ProcessDef getProcessDef() {
        return processDef;
    }

    public void setProcessDef(ProcessDef processDef) {
        this.processDef = processDef;
    }
}
