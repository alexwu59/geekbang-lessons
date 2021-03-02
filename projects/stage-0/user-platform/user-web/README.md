1. 下载好项目到本地，可以直接在IDEA里运行tomcat maven插件
2. 启动项目后访问 http://localhost:8080/user-web/
3. 在首页页面有register按钮，点击进入注册页面
4. 填写相关注册信息，点提交后把数据存入的数据库中，并且页面展示是数据库中所有的注册用户信息。

> 项目使用JNDI方法访问数据源,具体参考META-INF/context.xml和WEB-INF/web.xml