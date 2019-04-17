package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIO客户端
 */
public class NIOClient1 {
    //通道管理器
    private Selector selector;
    /**
     * 获得一个Socket通道，并对该通道做出一些初始化工作
     * param ip 连接服务器的ip
     * param port 连接服务器的端口号
     */
    public void initClient(String ip ,int port)throws IOException{
        //获取一个Socket通道
        SocketChannel socketChannel=SocketChannel.open();
        //设置通道为非阻塞
        socketChannel.configureBlocking(false);
        //获得一个通道管理器
        this.selector=Selector.open();
        /**户端连接服务器，其方法执行并没有实现连接，需要再listen（）方法中调用
         * channel.finshConnect()；才能完成连接
         */
        socketChannel.connect(new InetSocketAddress(ip,port));
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
    }
    /**
     * 采用轮询的方式监听seletor上是否有需要处理的事件，如果有，则进行处理
     */
    @SuppressWarnings("unchecked")
    public void listen() throws IOException{
        //轮询访问selector
        while (true){
            selector.select();
            //获取selector中选中的项的迭代器
            Iterator iterator=this.selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                SelectionKey selectionKey=(SelectionKey)iterator.next();
                //删除已选的key，以防重复
                iterator.remove();
                //连接事件发生
                if (selectionKey.isConnectable()){
                    SocketChannel socketChannel=(SocketChannel)selectionKey.channel();
                    //如果正在连接，则完成连接
                    if (socketChannel.isConnectionPending()){
                        socketChannel.finishConnect();
                    }
                    //设置成非阻塞
                    socketChannel.configureBlocking(false);
                    //在这里给服务器发送消息
                    socketChannel.write(ByteBuffer.wrap(new String("客户端1向服务器发送一条消息").getBytes()));
                    //在和服务器连接成功之后，为了可以接受到服务器端的消息，需要给通道设置读的权限
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if (selectionKey.isReadable()){
                    read(selectionKey);
                }
            }
        }
    }
    /**
     * 处理服务器端发送过来的信息的事件
     * @param key
     */
    public void read(SelectionKey key)throws IOException{
        //服务器可读取的信息：得到事件发生的Socket通道
        SocketChannel socketChannel=(SocketChannel) key.channel();
        //创建读取的缓存区
        ByteBuffer byteBuffer=ByteBuffer.allocate(10);
        socketChannel.read(byteBuffer);
        byte[] data=byteBuffer.array();
        String message=new String(data).trim();
        System.out.println("客户端1收到信息:"+message);
        ByteBuffer outBuffer=ByteBuffer.wrap(message.getBytes());
        socketChannel.write(outBuffer);
    }

    public static void main(String[] args) throws IOException{
        NIOClient1 nioClient=new NIOClient1();
        nioClient.initClient("localhost",8000);
        nioClient.listen();
    }
}
