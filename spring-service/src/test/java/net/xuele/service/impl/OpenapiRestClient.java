package net.xuele.service.impl;

import net.xuele.service.BaseServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Created by yejunjie on 2017/1/5.
 */
public class OpenapiRestClient extends BaseServiceTest {

    @Autowired
    private RestTemplate restTemplate;
    /**
     * @throws Exception
     */
    @Test
    public void selectStaticInfoForTeacher() throws Exception {

        MultiValueMap<String,String> mm = new LinkedMultiValueMap<>();
        mm.add("aa","11");
        mm.add("bb","22");
        mm.add("cc", "33");
        String url = "http://192.168.3.72:80/openapi";
        String prefix = "/courseware/1000110002/classList";
        URI uri = getTargetURI(url,prefix,mm);
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
    }

    public static URI getTargetURI(String url,String prefix, MultiValueMap params){
        URI targetURI = UriComponentsBuilder.fromUriString(url)
                .path(prefix)
                .queryParams(params)
                .build()
                .encode()
                .toUri();
        return targetURI;
    }
}
