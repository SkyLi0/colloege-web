package com.college.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Integer messageId;//文章ID
    private String messageTitle;//文章标题
    private String messageType;//文章类型
    private String messageContent;//文章内容
    private Date createDate;//创建时间
    private String status;//审核状态
}
