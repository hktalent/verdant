package com.verdant.demo.common.net.netty.echo;

import com.verdant.demo.common.net.Constants;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;

import java.net.URI;

/**
 * EchoClient
 *
 * @author verdant
 * @since 2016/06/15
 */
public class EchoClient {

    public void connect(String host, int port) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline cp = ch.pipeline();
                            // 客户端接收到的是httpResponse响应，解析要使用HttpResponseDecoder进行解码
                            cp.addLast(new HttpResponseDecoder());
                            // 客户端发送的是httpRequest，解析要使用HttpRequestEncoder进行编码
                            cp.addLast(new HttpRequestEncoder());
                            cp.addLast(new EchoClientHandler());
                        }
                    });

            // Start the client.
            ChannelFuture cf = b.connect(host, port).sync();
            sendMessage(cf, host, port);
            cf.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    private void sendMessage(ChannelFuture cf, String host, int port) {
        try {
            String uriFormat = "http://%s:%s";
            URI uri = new URI(String.format(uriFormat, host, port));
            String msg = "Are you ok?";
            DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET,
                    uri.toASCIIString(), Unpooled.wrappedBuffer(msg.getBytes("UTF-8")));

            // 构建http请求
            request.headers().set(HttpHeaders.Names.HOST, host);
            request.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
            request.headers().set(HttpHeaders.Names.CONTENT_LENGTH, request.content().readableBytes());
            // 发送http请求
            cf.channel().write(request);
            cf.channel().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        String serverHost = System.getProperty("host", "127.0.0.1");
        Integer serverPort = Constants.PORT_NETTY_ECHO_SERVER;
        EchoClient client = new EchoClient();
        client.connect(serverHost, serverPort);
    }
}
