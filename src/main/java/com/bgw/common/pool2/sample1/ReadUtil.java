package com.bgw.common.pool2.sample1;

import java.io.IOException;
import java.io.Reader;

public class ReadUtil {

    public ReadUtil() {
    }

    public String readToString(Reader in) {
        StringBuffer buf = new StringBuffer();

        try {
            for(int c = in.read(); c != -1; c = in.read()) {
                buf.append((char)c);
            }
            return buf.toString();
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        finally {
            try {
                in.close();
            }
            catch (Exception e) {
                // ignore
            }
        }
    }
}
