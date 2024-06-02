package com.singleton.singlton1;

/**
 * 멀티스레드 환경에서 인스턴스가 여러개 생길수 있음
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
