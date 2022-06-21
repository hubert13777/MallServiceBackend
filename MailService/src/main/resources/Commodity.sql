SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Commodity
-- ----------------------------
DROP TABLE IF EXISTS `Commodity`;
CREATE TABLE `Commodity`  (
  `goodsId` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goodsName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '临时商品',
  `message` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品信息',
  `tabs` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `description` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '宣传描述',
  `price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 99.99,
  `pictureUrl1` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pictureUrl2` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pictureUrl3` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `specification` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '细节',
  `generateInformation` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `iconUrl` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`goodsId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Commodity
-- ----------------------------
INSERT INTO `Commodity` VALUES (1, '披萨', '半成品加热即食马苏里拉芝士奶酪饼胚', '果味醇香 / 奶味香浓 / 个大质优 / 日期新鲜', '丰富馅料，十足享受', 39.90, 'http://42.192.198.61:8109/MailService/images/pizza/pizza_1.png', 'http://42.192.198.61:8109/MailService/images/pizza/pizza_2.png', 'http://42.192.198.61:8109/MailService/images/pizza/pizza_3.png', '保质期：30天\n净含量：564g\n产地：浙江省嘉兴市\n存储方式：-18℃', '手工烤制，意式风情', 'https://s2.loli.net/2022/02/11/RNKOidF1ISJaqup.png');
INSERT INTO `Commodity` VALUES (2, '牙刷套餐', '48孔软毛经典宽头牙刷成人软毛牙刷', '质量上乘 / 手感良好 / 不易变形 / 刷头柔软', '速净护龈, 明星同款', 19.90, 'http://42.192.198.61:8109/MailService/images/toothbrush/toothbrush_1.jpg', 'http://42.192.198.61:8109/MailService/images/toothbrush/toothbrush_2.jpg', 'http://42.192.198.61:8109/MailService/images/toothbrush/toothbrush_3.jpg', '刷毛分类: 超软毛\n刷头分类: 宽刷头\n产地: 中国江苏扬州市', '清洁口气，你我更亲近', 'https://s2.loli.net/2022/02/11/uDTEahpvb124Qyj.png');
INSERT INTO `Commodity` VALUES (3, '饮料', '柠檬混合口味果汁水果饮料250ml无添加', '果味醇香 / 口感不错 / 味道纯正 / 天然鲜榨', '鲜榨果汁，天然零添加', 6.50, 'http://42.192.198.61:8109/MailService/images/drinks/drinks_1.png', 'http://42.192.198.61:8109/MailService/images/drinks/drinks_2.png', 'http://42.192.198.61:8109/MailService/images/drinks/drinks_3.png', '保质期：1天\n净含量：250ml\n产地：湖南省长沙市\n存储方式：当天饮用', '来！畅饮年轻这一杯', 'https://s2.loli.net/2022/02/11/dBMk5TzpwxSsNeE.png');
INSERT INTO `Commodity` VALUES (4, '游戏手柄', '无线控制器Steam手柄PC游戏', '质量上乘 / 手感舒适 / 外观精致 / 配件齐全', '蓝牙连接, 精准反馈', 899.00, 'http://42.192.198.61:8109/MailService/images/gamepad/gamepad_1.jpg', 'http://42.192.198.61:8109/MailService/images/gamepad/gamepad_2.jpg', 'http://42.192.198.61:8109/MailService/images/gamepad/gamepad_3.jpg', '即插即用: 支持\n连接方式: 无线\n净重量: 180克', '用双手成就你的梦想', 'https://s2.loli.net/2022/02/11/STP8ZVhkCnM1UJb.png');
INSERT INTO `Commodity` VALUES (5, '咖啡', '马来西亚进口旧街场浓醇味白咖啡', '味香浓郁 / 口感香醇 / 外观精致 / 提神醒脑', '深度烘焙, 经典流传', 9.90, 'http://42.192.198.61:8109/MailService/images/coffee/coffee_1.jpg', 'http://42.192.198.61:8109/MailService/images/coffee/coffee_2.jpg', 'http://42.192.198.61:8109/MailService/images/coffee/coffee_3.jpg', '产地: 马来西亚\n是否添加糖: 添加糖\n是否含咖啡因: 含咖啡因', '在该奋斗的年纪打起精神', 'https://s2.loli.net/2022/02/11/6WxV9TiYsFpMoku.png');
INSERT INTO `Commodity` VALUES (6, '蔬菜', '混合什锦菜三色蔬菜美式杂菜新鲜包菜玉米胡萝卜', '富含营养 / 新鲜美味 / 分量充足 / 清脆爽口', '产地直采, 时令蔬菜', 3.50, 'http://42.192.198.61:8109/MailService/images/vegetable/vegetable_1.jpg', 'http://42.192.198.61:8109/MailService/images/vegetable/vegetable_2.jpg', 'http://42.192.198.61:8109/MailService/images/vegetable/vegetable_3.jpg', '原产地: 中国吉林松原市\n是否有机: 有机\n净含量: 1000克', '绿色健康,有机无添加', 'https://s2.loli.net/2022/02/11/GNjaVsWU5AetTLc.png');

SET FOREIGN_KEY_CHECKS = 1;
