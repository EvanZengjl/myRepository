package com.evan.lms.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{
	
	@Bean
	public KeyGenerator keyGenerator() {
	    return new KeyGenerator() {
	        public Object generate(Object target, Method method, Object... params) {
	            if (params.length == 0) {
	                return "reids_" + method.getName();
	            }
	            if (params.length == 1) {
	                Object param = params[0];
	                if (param != null && !param.getClass().isArray()) {
	                    return "reids_" + method.getName() + "_" + param;
	                }
	            }
	            return "reids_" + method.getName() + " [" + StringUtils.arrayToCommaDelimitedString(params) + "]";
	        }
	    };
	}
	
	
	
	@Bean
    public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        //设置缓存过期时间 
        cacheManager.setDefaultExpiration(10000);
        return cacheManager;
    }

	@Bean  
    public JedisConnectionFactory redisConnectionFactory() {  
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();  
  
        // Defaults  
        redisConnectionFactory.setHostName("127.0.0.1");  
        redisConnectionFactory.setPort(6379);  
        return redisConnectionFactory;  
    }  
	  /*  @Bean
	    public RedisTemplate<String, String> stringRedisTemplate(RedisConnectionFactory factory){
	        StringRedisTemplate template = new StringRedisTemplate(factory);
	        setSerializer(template);//设置序列化工具
	        template.afterPropertiesSet();
	        return template;
	    }*/
	  /*  @Bean
	    public RedisTemplate<String, Person> redisTemplate(RedisConnectionFactory factory){
	    	RedisTemplate<String, Person> template = new RedisTemplate<String, Person>();
	    	template.setConnectionFactory(factory);//设置序列化工具
	    	template.setKeySerializer(new Jackson2JsonRedisSerializer<Long>(Long.class));
	    	template.setKeySerializer(new StringRedisSerializer());
	    	template.setValueSerializer(new Jackson2JsonRedisSerializer<Person>(Person.class));
	    	return template;
	    }*/
	    @Bean
		public RedisTemplate<Object, Object> redisTemplate(JedisConnectionFactory connectionFactory){
			RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object,Object>();
			redisTemplate.setConnectionFactory(connectionFactory);
			@SuppressWarnings({ "rawtypes", "unchecked" })
			Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
			ObjectMapper om = new ObjectMapper();
			om.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);
			om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
			jackson2JsonRedisSerializer.setObjectMapper(om);
			
			redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
			redisTemplate.setKeySerializer(new StringRedisSerializer());
			return redisTemplate;
			
		}
//	     public void setSerializer(StringRedisTemplate template){
//	            @SuppressWarnings({ "rawtypes", "unchecked" })
//	            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//	            ObjectMapper om = new ObjectMapper();
//	            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//	            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//	            jackson2JsonRedisSerializer.setObjectMapper(om);
//	            template.setValueSerializer(jackson2JsonRedisSerializer);
//	     }
	
	

}
