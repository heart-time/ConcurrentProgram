package com.hundsun.tbsp.IODemo;

import org.junit.Test;

import java.io.*;
import java.net.URL;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.IODemo
 * @Description
 * @date 2023/11/1 21:37
 */
public class InputStreamDemo {
    File file = new File("E://hello.txt");

    @Test
    public void test1() {
        try (FileInputStream fis = new FileInputStream(file)) {
            int content;
            System.out.println("The remaining bytes:" + fis.available());
            System.out.println("The actual reading bytes is :" + fis.skip(3));
            System.out.print("The Content read from file:");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try (FileInputStream fis = new FileInputStream("E://oyzh.jpg");
             FileOutputStream fos = new FileOutputStream("E://oyzh2.jpg")) {
            long statTime = System.currentTimeMillis();
            int len = -1;
            while ((len = fis.read()) != -1) {
                fos.write(len);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("耗时:" + (endTime - statTime) * 100);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E://oyzh.jpg"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E://oyzh3.jpg"))) {
            int len = -1;
            long startTime = System.currentTimeMillis();
            while ((len = bis.read()) != -1) {
                bos.write(len);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("耗时：" + (endTime - startTime) * 100);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 当读取数据的时候指定读取的大小，那么字节缓冲流，字节流的效率差不多
     * 当不指定读取的字节数组的大小时，字节缓冲流的读取速度远远大于字节流
     */
    @Test
    public void test4() {
        try (FileInputStream fis = new FileInputStream("E://oyzh.jpg");
             FileOutputStream fos = new FileOutputStream("E://oyzh4.jpg");) {
            byte[] b = new byte[1024 * 3];
            long startTime = System.currentTimeMillis();
            int len = -1;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("耗时：" + (endTime - startTime));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @SuppressWarnings("all")
    public void test5() {
        try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream("E://oyzh.jpg"));
             BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("E://oyzh4.jpg"))) {
            byte[] b = new byte[1024 * 3];
            long startTime = System.currentTimeMillis();

            int len = -1;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("耗时：" + (endTime - startTime));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    @Test
    public void test6() {
        int content = -1;
        try (FileReader reader = new FileReader("hello.txt");
             FileWriter writer = new FileWriter("hello2.txt")) {
            while ((content = reader.read()) != -1) {
                writer.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test7() {
        int content = -1;
        try (FileInputStream reader = new FileInputStream("hello.txt");
             FileOutputStream writer = new FileOutputStream("hello3.txt")) {
            while ((content = reader.read()) != -1) {
                writer.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件分片上传，RandomAccessFile可以实现访问文件的任意位置
     * RandomAccessFile主要用于大文件的分片上传
     */
    @Test
    public void test14() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("hello.txt", "rw")) {
            System.out.println("读取之前的偏移量:" + randomAccessFile.getFilePointer() + "读取内容:" + (char) randomAccessFile.read() + "读取之后的偏移量:" + randomAccessFile.getFilePointer());
            randomAccessFile.seek(6);//偏移6
            System.out.println("读取之前的偏移量:" + randomAccessFile.getFilePointer() + "读取内容:" + (char) randomAccessFile.read() + "读取之后的偏移量:" + randomAccessFile.getFilePointer());
            randomAccessFile.write(new byte[]{'H', 'I', 'J'});
            randomAccessFile.seek(0);//将指针的偏移量重置为0;
            System.out.println("读取之前的偏移量:" + randomAccessFile.getFilePointer() + "读取内容:" + (char) randomAccessFile.read() + "读取之后的偏移量:" + randomAccessFile.getFilePointer());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void test8(){
        String path="oyzh.jpg";
        try(FileInputStream fis=new FileInputStream(path);
            FileOutputStream fos=new FileOutputStream("oyzh1.jpg")){
            int len=-1;
            long startTime=System.currentTimeMillis();
            while((len= fis.read())!=-1){
                fos.write(len);
            }
            long endTime=System.currentTimeMillis();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test9(){
        String path="oyzh.jpg";
        try(BufferedInputStream fis=new BufferedInputStream(new FileInputStream(path));
            BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream("oyzh1.jpg"))){
            int len=-1;
            long startTime=System.currentTimeMillis();
            while((len= fis.read())!=-1){
                fos.write(len);
            }
            long endTime=System.currentTimeMillis();
            System.out.println("需要时间:"+(endTime-startTime));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * AIO、BIO、NIO 三种IO模型的区别以及主要实现逻辑
     */
    @Test
    public  void test11(){
        String path="oyzh.jpg";
        String des="oyzh1.jpg";
        int score =44;
        String des2="oyzh2.jpg";
        System.out.println(getGrade(score));
        try(FileInputStream fileInputStream =new FileInputStream(path);
            FileOutputStream fileOutputStream=new FileOutputStream(des)) {
            int len;
            byte [] b=new byte[1024*2];
            while((len= fileInputStream.read(b))!=-1){
                fileOutputStream.write(b,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public char getGrade(int score){
        return  score>90?'A': score>=60&&score<=90?'B':'C';
    }
}
