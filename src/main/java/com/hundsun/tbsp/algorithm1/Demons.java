package com.hundsun.tbsp.algorithm1;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm1
 * @Description
 * @date 2024/3/19 15:17
 */
public class Demons extends  ClassLoader{

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    public static void main(String[] args) {
        ClassLoader classLoader = Demons.class.getClassLoader();
        StringBuilder sb = new StringBuilder("|--");
        boolean flag = true;
        while(flag){
            System.out.println(sb.toString() + classLoader);
            if (classLoader ==null){
                flag =false;
            }else {
                classLoader = classLoader.getParent();
                sb.insert(0,"\t");
            }
        }
    }
}
