package com.padawans.hackaton.backendbankapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.padawans.hackaton.bankapi.application.BankapiApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { BankapiApplication.class })
public class BankapiApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void main() {
        BankapiApplication.main(new String[] {});
    }
}
