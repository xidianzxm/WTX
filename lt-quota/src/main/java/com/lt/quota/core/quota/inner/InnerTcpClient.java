package com.lt.quota.core.quota.inner;

import com.lt.quota.core.comm.netty.client.BaseClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class InnerTcpClient {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void start(String ip, int port) {
        logger.info("连接{} {} start", ip, port);
        StringBuilder key = new StringBuilder();
        key.append(ip).append(":").append(port);
        if (InnerClientBox.getInstance().contains(key.toString())) {
            return;
        }
        InnerTcpClientThread innerTcpClientThread = new InnerTcpClientThread();
        innerTcpClientThread.setHost(ip);
        innerTcpClientThread.setPort(port);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(innerTcpClientThread);
    }

    public void shutdown(String ip, int port) {
        logger.info("关闭{} {} start", ip, port);
        StringBuilder key = new StringBuilder();
        key.append(ip).append(":").append(port);
        if (!InnerClientBox.getInstance().contains(key.toString())) {
            return;
        }
        Thread thread = InnerClientBox.getInstance().getThread(key.toString());
        BaseClient baseClient = InnerClientBox.getInstance().getBaseClient(key.toString());
        if (null != baseClient) {
            baseClient.shutdown();
        }
        if (null != thread) {
            thread.interrupt();
        }
        InnerClientBox.getInstance().removeClient(key.toString());
    }
}
