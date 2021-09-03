package com.bgw.common.pool2.sample1;

import org.apache.commons.pool2.ObjectPool;

import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

public class PooledReadUtil {

    private final ObjectPool<StringBuffer> pool;

    public PooledReadUtil(ObjectPool<StringBuffer> pool) {
        this.pool = pool;
    }

    public void test() {
        StringBuffer buf = null;
        try {
            buf = pool.borrowObject();
            System.out.println("buf.hashCode() = " + buf.hashCode());
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (null != buf) {
                    pool.returnObject(buf);
                }
            }
            catch (Exception e) {
                // ignore
            }
        }
    }

    public String readToString(Reader in) throws IOException {
        StringBuffer buf = null;

        try {
            buf = pool.borrowObject();
            for(int c = in.read(); c != -1; c = in.read()) {
                buf.append((char)c);
            }
            return buf.toString();
        }
        catch (IOException ex){
            throw ex;
        }
        catch (Exception ex) {
            throw new RuntimeException("Unable to borrow buffer from pool" + ex.toString());
        }
        finally {
            try {
                in.close();
            }
            catch (Exception e) {
                // ignore
            }

            try {
                if (null != buf) {
                    pool.returnObject(buf);
                }
            } catch (Exception e) {
                // ignore
            }
        }
    }
}
