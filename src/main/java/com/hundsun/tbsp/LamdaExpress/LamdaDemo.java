package com.hundsun.tbsp.LamdaExpress;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.LamdaExpress
 * @Description
 * @date 2023/11/2 21:06
 */
public class LamdaDemo {

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("Hello.txt");
             FileOutputStream fos= new FileOutputStream("hello2.txt")) {
            int len;
            while((len=fis.read())!=-1){
                fos.write(len);
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LamdaDemo.geti(()->{
              System.out.println("lambda表达式的终极使用");
          });
        List<String> list = Arrays.asList("1", "2", "3");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s+"  ");
            }
        });
        System.out.println("   ");
        list.forEach(s-> System.out.print(s+" "));
        list.forEach(System.out::println);
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("1","王鹏");
        hashMap.put("2","刘宁");
        hashMap.forEach((k,v)->{
            System.out.println(k+"=="+v);
        });

    }

    public static void geti(InterfaceDemo i){
        i.f();
    }
}

@FunctionalInterface
interface  InterfaceDemo{
    void f();
}
