package com.singleton.singlton1;

/**
 * 이중 확인 잠금(DCL)
 * 이중 확인 잠금(DCL, Double-Checked Locking)도 있습니다.
 * 인스턴스 생성 여부를 싱글톤 패턴 잠금 전에 한번. 객체를 생성하기 전에 한 번 2번 체크하면
 * 인스턴스가 존재하지 않을 때만 잠금을 걸 수 있기 때문에 앞서 생겼던 문제점을 해결할 수 있습니다.
 */
public class SingletonDoubleLock {

    private volatile SingletonDoubleLock instance;

    private SingletonDoubleLock() {
    }

    public SingletonDoubleLock getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleLock.class) {
                if (instance == null) {
                    instance = new SingletonDoubleLock();
                }
            }
        }
        return instance;
    }
}
