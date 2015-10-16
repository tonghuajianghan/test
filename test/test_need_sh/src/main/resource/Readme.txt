
spring 添加log
	在web应用中为Spring配置log4j
 	Spring的做法是使用一个Servlet Listener，在Web Container启动时把ROOT的绝对路径写到系统变量里，
 	这样log4j的配置文件里就可以用${myAppfuse.root}来表示刚刚设进去的系统变量：
 	log4j.appender.logfile.File=${myAppfuse.root}/logs/mylog.log
 	
 	

