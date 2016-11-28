package net.xuel.spring.service;

import java.util.List;
import java.util.Set;

/**
 * redis service
 */
public interface OpenApiRedisService {

    /**
     * 通过key删除
     *
     * @param keys
     */
    public long del(String... keys);

    /**
     * 添加key value 并且设置存活时间(byte)
     *
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(byte[] key, byte[] value, long liveTime);

    /**
     * 添加key value 并且设置存活时间
     *
     * @param key
     * @param value
     * @param liveTime
     *            单位秒
     */
    public void set(String key, String value, long liveTime);

    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    public void set(String key, String value);

    /**
     * 添加key value (字节)(序列化)
     *
     * @param key
     * @param value
     */
    public void set(byte[] key, byte[] value);

    /**
     * 获取redis value (String)
     *
     * @param key
     * @return
     */
    public String get(String key);

    /***
     * 获取redis value (byte[])
     * @param key
     * @return
     */
    public byte[] get(byte[] key);

    /**
     * 通过正则匹配keys
     *
     * @param pattern
     * @return
     */
    public Set Setkeys(String pattern);

    /**
     * 检查key是否已经存在
     *
     * @param key
     * @return
     */
    public boolean exists(String key);

    /**
     * 清空redis 所有数据
     *
     * @return
     */
    public String flushDB();

    /**
     * 查看redis里有多少数据
     */
    public long dbSize();

    /**
     * 检查是否连接成功
     *
     * @return
     */
    public String ping();

    /**
     * 插入list对象
     *
     * @param key
     * @param list
     * @param liveTime 存活多久 单位秒
     */
    void push(String key, List list, long liveTime);

    /**
     * (List)插入对象
     * @param key
     * @param object
     * @param liveTime 存活多久 单位秒
     */
    void push(String key, Object object, long liveTime);

    /**
     * 通过key删除list里的object的值
     * @param key
     * @param object
     * @param num 相同的话，删除num个
     */
    void rmList(String key, Object object, int num);

    /**
     * 获取对应key的从start到stop的数据(包括头尾)
     *
     * @param key
     * @param start
     * @param stop  -n 表示到最后第n个元素
     * @return
     */
    List<Object> range(String key, int start, int stop);


}
