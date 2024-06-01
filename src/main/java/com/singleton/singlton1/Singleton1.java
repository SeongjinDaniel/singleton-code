package com.singleton.singlton1;

/**
 * 멀티스레드 환경에서 인스턴스가 여러개 생길수 있음
 */
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

}
