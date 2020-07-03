package cn.wuxia.leetcode.java.io;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/7/2 11:17
 */
@Slf4j
public class LowerCaseInputStream extends FileInputStream {
    public LowerCaseInputStream(String name) throws FileNotFoundException {
        super(name);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return c == -1 ? c : Character.toLowerCase((char) c);
    }

    public static void main(String... args) {
        try(InputStream in = new LowerCaseInputStream("test.txt")) {
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
