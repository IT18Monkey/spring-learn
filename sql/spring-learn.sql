DROP TABLE IF EXISTS user;
create TABLE  user(
  user_id BIGINT NOT NULL COMMENT '用户id',
  name VARCHAR(500) COMMENT '姓名',
  age INT COMMENT '年龄',
  PRIMARY KEY (user_id)
) COMMENT '用户表';