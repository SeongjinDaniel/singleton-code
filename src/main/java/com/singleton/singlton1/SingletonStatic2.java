package com.singleton.singlton1;

/**
 * 정적 블록을 사용한 싱글톤
 */
public class SingletonStatic2 {

    private static SingletonStatic2 instance = new SingletonStatic2();

    static {
        instance = new SingletonStatic2();
    }

    private SingletonStatic2() {
    }

    public static SingletonStatic2 getInstance() {
        return instance;
    }
}
