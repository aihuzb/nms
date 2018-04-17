package com.andi.nms.sys.shiro;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

public class ShrioRedisCacheManager
        extends AbstractCacheManager {

    private RedisTemplate<byte[], Object> shiroRedisTemplate;

    public ShrioRedisCacheManager(RedisTemplate<byte[], Object> redisTemplate) {
        this.shiroRedisTemplate = redisTemplate;
    }

    @Override
    protected Cache<byte[], Object> createCache(String name) throws CacheException {
        return new ShrioRedisCache<byte[], Object>(shiroRedisTemplate, name);
    }


}
