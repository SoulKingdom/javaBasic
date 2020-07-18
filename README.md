# JavaBasic
java必须了解的基础知识整理
## 基本的排序方法
+ 快速排序（注意事项）
  1. 选择一个基准数，通过一趟排序，小于基数在左，大于基数在右
  2. 然后按照基数进行第二轮排序左右分组，进行递归 
  3. 通过前后对基准数进行比较，首先从左向右
  4. 通过定义开始和结束的点，low和high
  5. 从右向左的判断规则，如果大于基数high左移一位，小于基数high位的值赋值给low位，然后开始从左向右进行
  6. 从左向右的判断规则，如果小于基数low右移一位，大于基数low位得值赋值给high位，然后开始从右向左进行
  7. 然后进行递归
+ 冒泡排序（从小到大）
  1. 两两进行比较，把较大的数放在后面（类似于鱼吐泡泡，把最大的移动到最后）
  2. 然后去掉最后一位，在此进行比较，找到第二大的数（第二个跑）
  3. 以此类图按照从小到大的顺序进行排序
+ 选择排序（从小到大）
  1. 定义一个标识，这个标识为最小值的位置标识。
  2. 循环进行判断，如果比数组标识位置的值小的，那么将比标识位置小的坐标赋值给标识。
  3. 找到一个最小的表示，把这个标识赋值给开始的i的位置
## Java8新特性（目前使用过的）
 + Java重复注解
 + lambda表达式(相当于重写接口方法并且返回重写之后的对象)
 + stream流处理的使用
   - JavaApi教学链接[https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/]
   - list，array和Map中用的比较多
 + 重复注解的使用
## 线程池 ThreadPoolExecutor 测试
### 核心参数
 + corePoolSize 核心线程数量  设置线程数量
 + maximumPoolSize 最大存在的线程数量
 + keepAliveTime 核心线程工作，额外线程的存活时间
 + unit 线程存活时间的单位
 + workQueue 存放线程的任务缓冲队列，核心线程满之后，额外线程任务存放在序列中
 + threadFactory 存放线程的信息格式
 + handler 线程池对拒绝任务的处理策略：ThreadPoolExecutor四种策略方式
   - ThreadPoolExecutor.AbortPolicy
   - ThreadPoolExecutor.DiscardPolicy
   - ThreadPoolExecutor.DiscardOldestPolicy
   - ThreadPoolExecutor.CallerRunsPolicy
   - 自定义拒绝处理方式,继承RejectedExecutionHandler
 + 可处理线程的总数为：任务缓冲序列+最大存在线程数
 + git的使用 
   - 回滚的使用 
     - 

       
