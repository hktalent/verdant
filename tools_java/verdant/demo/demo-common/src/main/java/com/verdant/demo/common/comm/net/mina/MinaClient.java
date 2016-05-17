package com.verdant.demo.common.comm.net.mina;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * Author: verdant
 * Desc:   Mina客户端
 */
public class MinaClient {
    private static final String HOST = "127.0.0.1";
    private static final Integer PORT_SERVER = 6488;

    public MinaClient(){
        // 创建客户端连接器.
        NioSocketConnector connector = new NioSocketConnector();

        connector.getFilterChain().addLast("logger", new LoggingFilter());
        connector.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

        // 设置连接超时检查时间
        connector.setConnectTimeoutCheckInterval(30);

        connector.setHandler(new MinaClientHandler());

        // 建立连接
        ConnectFuture cf = connector.connect(new InetSocketAddress(HOST, PORT_SERVER));
        // 等待连接创建完成
        cf.awaitUninterruptibly();

        cf.getSession().write("Hi Server!");
        cf.getSession().write("quit");

        // 等待连接断开
        cf.getSession().getCloseFuture().awaitUninterruptibly();
        // 释放连接
        connector.dispose();
    }

    public static void main(String[] args) {
        new MinaClient();
    }
}