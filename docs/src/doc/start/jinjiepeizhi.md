---
# 这是文章的标题
title: 🛠️进阶配置
# 这是页面的图标
icon: <svg t="1679837826543" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1201" width="200" height="200"><path d="M763.136 958.72H262.656c-50.944 0-92.16-41.216-92.16-92.16V518.144H107.776c-25.6 0-48.128-15.36-57.6-39.168s-3.584-50.432 14.848-68.096c0.256-0.256 0.512-0.512 0.768-0.512l344.064-307.2c56.576-53.248 145.408-53.76 202.496-1.28l346.624 307.2 0.512 0.512c18.944 17.408 25.088 44.288 15.616 68.352-9.472 24.064-32 39.424-57.856 39.424h-61.696v348.928c-0.256 50.944-41.472 92.416-92.416 92.416zM107.52 456.704h93.696c16.896 0 30.72 13.824 30.72 30.72v379.136c0 16.896 13.824 30.72 30.72 30.72h500.48c16.896 0 30.72-13.824 30.72-30.72V486.656c0-16.896 13.824-30.72 30.72-30.72H917.504s0.256-0.512 0.256-0.768l-0.256-0.256-346.368-307.2-0.512-0.512c-33.536-30.976-86.016-30.72-119.04 0.768-0.256 0.256-0.512 0.512-0.768 0.512L107.264 455.68c0 0.256-0.256 0.256-0.256 0.256s0.256 0.512 0.512 0.768c-0.256 0 0 0 0 0z m0 0z" fill="#040000" p-id="1202"></path><path d="M644.608 897.024h-61.44v-218.112c0-16.64-13.824-29.952-30.72-29.952H471.04c-16.896 0-30.72 13.568-30.72 29.952v218.112h-61.44v-218.112c0-50.432 41.216-91.392 92.16-91.392h81.408c50.944 0 92.16 40.96 92.16 91.392v218.112z" fill="#D63123" p-id="1203"></path></svg>
# 这是侧边栏的顺序
order: 3
# 设置作者
author: wind
# 设置写作时间
date: 2023-03-27
# 此页面会在文章列表置顶
sticky: true
# 此页面会出现在文章收藏中
star: true
# 你可以自定义页脚
footer: © 2022 wind <a href="https://beian.miit.gov.cn/#/Integrated/index" target="_blank">冀ICP备2021004949号-3</a>
# 你可以自定义版权信息
# copyright: 无版权
---
### 功能配置

```yaml
sms:
    # 是否开启短信发送限制 默认false
    restricted: false
    # 以下设置仅在开启短信发送限制后生效
    # 是否使用redis进行缓存 默认false
    redis-cache: false
    # 单账号每日最大发送量
    account-max: 20
    # 单账号每分钟最大发送
    minute-max: 2
    #默认厂商配置来源 此处为枚举设置，支持sql和配置文件，默认为从yml配置文件获取，如无需求可不改变
    config-type: config-file
    #启用框架banner打印，默认开启状态
    is-print: true
```

::: tip
发送限制功能依赖于缓存，在工具的内部实现了一个基于内存的缓存，胜在不依赖于任何第三方组件和中间件，
但是目前版本的缓存中并不支持持久化，也就是说在项目进行重启后，缓存的内容会丢失，限制也会消失，
所以在这里如果项目中集成了SpringBoot的redis工具，这里建议开启`redisCache: true`。工具会自动使用redis进行缓存。
:::

### 线程池配置
鉴于很多的短信厂商并不支持异步短信的发送，为了统一一个异步发送的标准功能，我们在工具中添加了一个线程池，异步短信会使用线程池中托管的线程执行。
线程池可以根据自己的需求进行配置，也可以不进行配置使用框架默认的配置。

```yaml
# 以下数值为默认线程池的配置，可以根据自己的需求进行修改
sms:
  #核心线程池大小
  corePoolSize: 10
  #最大线程数
  maxPoolSize: 30
  #队列容量
  queueCapacity: 50
  #设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
  shutdownStrategy: true
```