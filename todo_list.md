# todo

* 将消息做定时删除逻辑，这样每次上传信息都只是增量部分，优化上传的接口，现在io有些多。
* 增加获取临时群消息页面，不做用户系统因为用户一定是机器人的微信好友。需要验证才能看消息，验证的方式就是自己的id以及群里任意三个人的id
* 增加首页，描述这个产品如何使用
* 部署两个实例，提高可用性
* 在抖音上做推广
* 增加管理控制台页面，用来展示现在一共有多少个群，以及是否有人发送消息给机器人
* 数据同步的机制可以30s一次，每30s检查数据库的时间，如果和上次记录的时间不一致（说明有更新）就同步，放心，手机adb又坏不了
* 优化日志存储，只保留固定大小的日志文件