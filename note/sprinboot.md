springboot

# 注解

1. EnableAutoConfiguration：开启自动配置，通过类路径上的jar文件推测需要的bean，如果没有自己配置相对应的bean，就会自动生成一个
2. EnableConfigurationProperties 将属性类注入容器中





# 启动步骤

1. 创建springapplication

   ![1567582122516](/createSpringApplication)

2. springapplication.run()

   1. 获取SpringApplicationRunListener并发布starting事件
   
   2. 准备环境 并发布environmentPrepared事件
   
   3. 打印banner
   
   4. 创建上下文对象，仅仅是创建
   
      ```java
      Class<?> contextClass = this.applicationContextClass;
      		if (contextClass == null) {
      			try {
      				switch (this.webApplicationType) {
      				case SERVLET:
      					contextClass = Class.forName(DEFAULT_SERVLET_WEB_CONTEXT_CLASS);
      					break;
      				case REACTIVE:
      					contextClass = Class.forName(DEFAULT_REACTIVE_WEB_CONTEXT_CLASS);
      					break;
      				default:
      					contextClass = Class.forName(DEFAULT_CONTEXT_CLASS);
      				}
      			}
      			catch (ClassNotFoundException ex) {
      				throw new IllegalStateException(
      						"Unable create a default ApplicationContext, " + "please specify an ApplicationContextClass",
      						ex);
      			}
      		}
      		return (ConfigurableApplicationContext) BeanUtils.instantiateClass(contextClass);
      ```
   
      
   
   5. 准备上下文
   
      1. 设置环境
      2. 后置处理（设置类型转换器convert）
      3. 使用获取到的初始化器初始化上下文![1567601411800](/initContext)
      4. 发布上下文prepared事件
      5. 加载主类到容器
      6. 发布上下文contextLoaded事件
   
   6. 刷新上下文
   
      1. ```java
         // Initialize other special beans in specific context subclasses.
         onRefresh(); 
         protected void onRefresh() {
         		super.onRefresh();
         		try {
         			createWebServer();//创建web服务器
         		}
         		catch (Throwable ex) {
         			throw new ApplicationContextException("Unable to start web server", ex);
         		}
         	}
         ```
   
   7. 

![1567608466310](/debug)