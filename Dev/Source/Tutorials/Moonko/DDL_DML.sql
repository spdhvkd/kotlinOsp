-- board 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `board` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `board`;

-- 테이블 board.board 구조 내보내기
CREATE TABLE IF NOT EXISTS `board` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `contents` varchar(100) NOT NULL,
  `writer` varchar(20) NOT NULL,
  `write_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='코틀린 게시판 테스트용';

INSERT INTO `board` (`seq`, `title`, `contents`, `writer`, `write_date`) VALUES (1, '안녕하세요', '좋은 날씨 입니다. 저는 키보드를 좋아합니다.', 'moonko', '2017-10-26 11:12:55');
INSERT INTO `board` (`seq`, `title`, `contents`, `writer`, `write_date`) VALUES (2, '당신은 키보드를 사랑합니까?', '진정 사랑하는 키보드를 위해 무엇이든 할 수 있겠습니까?', 'moonko', '2017-10-26 11:13:49');
