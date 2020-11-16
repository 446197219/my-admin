/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 127.0.0.1:3306
 Source Schema         : my-admin

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 16/11/2020 14:43:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu`  (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单名',
  `pMenuId` int(11) NULL DEFAULT NULL COMMENT '父节点ID',
  `planType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '平台号 (  web前台、后台管理）',
  `nodeType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '节点类型 1：菜单 2：按钮',
  `menuUrl` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '跳转的url',
  `target` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `picUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `seqNo` int(11) NULL DEFAULT NULL COMMENT '顺序号',
  `isshow` int(1) NULL DEFAULT NULL COMMENT '是否显示 0:显示 1:不显示',
  PRIMARY KEY (`menuId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------
INSERT INTO `t_sys_menu` VALUES (1, '主页模板', 0, NULL, '1', '', '_self', 'fa fa-home', 0, 0);
INSERT INTO `t_sys_menu` VALUES (2, '主页一', 1, NULL, '1', 'page/welcome-1.html', '_self', 'fa fa-tachometer', 0, 0);
INSERT INTO `t_sys_menu` VALUES (3, '主页二', 1, NULL, '1', 'page/welcome-2.html', '_self', 'fa fa-tachometer', 0, 0);
INSERT INTO `t_sys_menu` VALUES (4, '主页三', 1, NULL, '1', 'page/welcome-3.html', '_self', 'fa fa-tachometer', 0, 0);
INSERT INTO `t_sys_menu` VALUES (5, '菜单管理', 33, NULL, '1', 'page/sys/menu/menu.html', '_self', 'fa fa-window-maximize', 0, 0);
INSERT INTO `t_sys_menu` VALUES (6, '系统设置', 0, NULL, '1', 'page/setting.html', '_self', 'fa fa-window-fa fa-gears', 0, 0);
INSERT INTO `t_sys_menu` VALUES (7, '表格示例', 0, NULL, '1', 'page/table.html', '_self', 'fa fa-file-text', 0, 0);
INSERT INTO `t_sys_menu` VALUES (8, '表单示例', 0, NULL, '1', NULL, '_self', 'fa fa-calendar', 0, 0);
INSERT INTO `t_sys_menu` VALUES (9, '普通表单', 8, NULL, '1', 'page/form.html', '_self', 'fa fa-list-alt', 0, 0);
INSERT INTO `t_sys_menu` VALUES (10, '分步表单', 8, NULL, '1', 'page/form-step.html', '_self', 'fa fa-navicon', 0, 0);
INSERT INTO `t_sys_menu` VALUES (11, '登录模板', 0, NULL, '1', NULL, '_self', 'fa fa-flag-o', 0, 0);
INSERT INTO `t_sys_menu` VALUES (12, '登录-1', 11, NULL, '1', 'page/login-1.html', '_blank', 'fa fa-stumbleupon-circle', 0, 0);
INSERT INTO `t_sys_menu` VALUES (13, '登录-2', 11, NULL, '1', 'page/login-2.html', '_blank', 'fa fa-viacoin', 0, 0);
INSERT INTO `t_sys_menu` VALUES (14, '登录-3', 11, NULL, '1', 'page/login-3.html', '_blank', 'fa fa-tags', 0, 0);
INSERT INTO `t_sys_menu` VALUES (15, '异常页面', 0, NULL, '1', NULL, '_self', 'fa fa-home', 0, 0);
INSERT INTO `t_sys_menu` VALUES (16, '404页面', 15, NULL, '1', 'page/404.html', '_self', 'fa fa-hourglass-end', 0, 0);
INSERT INTO `t_sys_menu` VALUES (17, '其它界面', 0, NULL, '1', NULL, '', 'fa fa-snowflake-o', 0, 0);
INSERT INTO `t_sys_menu` VALUES (18, '按钮示例', 17, NULL, '1', 'page/button.html', '_self', 'fa fa-snowflake-o', 0, 0);
INSERT INTO `t_sys_menu` VALUES (19, '弹出层', 17, NULL, '1', 'page/layer.html', '_self', 'fa fa-shield', 0, 0);
INSERT INTO `t_sys_menu` VALUES (20, '组件管理', 0, NULL, '1', NULL, '_self', 'fa fa-lemon-o', 0, 0);
INSERT INTO `t_sys_menu` VALUES (21, '图标列表', 20, NULL, '1', 'page/icon.html', '_self', 'fa fa-dot-circle-o', 0, 0);
INSERT INTO `t_sys_menu` VALUES (22, '图标选择', 20, NULL, '1', 'page/icon-picker.html', '_self', 'fa fa-adn', 0, 0);
INSERT INTO `t_sys_menu` VALUES (23, '颜色选择', 20, NULL, '1', 'page/color-select.html', '_self', 'fa fa-dashboard', 0, 0);
INSERT INTO `t_sys_menu` VALUES (24, '下拉选择', 20, NULL, '1', 'page/table-select.html', '_self', 'fa fa-angle-double-down', 0, 0);
INSERT INTO `t_sys_menu` VALUES (25, '文件上传', 20, NULL, '1', 'page/upload.html', '_self', 'fa fa-arrow-up', 0, 0);
INSERT INTO `t_sys_menu` VALUES (26, '富文本编辑器', 20, NULL, '1', 'page/editor.html', '_self', 'fa fa-edit', 0, 0);
INSERT INTO `t_sys_menu` VALUES (27, '省市县区选择器', 20, NULL, '1', 'page/area.html', '_self', 'fa fa-rocket', 0, 0);
INSERT INTO `t_sys_menu` VALUES (30, '失效菜单', 0, NULL, '1', 'page/error.html', '_self', 'fa fa-superpowers', 0, 0);
INSERT INTO `t_sys_menu` VALUES (31, '微信菜单管理', 34, NULL, '1', 'page/sys/menu/wx/menu.html', '_self', 'fa fa-window-maximize', 0, 0);
INSERT INTO `t_sys_menu` VALUES (32, '关键词回复', 34, NULL, '1', 'page/sys/remsg/remsgTable1.html', '_self', 'fa fa-window-maximize', 0, 0);
INSERT INTO `t_sys_menu` VALUES (33, '系统管理', 0, NULL, '1', '', '_self', 'fa fa-window-fa fa-gears', -1, 0);
INSERT INTO `t_sys_menu` VALUES (34, '微信后台管理', 0, NULL, '1', '', '_self', 'fa fa-window-fa fa-gears', 0, 0);
INSERT INTO `t_sys_menu` VALUES (36, '角色管理', 33, NULL, '1', 'page/sys/role/role.html', '_self', NULL, NULL, 0);
INSERT INTO `t_sys_menu` VALUES (37, '用户管理', 33, NULL, '1', 'page/sys/user/user.html', '_self', NULL, NULL, 0);
INSERT INTO `t_sys_menu` VALUES (43, '新增', 5, NULL, '2', '/menu/addMenu', '_self', 'fa fa-window-maximize', NULL, 0);
INSERT INTO `t_sys_menu` VALUES (44, '修改', 5, NULL, '2', '/menu/updateMenu', '_self', 'fa fa-window-maximize', NULL, 0);
INSERT INTO `t_sys_menu` VALUES (45, '删除', 5, NULL, '2', '/menu/deleteMenuById', '_self', 'fa fa-window-maximize', NULL, 0);
INSERT INTO `t_sys_menu` VALUES (46, '删除', 36, NULL, '2', '/role/deleteRoleByIds', '_self', 'fa fa-window-maximize', NULL, 0);
INSERT INTO `t_sys_menu` VALUES (47, '新增', 36, NULL, '2', '/role/saveRole', '_self', 'fa fa-window-maximize', NULL, 0);
INSERT INTO `t_sys_menu` VALUES (48, '修改', 36, NULL, '2', '/role/updateRoleById', '_self', 'fa fa-window-maximize', NULL, 0);
INSERT INTO `t_sys_menu` VALUES (49, '权限绑定', 36, NULL, '2', '/role/updateMenuRoleAuth', '_self', 'fa fa-window-maximize', NULL, 0);
INSERT INTO `t_sys_menu` VALUES (50, '新增', 37, NULL, '2', '/user/saveUser', '_self', 'fa fa-window-maximize', NULL, 0);
INSERT INTO `t_sys_menu` VALUES (51, '注销/恢复', 37, NULL, '2', '/user/updateStateUserByIds', '_self', 'fa fa-window-maximize', NULL, 0);
INSERT INTO `t_sys_menu` VALUES (52, '删除', 37, NULL, '2', '/user/deleteUserByIds', '_self', 'fa fa-window-maximize', NULL, 0);
INSERT INTO `t_sys_menu` VALUES (53, '请求日志', 33, NULL, '1', 'page/sys/requestLog/requestLog.html', '_self', 'fa fa-window-maximize', NULL, 0);

-- ----------------------------
-- Table structure for t_sys_menu_auth
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu_auth`;
CREATE TABLE `t_sys_menu_auth`  (
  `id` int(11) NOT NULL COMMENT '关联id',
  `subid` int(11) NULL DEFAULT NULL COMMENT '用户或者角色id',
  `type` int(1) NULL DEFAULT NULL COMMENT '1 为用户权限 2为角色权限',
  `menuid` int(11) NULL DEFAULT NULL COMMENT '菜单id',
  `createtime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_menu_auth
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_request_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_request_log`;
CREATE TABLE `t_sys_request_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `method` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `params` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `userid` int(11) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 144 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_request_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `rolename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `status` int(1) NULL DEFAULT NULL COMMENT '1:有效 2:删除',
  `createtime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES (1, '系统管理员', '系统管理员啊水水水水水水水水水水水水水水水水水水啊水水水水水水', NULL, NULL, NULL);
INSERT INTO `t_sys_role` VALUES (2, '22', '22', NULL, '2020-11-12 10:34:40', NULL);
INSERT INTO `t_sys_role` VALUES (3, '测试', '测试角色2', NULL, '2020-11-13 16:21:39', '2020-11-13 16:43:53');

-- ----------------------------
-- Table structure for t_sys_rolemenu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_rolemenu`;
CREATE TABLE `t_sys_rolemenu`  (
  `roleid` int(11) NOT NULL COMMENT '角色ID',
  `menuid` int(11) NOT NULL COMMENT '菜单ID'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_rolemenu
-- ----------------------------
INSERT INTO `t_sys_rolemenu` VALUES (2, 5);
INSERT INTO `t_sys_rolemenu` VALUES (1, 33);
INSERT INTO `t_sys_rolemenu` VALUES (1, 36);
INSERT INTO `t_sys_rolemenu` VALUES (1, 46);
INSERT INTO `t_sys_rolemenu` VALUES (1, 47);
INSERT INTO `t_sys_rolemenu` VALUES (1, 48);
INSERT INTO `t_sys_rolemenu` VALUES (1, 49);
INSERT INTO `t_sys_rolemenu` VALUES (1, 37);
INSERT INTO `t_sys_rolemenu` VALUES (1, 50);
INSERT INTO `t_sys_rolemenu` VALUES (1, 51);
INSERT INTO `t_sys_rolemenu` VALUES (1, 52);
INSERT INTO `t_sys_rolemenu` VALUES (1, 53);
INSERT INTO `t_sys_rolemenu` VALUES (1, 5);
INSERT INTO `t_sys_rolemenu` VALUES (1, 43);
INSERT INTO `t_sys_rolemenu` VALUES (1, 44);
INSERT INTO `t_sys_rolemenu` VALUES (1, 45);
INSERT INTO `t_sys_rolemenu` VALUES (1, 1);
INSERT INTO `t_sys_rolemenu` VALUES (1, 2);
INSERT INTO `t_sys_rolemenu` VALUES (1, 3);
INSERT INTO `t_sys_rolemenu` VALUES (1, 4);
INSERT INTO `t_sys_rolemenu` VALUES (1, 6);
INSERT INTO `t_sys_rolemenu` VALUES (1, 7);
INSERT INTO `t_sys_rolemenu` VALUES (1, 8);
INSERT INTO `t_sys_rolemenu` VALUES (1, 9);
INSERT INTO `t_sys_rolemenu` VALUES (1, 10);
INSERT INTO `t_sys_rolemenu` VALUES (1, 11);
INSERT INTO `t_sys_rolemenu` VALUES (1, 12);
INSERT INTO `t_sys_rolemenu` VALUES (1, 13);
INSERT INTO `t_sys_rolemenu` VALUES (1, 14);
INSERT INTO `t_sys_rolemenu` VALUES (1, 15);
INSERT INTO `t_sys_rolemenu` VALUES (1, 16);
INSERT INTO `t_sys_rolemenu` VALUES (1, 17);
INSERT INTO `t_sys_rolemenu` VALUES (1, 18);
INSERT INTO `t_sys_rolemenu` VALUES (1, 19);
INSERT INTO `t_sys_rolemenu` VALUES (1, 20);
INSERT INTO `t_sys_rolemenu` VALUES (1, 21);
INSERT INTO `t_sys_rolemenu` VALUES (1, 22);
INSERT INTO `t_sys_rolemenu` VALUES (1, 23);
INSERT INTO `t_sys_rolemenu` VALUES (1, 24);
INSERT INTO `t_sys_rolemenu` VALUES (1, 25);
INSERT INTO `t_sys_rolemenu` VALUES (1, 26);
INSERT INTO `t_sys_rolemenu` VALUES (1, 27);
INSERT INTO `t_sys_rolemenu` VALUES (1, 30);
INSERT INTO `t_sys_rolemenu` VALUES (1, 34);
INSERT INTO `t_sys_rolemenu` VALUES (1, 31);
INSERT INTO `t_sys_rolemenu` VALUES (1, 32);
INSERT INTO `t_sys_rolemenu` VALUES (3, 33);
INSERT INTO `t_sys_rolemenu` VALUES (3, 36);
INSERT INTO `t_sys_rolemenu` VALUES (3, 37);
INSERT INTO `t_sys_rolemenu` VALUES (3, 53);
INSERT INTO `t_sys_rolemenu` VALUES (3, 5);
INSERT INTO `t_sys_rolemenu` VALUES (3, 1);
INSERT INTO `t_sys_rolemenu` VALUES (3, 6);
INSERT INTO `t_sys_rolemenu` VALUES (3, 7);
INSERT INTO `t_sys_rolemenu` VALUES (3, 8);
INSERT INTO `t_sys_rolemenu` VALUES (3, 9);
INSERT INTO `t_sys_rolemenu` VALUES (3, 10);
INSERT INTO `t_sys_rolemenu` VALUES (3, 11);
INSERT INTO `t_sys_rolemenu` VALUES (3, 12);
INSERT INTO `t_sys_rolemenu` VALUES (3, 13);
INSERT INTO `t_sys_rolemenu` VALUES (3, 14);
INSERT INTO `t_sys_rolemenu` VALUES (3, 15);
INSERT INTO `t_sys_rolemenu` VALUES (3, 16);
INSERT INTO `t_sys_rolemenu` VALUES (3, 17);
INSERT INTO `t_sys_rolemenu` VALUES (3, 18);
INSERT INTO `t_sys_rolemenu` VALUES (3, 19);
INSERT INTO `t_sys_rolemenu` VALUES (3, 20);
INSERT INTO `t_sys_rolemenu` VALUES (3, 21);
INSERT INTO `t_sys_rolemenu` VALUES (3, 22);
INSERT INTO `t_sys_rolemenu` VALUES (3, 23);
INSERT INTO `t_sys_rolemenu` VALUES (3, 24);
INSERT INTO `t_sys_rolemenu` VALUES (3, 25);
INSERT INTO `t_sys_rolemenu` VALUES (3, 26);
INSERT INTO `t_sys_rolemenu` VALUES (3, 27);

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user`  (
  `USERID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `NICKNAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '网络名',
  `PASSWORD` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `USER_TYPE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  `STATE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户状态',
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '国家',
  `province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省',
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '市',
  `openid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'openid',
  `unionid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'unionid',
  `TEL_NO` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系号码',
  `EMAIL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `CREATE_TIME` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `headimgurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `BIRTHDAY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生日',
  `SEX` int(1) NULL DEFAULT NULL COMMENT '性别 1:男 2:女 0:未知',
  `MYINFO` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人信息',
  `ROLE_ID` int(10) NULL DEFAULT NULL COMMENT '角色',
  `ROLE_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `ADDRESS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `type1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `string1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `string2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `string3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `string4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `string5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`USERID`) USING BTREE,
  INDEX `openid_pk`(`openid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES (1, 'admin', 'admin', 'admin', NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_sys_user` VALUES (2, '1601137617858', '夜宇.', '123456', '2', '2', '中国', '湖南', '长沙', 'od3bW6ZvCvVIVMI8tvtI5ebQF0Rk', NULL, NULL, NULL, '2020-09-27 00:26:57', 'http://thirdwx.qlogo.cn/mmopen/ecKqUn5dAI9eHfU21FRkwd4jJvBLLe6d4E4iaC73WPibCLpOycyr5EvDGLNrzlXgib3TlEDAmpZWcWz8oghSp5Rz9S1k0tk4OsW/132', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_sys_user` VALUES (5, 'test', '测试用户', '123456', '1', '1', NULL, NULL, NULL, NULL, NULL, '12312312312', '12312@qq.com', '2020-11-13 16:22:31', NULL, NULL, 1, NULL, 3, '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_sys_userrole
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_userrole`;
CREATE TABLE `t_sys_userrole`  (
  `id` int(11) NOT NULL COMMENT '关联id',
  `userid` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `roleid` int(11) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_sys_userrole
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
