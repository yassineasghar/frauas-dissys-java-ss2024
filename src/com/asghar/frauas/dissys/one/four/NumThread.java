package com.asghar.frauas.dissys.one.four;

public class NumThread extends Thread {
    private int Number;

    public NumThread(int Number) {
        this.Number = Number;
    }

    public void run(){
        for(int i = 0 ; i < 5; i++){
            System.out.println(Number);
            try{
                Thread.sleep(3000);
            } catch (InterruptedException ie){
                System.out.println(ie.getMessage());
            }
        }
    }
}
