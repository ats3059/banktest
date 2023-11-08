package com.example.demo.temp;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

// java.util.regex.Pattern
public class RegexTest {

    @Test
    public void 한글만된다_test() throws Exception {
        String value = "가나ㄱ";
        boolean result = Pattern.matches("^[ㄱ-ㅎ가-힣]+$", value);
        System.out.println("테스트 : " + result);
    }

    @Test
    public void 한글은안된다_test() throws Exception {
        String value = "한글";
        boolean result = Pattern.matches("^[^ㄱ-ㅎ가-힣]*$", value);
        System.out.println("테스트 : " + result);
    }

    @Test
    public void 영어만된다_test() throws Exception {
        String value = "ssar";
        boolean result = Pattern.matches("^[a-zA-Z]+$", value);
        System.out.println(result);
    }

    @Test
    public void 영어는안된다_test() throws Exception {
        String value = "안";
        boolean result = Pattern.matches("^[^a-zA-Z]*$", value);
        System.out.println(result);
    }

    @Test
    public void 영어와숫자만된다_test() throws Exception {
        String value = "ssar23";
        boolean result = Pattern.matches("^[a-zA-Z\\d]+$", value);
        System.out.println("테스트 : " + result);
    }
    
    @Test
    public void 영어와숫자는안된다_test() throws Exception {
        String value = "가나";
        boolean result = Pattern.matches("^[!가-힣]+$", value);
        System.out.println("테스트 : " + result);
    }

    @Test
    public void 영어만되고_길이는최소2최대4이다_test() throws Exception {
        String value = "ssar";
        boolean result = Pattern.matches("^[a-zA-Z]{2,4}$", value);
        System.out.println(result);
    }

    @Test
    public void user_username_test(){
        String username = "ssar111";
        boolean result = Pattern.matches("^[a-zA-Z\\d]{2,20}$", username);
        System.out.println("테스트 : "+result);
    }

    @Test
    public void user_fullName_test() {
        String fullName = "ssar111";
        boolean result = Pattern.matches("^[a-zA-Z가-힣]{1,20}$", fullName);
        System.out.println("테스트 : "+result);
    }

    @Test
    public void user_email_test() {
        String fullName = "ssar111@nate.com";
        boolean result = Pattern.matches("^[a-zA-Z\\d]{2,6}@[a-zA-Z\\d]{2,6}$\\.[a-zA-Z]{2,3}$", fullName);
        System.out.println("테스트 : "+result);
    }

}
