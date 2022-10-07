package hello.core.singleton;

public class SingletonService {

    // 내부에 private으로 자기 자신을 하나 가지고 있는데 static으로-> 클래스 레벨에 올라가기 때문에 하나만
    private static final SingletonService instance = new SingletonService();

    // getInstance()-> instance 리턴하는 메서드
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private로 막아서 외부에서 new로 객체 인스턴스 생성 못하게 막음
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
