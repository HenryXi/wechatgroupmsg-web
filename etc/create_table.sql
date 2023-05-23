CREATE TABLE `rcontact` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `nickname` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nameIdx` (`username`,`nickname`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin

create TABLE `chatroom` (
`id` int unsigned NOT NULL AUTO_INCREMENT,
`chatroomname` varchar(128) COLLATE utf8mb4_bin NOT NULL,
`memberlist` text COLLATE utf8mb4_bin,
`roomowner` varchar(128) COLLATE utf8mb4_bin,
`update_time` bigint NOT NULL,
PRIMARY KEY (`id`),
 UNIQUE KEY `chatroomnameIdx` (`chatroomname`) USING BTREE,
 INDEX `roomownerIdx` (`roomowner`) USING BTREE)
 ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin

create TABLE `message` (
`id` int unsigned NOT NULL AUTO_INCREMENT,
`msg_svr_id` varchar(128) COLLATE utf8mb4_bin NOT NULL,
`talker` varchar(128) COLLATE utf8mb4_bin,
`content` text COLLATE utf8mb4_bin,
`create_time` bigint NOT NULL,
PRIMARY KEY (`id`),
 UNIQUE KEY `msg_svr_idIdx` (`msg_svr_id`) USING BTREE,
  INDEX `talkerIdx` (`talker`) USING BTREE,
  INDEX `create_timeIdx` (`create_time`) USING BTREE)
 ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin