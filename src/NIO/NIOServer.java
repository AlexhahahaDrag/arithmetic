package NIO;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {
    //通道管理器
    private Selector selector;
    /**
     * 获得一个ServerSocket通道，并对该通道做一系列初始化工作
     * @param  port 绑定的端口号
     */
    public void initServer(int port) throws IOException{
        //获得一个ServerSocket通道
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        //设置通道为非阻塞
        serverSocketChannel.configureBlocking(false);
        //将该通道对应的ServerSocket绑定到port端口
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        //获得一个通道管理器
        this.selector=Selector.open();
        //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件，注册该事件后，
        //当该事件到达时，selector.select（）会返回，如果该事件没有到达selector.select()会直接阻塞。
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }
    /**
     * 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
     */
    @SuppressWarnings("unchecked")
    public void listen() throws IOException{
        System.out.println("服务端启动成功!!");
        //轮询访问selector
        while(true){
            //当注册的事件到达时，方法返回；否则，该方法会一直阻塞
            selector.select();
            //获得selector中选中的项的迭代器，选中的项为注册的事件
            Iterator iterator=this.selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key=(SelectionKey)iterator.next();
                //删除已选的key，以防重复
                iterator.remove();
                //客户端请求连接事件
                if (key.isAcceptable()){
                    ServerSocketChannel serverSocketChannel=(ServerSocketChannel)key.channel();
                    //获取和客户的连接通道
                    SocketChannel socketChannel=serverSocketChannel.accept();
                    //设置成非阻塞
                    socketChannel.configureBlocking(false);
                    //在这里给客户发送信息
                    socketChannel.write(ByteBuffer.wrap(new String("向客户端发送一条消息").getBytes()));
                    //在和客户端连接成功之后，为了可以接受到客户端信息，需要给通道设置读的权限。
                    socketChannel.register(this.selector,SelectionKey.OP_READ);
                }else if (key.isReadable()){
                    read(key);
                }
            }
        }
    }
    /**
     * 处理客户端发送过来的信息的事件
     * param key
     */
    public void read(SelectionKey key) throws IOException{
        //服务器可读取的信息：得到事件发生的Socket通道
        SocketChannel socketChannel=(SocketChannel) key.channel();
        //创建读取的缓存区
        ByteBuffer byteBuffer=ByteBuffer.allocate(10);
        socketChannel.read(byteBuffer);
        byte[] data=byteBuffer.array();
        String message=new String(data).trim();
        System.out.println("服务器收到信息:"+message);
        ByteBuffer outBuffer=ByteBuffer.wrap(message.getBytes());
        socketChannel.write(outBuffer);
    }
    /**
     * 启动服务器测试
     */
    public static void main(String[] args) throws IOException{
        NIOServer nioServer=new NIOServer();
        nioServer.initServer(8000);
        nioServer.listen();
    }
}
