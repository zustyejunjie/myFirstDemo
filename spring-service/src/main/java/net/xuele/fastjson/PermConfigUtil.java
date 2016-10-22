package net.xuele.fastjson;

import com.alibaba.fastjson.JSON;
import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yejunjie on 2016/10/19.
 */
public class PermConfigUtil {

    //权限配置map
    public static Map<String,PermDTO> config = new ConcurrentHashMap<String,PermDTO>();


    //默认加载一次
    static{
        init();
    }

    //重新加载
    public void reLoad(){
        config.clear();
        init();
    }

    private static void init(){
        try {
            InputStream inputStream = PermConfigUtil.class.getClassLoader()
                    .getResourceAsStream("permConfig.json");
            String json = IOUtils.toString(inputStream);
            List<Config> users2 = JSON.parseArray(json, Config.class);

            for(Config config1 : users2){
                config.put(config1.getSpaceType(),config1.getValue());
            }
        }catch (Exception e){
        }
    }

    public static void main(String[] args){
        PermConfigUtil p = new PermConfigUtil();
        PermDTO permDTO = config.get("Class");
        System.out.print(permDTO.getSpace().getBrowse().get(0).getIsCancel());
    }

}
