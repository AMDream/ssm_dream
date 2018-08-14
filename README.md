# ssm_dream
The first ssm demo
#### 搭建SSM框架，其中自定义bean使用注解，第三方bean选择xml配置

配置了两种视图解析器，用于解析jsp和html<br>
InternalResourceViewResolver：这是一个最常用的解析器。通常使用它指定渲染对象为jsp页面。<br>
FreeMarkerViewResolver：Spring与Freemarker整合需要用到的解析器<br>
引入jar包，spring版本4.3.10.RELEASE，freemarker版本2.3.21，起初2.3.20，报错NoSuchMethodError
<br>
与用户交互的页面最好为html，可以不走视图解析器，响应速度会更快

