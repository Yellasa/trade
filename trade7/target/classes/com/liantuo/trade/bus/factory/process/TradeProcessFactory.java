package com.liantuo.trade.bus.factory.process;

import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.dispatcher.process.VersionDef;
import com.liantuo.trade.dispatcher.process.ProcessDef;
import com.liantuo.trade.dispatcher.process.ProcessVersion;
import com.liantuo.trade.exception.BuildProcessException;
import com.liantuo.trade.bus.process.Process;

//@Component(value = "tradeProcessFactory")
public class TradeProcessFactory {
//    @Resource
    private VersionDef versionDef;

    public Process buildProcess(TradePacketHead head) throws BuildProcessException {
        String version = head.getVersion();
        ProcessVersion processVersion;
        ProcessDef processDef;
        try {
            processVersion = (ProcessVersion) versionDef.getVersions().get(version);
            if (null == processVersion)
                return null;
            String request_code = head.getRequest_code();
            processDef = processVersion.getProcessDef();
            return processDef.getProcessMap().get(request_code);
        } catch (Exception e) {
            try {
                throw new BuildProcessException("交易Process构建异常:" + ObjectJsonUtil.object2String(head), e);
            } catch (Exception e1) {
                throw new BuildProcessException("交易Process构建异常:", e1);
            }
        }
    }
}
