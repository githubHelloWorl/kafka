package com.cmd.kafka.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("aaa")
@Data
public class Test {
    private String id;
    private String name;

}
