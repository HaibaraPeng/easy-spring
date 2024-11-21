package org.example.spring.core.io;

import cn.hutool.core.io.IoUtil;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Roc
 * @Date 2024/11/21 15:03
 */
public class ResourceLoaderTest {

    @Test
    public void testResourceLoader() throws Exception {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        //加载classpath下的资源
        Resource resource = resourceLoader.getResource("classpath:hello.txt");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        assertEquals(content, "hello world");

        //加载文件系统资源
        resource = resourceLoader.getResource("src/test/resources/hello.txt");
        assertInstanceOf(FileSystemResource.class, resource);
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        assertEquals(content, "hello world");

        //加载url资源
        resource = resourceLoader.getResource("https://www.baidu.com");
        assertInstanceOf(UrlResource.class, resource);
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
}
