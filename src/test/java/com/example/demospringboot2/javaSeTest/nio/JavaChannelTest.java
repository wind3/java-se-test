package com.example.demospringboot2.javaSeTest.nio;

import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Title: NIO测试
 * @Description: TODO
 * @Author: lovelin
 * @CreateTime: 2019/11/24$ 10:15$
 */
public class JavaChannelTest {

    @Test
    public void fileChannelTest(){
        //
        String path = "C:\\" +
                "Users\\lovelin\\Desktop\\test.txt";

        String outPath = "C:\\" +
                "Users\\lovelin\\Desktop\\test-out.txt";
        File inFile = new File(path);
        try {
            FileChannel fileChannel = new FileInputStream(inFile).getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            FileChannel outFileChannel = new FileOutputStream(outPath).getChannel();

            while (fileChannel.read(byteBuffer) != -1){
                //read时，指针已经到了limit位置
                //flip将指针调回到起始位置，limit限制最多读取到当前缓存的内容
                byteBuffer.flip();
                outFileChannel.write(byteBuffer);
                //压缩，将未被读取的内容提取到最前面，position为当前内容的末尾
                byteBuffer.compact();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void socketServerChannelTest(){

        try {
            //创建服务器socket通道，用于接受客户端的连接
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            //创建选择器，将选择器绑定到serverSocketChannel
            Selector selector = Selector.open();
            //绑定服务器socket端口是9090，客户端需要连接到此端口
            serverSocketChannel.bind(new InetSocketAddress(9090));
            //注册serverSocketChannel到选择器，兴趣集是接受请求
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true){
                //如果没有被接受的连接
                if (selector.select(10) == 0){
                    continue;
                }
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    //如果是可接收的请求
                    if (selectionKey.isAcceptable()){
                        //接收请求
                        SocketChannel accept = serverSocketChannel.accept();
                        accept.configureBlocking(false);
                        //将请求通道注册到选择器
                        accept.register(selectionKey.selector(),SelectionKey.OP_READ,ByteBuffer.allocate(1024));
                    }
                    //如果是可读的
                    if (selectionKey.isReadable()){
                        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                        int read = socketChannel.read(buffer);
                        while (read > 0){
                            buffer.flip();
                            while (buffer.hasRemaining()){
                                System.out.println((char)buffer.get());
                            }
                            buffer.clear();
                            read = socketChannel.read(buffer);
                        }

                        //如果读取完毕，关闭客户端连接
                        if (read == -1 ){
                            socketChannel.close();
                        }
                    }
                }
//                获取选择器的所有key集合
//                Set<SelectionKey> keys = selector.keys();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
