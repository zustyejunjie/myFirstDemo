package net.xuele.jsonlib;

import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * Created by yejunjie on 2016/10/19.
 */
public class XmlToJava {


    public void readXML2Object() {

        XMLSerializer xmlSerializer = new XMLSerializer();


        String[] sa = {"a", "b", "c"};

        jsonArray = (JSONArray) xmlSerializer.read(xmlSerializer.write(JSONArray.fromObject(sa)));


        String[] s = (String[]) JSONArray.toArray(jsonArray, String.class);

        fail(s[0].toString());

        fail("============== XML >>>> Java boolean Array ==================");

        boolean[] bo = { true, false, true };

        jsonArray = (JSONArray) xmlSerializer.read(xmlSerializer.write(JSONArray.fromObject(bo)));

        bo = (boolean[]) JSONArray.toArray(jsonArray, boolean.class);


        System.out.println(bo[0]);

        jsonArray = (JSONArray) xmlSerializer.read(xmlSerializer.write(JSONSerializer.toJSON(bo)));

        bo = (boolean[]) JSONArray.toArray(jsonArray, boolean.class);

        fail(bo.toString());

        System.out.println(bo[0]);

        fail("==============Java Object Array >>> JSON Array ==================");

        Object[] o = { 1, "a", true, 'A', sa, bo };

        jsonArray = (JSONArray) xmlSerializer.read(xmlSerializer.write(JSONArray.fromObject(o)));

        System.out.println(jsonArray.getInt(0));

        System.out.println(jsonArray.get(1));

        System.out.println(jsonArray.getBoolean(2));

        jsonArray = (JSONArray) xmlSerializer.read(xmlSerializer.write(JSONSerializer.toJSON(o)));

        System.out.println(jsonArray.get(4));

        System.out.println(jsonArray.getJSONArray(5).get(0));

        System.out.println(jsonArray.get(5));

        fail("==============Java String >>> JSON ==================");

        jsonArray = (JSONArray) xmlSerializer.read(xmlSerializer.write(JSONArray.fromObject("['json','is','easy']")).toString());

        s = (String[]) JSONArray.toArray(jsonArray, String.class);

        fail(s[0].toString());

        jsonObject = (JSONObject) xmlSerializer.read(xmlSerializer.write(JSONObject.fromObject("{'json':'is easy'}")).toString());

        Object obj = JSONObject.toBean(jsonObject);

        System.out.println(obj);

        jsonArray = (JSONArray) xmlSerializer.read(xmlSerializer.write(JSONSerializer.toJSON("['json','is','easy']")).toString());

        s = (String[]) JSONArray.toArray(jsonArray, String.class);

        fail(s[1].toString());

    }
}
