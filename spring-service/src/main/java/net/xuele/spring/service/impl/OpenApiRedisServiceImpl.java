package net.xuele.spring.service.impl;

import net.xuel.spring.service.OpenApiRedisService;
import net.xuele.spring.service.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OpenApiRedisServiceImpl implements OpenApiRedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    private static String redisCode = "utf-8";

    private OpenApiRedisServiceImpl() {

    }

    /**
     * 通过key删除
     *
     * @param keys
     */
    @Override
    public long del(final String... keys) {
        return (Long) redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                long result = 0;
                for (int i = 0; i < keys.length; i++) {
                    result = connection.del(keys[i].getBytes());
                }
                return result;
            }
        });
    }

    /**
     * 添加key value 并且设置存活时间(byte)
     *
     * @param key
     * @param value
     * @param liveTime
     */
    @Override
    public void set(final byte[] key, final byte[] value, final long liveTime) {
        redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(key, value);
                if (liveTime > 0) {
                    connection.expire(key, liveTime);
                }
                return 1L;
            }
        });
    }

    /**
     * 添加key value 并且设置存活时间
     *
     * @param key
     * @param value
     * @param liveTime
     */
    @Override
    public void set(String key, String value, long liveTime) {
        this.set(key.getBytes(), value.getBytes(), liveTime);
    }

    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    @Override
    public void set(String key, String value) {
        this.set(key, value, 0L);
    }

    /**
     * 添加key value (字节)(序列化)
     *
     * @param key
     * @param value
     */
    @Override
    public void set(byte[] key, byte[] value) {
        this.set(key, value, 0L);
    }

    /**
     * 获取redis value (String)
     *
     * @param key
     * @return
     */
    @Override
    public String get(final String key) {
        return (String) redisTemplate.execute(new RedisCallback() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                try {
                    return new String(connection.get(key.getBytes()), redisCode);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return "";
            }
        });
    }

    @Override
    public byte[] get(final byte[] key) {
        return (byte[]) redisTemplate.execute(new RedisCallback<byte[]>() {
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(key);
            }
        });
    }

    /**
     * 通过正则匹配keys
     *
     * @param pattern
     * @return
     */
    @Override
    public Set Setkeys(String pattern) {
        return redisTemplate.keys(pattern);
    }


    /**
     * 检查key是否已经存在
     *
     * @param key
     * @return
     */
    @Override
    public boolean exists(final String key) {
        return (Boolean) redisTemplate.execute(new RedisCallback() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(key.getBytes());
            }
        });
    }

    /**
     * 清空redis 所有数据
     *
     * @return
     */
    @Override
    public String flushDB() {
        return (String) redisTemplate.execute(new RedisCallback() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
    }

    /**
     * 查看redis里有多少数据
     */
    @Override
    public long dbSize() {
        return (Long) redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.dbSize();
            }
        });
    }

    /**
     * 检查是否连接成功
     *
     * @return
     */
    @Override
    public String ping() {
        return (String) redisTemplate.execute(new RedisCallback() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.ping();
            }
        });
    }

    @Override
    public void push(final String key, final List list, final long liveTime) {
        redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                for (int i = list.size() - 1; i >= 0; i--) {
                    connection.lPush(key.getBytes(), StringUtil.toByteArray(list.get(i)));
                }
                if (liveTime > 0) {
                    connection.pExpire(key.getBytes(), liveTime);
                }
                return 1L;
            }
        });
    }

    @Override
    public void push(final String key, final Object object, final long liveTime) {
        redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                connection.lPush(key.getBytes(), StringUtil.toByteArray(object));
                if (liveTime > 0) {
                    connection.pExpire(key.getBytes(), liveTime);
                }
                return 1L;
            }
        });
    }

    @Override
    public void rmList(final String key, final Object object, final int num){
        redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                connection.lRem(key.getBytes(),num,StringUtil.toByteArray(object));
                return 1L;
            }
        });
    }


    @Override
    public List<Object> range(final String key, final int start, final int stop) {
        return (List<Object>) redisTemplate.execute(new RedisCallback() {
            public List<Object> doInRedis(RedisConnection connection) throws DataAccessException {
                List<byte[]> byteList = connection.lRange(key.getBytes(), start, stop);
                List<Object> list = new ArrayList<Object>();
                if (byteList != null) {
                    for (byte[] bytes : byteList) {
                        Object obj = StringUtil.toObject(bytes);
                        list.add(obj);
                    }
                }
                return list;
            }
        });
    }
}
