package com.singleton.singlton1;

/**
 * 정적 멤버를 이용한 싱글톤
 */
public class SingletonStatic {

    private final static SingletonStatic instance = new SingletonStatic();

    private SingletonStatic() {
    }

    public static SingletonStatic getInstance() {
        return instance;
    }
}
