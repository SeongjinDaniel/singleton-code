package com.singleton.singlton1;

public class YunhaSyncronize {

    private static String yunha = "오르트구름";

    public static void main(String[] args) {
        YunhaSyncronize a = new YunhaSyncronize();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a.say("사건의 지평선");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a.say("오르트 구름");
            }
        }).start();
    }

    public synchronized void say(String song) {
        yunha = song;
        try {
            Long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!yunha.equals(song)) {
            System.out.println(song + " | " + yunha);
        }
    }
}
