mybatis
===============
###### 程序定位
1. 熟悉使用idea开发工具
2. 在idea中使用maven创建mybatis项目
3. 学习mybatis的增删改查操作
4. 学习编写规范的README.md文件、
5. 完成IDEA配合GitHub管理本地代码，实现更新本地代码到GitHub上
代码供个人学习使用  

###### 环境依赖
1. JDK 1.8
2. mysql 8.0.11
3. apache-maven-3.3.9
4. mybatis 3.4.6
  
###### V1.0.0 版本内容更新
1. 使用MyBatis完成数据的插入操作
2. 使用MyBatis完成数据的更新操作
3. 使用MyBatis完成数据的查询操作
4. 使用MyBatis完成数据的删除操作

###### TABLE
```sql
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `userAge` int(11) DEFAULT NULL,
  `userAddress` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'summer', '30', 'shanghai');
INSERT INTO `user` VALUES ('2', 'test2', '22', 'suzhou');
INSERT INTO `user` VALUES ('3', 'test1', '29', 'some place');
INSERT INTO `user` VALUES ('4', 'lu', '28', 'some place');
INSERT INTO `user` VALUES ('5', 'xiaoxun', '27', 'nanjing');

```
