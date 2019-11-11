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
## Java8新特性（目前使用过的）
 + Java重复注解
 + lambda表达式(相当于重写接口方法并且返回重写之后的对象)
 + stream流处理的使用
   - JavaApi教学链接[https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/]
   - list，array和Map中用的比较多
