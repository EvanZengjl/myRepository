package com.evan.lms.config;

public class RedisUtil {
	
	public @interface RedisCacheable {
	    public enum KeyMode{  
	        DEFAULT,    //只有加了@CacheKey的参数,才加入key后缀中  
	        BASIC,      //只有基本类型参数,才加入key后缀中,如:String,Integer,Long,Short,Boolean  
	        ALL,        //所有参数都加入key后缀  
	        BEAN,       //bean的属性加入KEY后缀
	        MAP;        //Map的属性加入KEY后缀
	    }  

	    public String key() default "";     //缓存key  
	    public KeyMode keyMode() default KeyMode.DEFAULT;       //key的后缀模式  
	    public int expire() default 7200;      //缓存多少秒,默认2个小时
	}

}
