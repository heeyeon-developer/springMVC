package hello.springmvc.basic;

import lombok.Data;

@Data   //@Getter, @Setter, @ToString, @EqualAndHashCode, @RequiredArgsConstructor 를 자동으로 생성해 주는 애노테이션
public class HelloData {
    private String username;
    private int age;
}
