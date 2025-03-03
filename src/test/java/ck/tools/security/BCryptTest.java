package ck.tools.security;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptTest {

    @Test
    public void test() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "admin";
        String encode = encoder.encode(password);
        System.out.println("llll:"+encode);
    }
}
