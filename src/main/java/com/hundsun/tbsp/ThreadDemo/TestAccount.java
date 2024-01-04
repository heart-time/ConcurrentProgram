package com.hundsun.tbsp.ThreadDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAccount {
    public static void main(String[] args) {
        UnsafeAccount unsafeAccount=new UnsafeAccount(10000);
        Account.demo(unsafeAccount);
        AccountCAS accountCAS=new AccountCAS(10000);
        Account.demo(accountCAS);
    }

    @Test
   public  void test(){
        System.out.println(Math.pow(16, 32));
        String  s="study";
        int end=s.length();
        System.out.println(s.substring(end + 1));
    }

    @Test
    public void test2(){

                String amountString = "123457889";

                char[] digits = amountString.toCharArray();

                int billion = 0;
                int hundredMillion = 0;
                int tenMillion = 0;
                int million = 0;
                int hundredThousand = 0;
                int tenThousand = 0;
                int thousand = 0;
                int hundred = 0;
                int ten = 0;
                int unit = 0;

                for(int i = 0; i < digits.length; i++) {
                    int digit = Character.getNumericValue(digits[i]);
                    switch(digits.length - i) {
                        case 10:
                            billion = digit;
                            break;
                        case 9:
                            hundredMillion = digit;
                            break;
                        case 8:
                            tenMillion = digit;
                            break;
                        case 7:
                            million = digit;
                            break;
                        case 6:
                            hundredThousand = digit;
                            break;
                        case 5:
                            tenThousand = digit;
                            break;
                        case 4:
                            thousand = digit;
                            break;
                        case 3:
                            hundred = digit;
                            break;
                        case 2:
                            ten = digit;
                            break;
                        case 1:
                            unit = digit;
                            break;
                        default:
                            System.out.println("金额字符串长度不正确");
                            return;
                    }
                }

                System.out.println("亿位: " + billion);
                System.out.println("千万位: " + hundredMillion);
                System.out.println("百万位: " + tenMillion);
                System.out.println("十万位: " + million);
                System.out.println("千位: " + hundredThousand);
                System.out.println("百位: " + tenThousand);
                System.out.println("十位: " + thousand);
                System.out.println("个位: " + hundred);
                System.out.println("十分位: " + ten);
                System.out.println("百分位: " + unit);
            }


}

class  AccountCAS implements  Account{
    private AtomicInteger balance;
    public AccountCAS(Integer account){
        balance=new AtomicInteger(account);
    }
    @Override
    public Integer getBalance() {
        return balance.get();
    }

    @Override
    public void withDraw(Integer account) {
//         while (true){
//             int pre=this.balance.get();
//             int next=pre-account;
//             if (balance.compareAndSet(pre,next)) {
//                 break;
//             }
//         }
        balance.updateAndGet(value->value-account);
    }
}
class  UnsafeAccount implements  Account{
    private  Integer balance;

    public UnsafeAccount(Integer balance){
        this.balance=balance;
    }

    @Override
    public Integer getBalance() {
        return this.balance;
    }

    @Override
    public  synchronized void  withDraw(Integer account) {
         this.balance-=account;
    }
}

interface  Account{

    //获取余额
    Integer getBalance();


    void withDraw(Integer account);
    static void demo(Account account){

        List<Thread> list=new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Thread(()->{
                account.withDraw(10);
            }));
        }

        list.forEach(Thread::start);
        long startTime = System.nanoTime();
        list.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        long endTime = System.nanoTime();
        //1000_000<=>1000000 可读性变强
        System.out.println("余额有:"+account.getBalance()+"运行时间:"+(endTime-startTime)/1000);
    }
}
