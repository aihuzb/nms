package com.andi.nms;

import com.andi.nms.business.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void test() throws Exception {

        // 保存字符串
        stringRedisTemplate.opsForValue().set("ccc", "sssss");

        // 保存对象
        User user = new User();
        user.setUsername("huzhibin");
        user.setPassword("123456");
        redisTemplate.opsForValue().set(user.getUsername(), user);


        System.out.println("huzhibin-----"+redisTemplate.opsForValue().get("huzhibin").toString());


    }



    @Test
    public void test1() throws Exception{
        User u1  = new User();
        u1.setUsername("huzhibin1");
        u1.setPassword("123456");
        User u2  = new User();
        u2.setUsername("huzhibin2");
        u2.setPassword("123456");
        User u3  = new User();
        u3.setUsername("huzhibin3");
        u3.setPassword("123456");

        Set<User> set1 = new HashSet<User>();
        set1.add(u1);
        set1.add(u2);
        set1.add(u3);
        redisTemplate.opsForSet().add("key_ul", set1);
        System.out.println("放入缓存》。。。。。。。。。。。。。。。。。。。");
        System.out.println("=============================");
        Set<User> redisList = redisTemplate.opsForSet().members("key_ul");
        System.out.println("resultSet="+redisList);
    }

    /**
     * Map
     */
    @Test
    public void mapOperation() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");
        // 插入
        redisTemplate.opsForHash().putAll("map1", map);

        Map<String, String> resultMap = redisTemplate.opsForHash().entries("map1");
        System.out.println("resultMap:" + resultMap);

        List<String> reslutMapList = redisTemplate.opsForHash().values("map1");
        System.out.println("reslutMapList:" + reslutMapList);

        Set<String> resultMapSet = redisTemplate.opsForHash().keys("map1");
        System.out.println("resultMapSet:" + resultMapSet);

        String value = (String) redisTemplate.opsForHash().get("map1", "key1");
        System.out.println("value:" + value);
    }

    /**
     * List
     */
    @Test
    public void listOperation() {
        List<User> list1 = new ArrayList<User>();
        User u1  = new User();
        u1.setUsername("huzhibin4");
        u1.setPassword("123456");
        list1.add(u1);
        List<User> list2 = new ArrayList<User>();
        User u2  = new User();
        u2.setUsername("huzhibin5");
        u2.setPassword("123456");
        User u3  = new User();
        u3.setUsername("huzhibin6");
        u3.setPassword("123456");
        list2.add(u2);
        list2.add(u3);
        // 插入
        redisTemplate.opsForList().leftPush("listkey1", list1);
        redisTemplate.opsForList().rightPush("listkey2", list2);

        // 取数据
//        List<String> resultList1 = (List<String>) redisTemplate.opsForList().leftPop("listkey1");
//        List<String> resultList2 = (List<String>) redisTemplate.opsForList().rightPop("listkey2");
//        System.out.println("resultList1:" + resultList1);
//        System.out.println("resultList2:" + resultList2);
    }


    @Test
    public void testZSet() throws Exception{
        redisTemplate.opsForZSet().add("ZSet", "andi1",1);
        redisTemplate.opsForZSet().add("ZSet", "andi2",2);
        redisTemplate.opsForZSet().add("ZSet", "andi3",3);
        redisTemplate.opsForZSet().add("ZSet", "andi4",4);
        redisTemplate.opsForZSet().add("ZSet", "andi5",5);

        System.out.println("放入缓存》。。。。。。。。。。。。。。。。。。。");
        System.out.println("=============================");
//        Set<User> redisList = redisTemplate.opsForZSet().range("ZSet",0,-1);
        System.out.println("resultSet="+redisTemplate.opsForZSet().range("ZSet",0,-1));
    }

    @Test
    public void testTopic(){
        stringRedisTemplate.convertAndSend("chat","hello huzhibin");
    }
}
