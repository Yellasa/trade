package com.liantuo.trade.mq.rabbitmq.notice;

import com.liantuo.trade.client.trade.packet.NotifyPacketResultInfo;
import com.liantuo.trade.client.trade.packet.rsp.withdraw.WithdrawNotifyRspPacket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/spring/applicationContext-*.xml"
})
public class NotifyServiceTest {
    private static final String filePath = "D://abc.txt";
    @Autowired
    private NotifyService notifyService;


    private String[] data = new String[]{
    		
    };

    @Test
    public void reNotiy() {
        List<NotifyPacketResultInfo> list = new ArrayList<NotifyPacketResultInfo>();
        NotifyPacketResultInfo info;
        WithdrawNotifyRspPacket packet;

//        for(String xml : data){
//            packet = WithdrawNotifyRspPacket.unmarshal(xml, WithdrawNotifyRspPacket.class);
//            info = new NotifyPacketResultInfo();
//            org.springframework.beans.BeanUtils.copyProperties(packet.getBody(), info);
//            list.add(info);
//        }
        list = readFileByLines(filePath);
        for (NotifyPacketResultInfo notice : list) {
            try {
                notifyService.sendNotice(notice);
                System.err.println(notice);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testSendNotice() {
        int i = 0;
        while (true) {
//			notifyService.sendNotice("http://localhost", "T", String.valueOf(i), "", "{}", "001_001_001");
            i++;
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
        }

//		for(int i=0;i<100000;i++)
//			
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static List<NotifyPacketResultInfo> readFileByLines(String fileName) {
        List<NotifyPacketResultInfo> list = null;
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            list = new ArrayList<NotifyPacketResultInfo>();
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {
                WithdrawNotifyRspPacket packet = WithdrawNotifyRspPacket.unmarshal(tempString, WithdrawNotifyRspPacket.class);
                NotifyPacketResultInfo info = new NotifyPacketResultInfo();
                org.springframework.beans.BeanUtils.copyProperties(packet.getBody(), info);
                // 显示行号
                list.add(info);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return list;
    }
}
