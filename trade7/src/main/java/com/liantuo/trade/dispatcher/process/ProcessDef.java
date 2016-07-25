package com.liantuo.trade.dispatcher.process;

import java.util.Map;

import com.liantuo.trade.bus.process.Process;

public class ProcessDef {
    private Map<String, Process> processMap;

    public Map<String, Process> getProcessMap() {
        return processMap;
    }

    public void setProcessMap(Map<String, Process> processMap) {
        this.processMap = processMap;
    }
}
