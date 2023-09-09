package TesTNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {

    @Parameters("firstName")
    @Test
    public void test(String name){
        System.out.println(name);
    }

    @Parameters({"name","lastName","ZipCode"})
    @Test
    public void test2(String lastName,String name,String zipcode){
        System.out.println(lastName + name + zipcode);
    }
}
