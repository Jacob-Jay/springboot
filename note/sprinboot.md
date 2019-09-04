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
   5. 准备上下文
   6. 刷新上下文