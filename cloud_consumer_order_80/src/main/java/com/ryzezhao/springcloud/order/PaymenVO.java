package com.ryzezhao.springcloud.order;


import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymenVO implements Serializable {
    private String serial;
    private String id;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}
