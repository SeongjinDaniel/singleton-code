# singleton-code

클래스 이름 뒤에 01, 02, 03 이순서로 확인한다.
싱글톤을 사용하는 방법들중에 SingletonInstanceHolder04 클래스의 방법과 Enum을 사용하는 방법을 가장 많이 사용한다.

## 정적 멤버
정적(statiac) 멤버나 블록은 런타임이 아니라 최초에 JVM이 클래스 로딩 때 모든 클래스들을 로드할 때 미리 인스턴스를 생성하는데 이를 이용한 방법입니다.
클래스 로딩과 동시에 싱글톤 인스턴스를 만듭니다. 그렇기 때문에 모듈들이 싱글톤 인스턴스를 요청할 때 그냥 만들어진 인스턴스를 반환하면 되는 것이죠.

이는 불필요한 자원낭비라는 문제점이 있습니다. 싱글톤 인스턴스가 필요없는 경우도 무조건 싱글톤 클래스를 호출해 인스턴스를 만들어야 하기 때문입니다. 이문제는 정적 블록 문제점이기도 합니다.

## volatile
SingletonDoubleLock에 instance라는 변수에 volatile 키워드를 건 것을 볼 수 있는데요.
여기서 instance라는 변수에 volatile 키워드를 건 것을 볼 수 있는데요.
왜 그랬을까요?
메모리 구조는 다음과 같습니다. 메인 메모리 위에 CPU 캐시메모리라고 불리는 L3, L3, L1 캐시가 있습니다. (L4도 드물긴 하지만 L4까지 CPU 캐시 메모리라고 부릅니다.)
<img width="348" alt="image" src="https://github.com/SeongjinOliver/singleton-code/assets/55625864/5e22838b-6445-4e3f-ab93-13b0d97b490c">
JAVA에서는 스레드 2개가 열리면 변수를 메인 메모리(RAM)으로부터 가져오는 것이 아니라 캐시메모리에서 각각의 캐시메모리를 기반으로 가져오게 됩니다.
<img width="476" alt="image" src="https://github.com/SeongjinOliver/singleton-code/assets/55625864/826384fb-4b52-4ecb-bb71-4c93956c0124">
voltile 키워드를 사용하면 Main Memory에 있는 변수를 CPU 캐시메모리에 캐시를 하지 않고 바로 Main Memory에서 가져오게 됩니다.