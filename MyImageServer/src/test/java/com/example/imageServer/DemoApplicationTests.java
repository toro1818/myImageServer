package com.example.imageServer;

import com.example.imageServer.entity.SysUser;
import com.example.imageServer.repository.SysUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Test
    void contextLoads() {
        Optional<SysUser> user= sysUserRepository.findById(1);
        SysUser user1=user.get();
        System.out.println(user1);
    }

    @Test
    void test1() throws FileNotFoundException {
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        System.out.println(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) {
            path = new File("");
        }
        File upload = new File(path.getAbsolutePath(),"static/upload/");
        System.out.println(upload.getAbsolutePath());
        if(!upload.exists()) {
            System.out.println(123);
            upload.mkdirs();
        }

    }

}
