package ck.tools.uid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xfvape.uid.UidGenerator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UidGeneratorTest {

    @Autowired
    private UidGenerator cachedUidGenerator;

    @Test
    public void test() {
        long uid = cachedUidGenerator.getUID();
        System.out.println(uid);
    }
}
