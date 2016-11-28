package net.xuele.spring.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by cm.wang on 2016/8/18 0001.
 */
public class StringUtil {

    private static Logger logger = LoggerFactory.getLogger(StringUtil.class);


    public static byte[] toByteArray (Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
        } catch (IOException e) {
            logger.error("object转byte出错"+e.getMessage());
        }finally {
            try{
                if(oos != null){
                    oos.close();
                }
                if(bos != null){
                    bos.close();
                }
            }catch (Exception e){
                logger.error(e.getMessage());
            }

        }
        return bytes;
    }

    public static Object toObject (byte[] bytes) {
        Object obj = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream (bis);
            obj = ois.readObject();
        } catch (Exception e) {
            logger.error("byte转object出错"+e.getMessage());
        }finally {
            try{
                if(ois != null){
                    ois.close();
                }
                if(obj != null){
                    bis.close();
                }
            }catch (Exception e){
                logger.error(e.getMessage());
            }
        }
        return obj;
    }
}
