package org.example.spring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Roc
 * @Date 2024/11/21 14:59
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
