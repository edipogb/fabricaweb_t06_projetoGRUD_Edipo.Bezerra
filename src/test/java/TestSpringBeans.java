import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by edipo on 01/10/15.
 */
public class TestSpringBeans {
    public static void main(String args){
        ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
    }
}
