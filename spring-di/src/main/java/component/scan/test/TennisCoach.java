package component.scan.test;

import com.spring.boot.course.spring_di.Coach.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("tennis")
@Primary
public class TennisCoach implements Coach {
    public String workout() {
        return "Hey I am Tennis Coach!!";
    }
}
