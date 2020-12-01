## 简介<br/> 
My-Admin一套简单通用的后台管理系统<br/> 
这是一套简单通用的后台管理系统，主要功能有：权限管理、菜单管理、用户管理，系统设置、接口日志、配置个性菜单等<br/> 
<br/> 项目所有请求均使用AJAX实现，后期便捷改造为前后端分离项目
<br/>权限级别： 细化为URL接口级权限 通过设置权限可动态分配用户接口权限
## 技术栈<br/> 
前端：layui2.5.5  模板：layuimini<br/> 
java后端：SpringBoot2.3.4 + Mybatis +Apache Shiro + MySql <br/> 

##访问地址<br/>
http://xyoyu.cn<br/>
游客账号：visitor  密码：123456

## 仓库地址<br/> 
国外：https://github.com/446197219/my-admin<br/> 
国内：gitee.com暂无<br/> 

## 常见问题<br/>
0、maven下载jar包长时间无反应？
```text
原因：网络原因连不上maven仓库或其他未知原因导致IDE间接性抽风，导致无法下载联网下载jar包

解决：网络原因自行解决，如果网络没问题就不要一直傻傻的等了，重启IDE，让它重新联网下载
```
1、IDE编译报错，识别不到实体类的set、get方法？
```text
原因：项目使用lombok开发，lombok会在生成class字节码文件帮我们生成set、get等方法，java文件没有set、get等方法，IDE索引不到set、get方法所以编译报错

解决：IDE安装lombok插件即可能识别到对应set、get方法，重启生效
``` 
2、数据库文件在哪？
```text
解决：my-admin.sql文件在resources/static/sql下面
```
3、如何启动程序？
```text
解决：等待IDE识别成springboot项目后，在AdminApplication.java中运行main函数启动程序
```
4、测试账号/密码是多少？   
```text
账号/密码

admin/admin
```
5、如何逆向工程生成MybatisMapper？
```text
首先建好数据表，在resources/mybatis-generator/下修改generatorConfig.xml对应表名以及实体名
修改mybatisGeneratorinit.properties 数据源 在Maven 视图下 运行 Plugins/mybatis-generator即可

联系方式 新项目 暂未建群
可添加QQ： 446197219
