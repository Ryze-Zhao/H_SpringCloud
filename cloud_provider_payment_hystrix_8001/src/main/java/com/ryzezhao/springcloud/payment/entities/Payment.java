package com.ryzezhao.springcloud.payment.entities;


import com.ryzezhao.springcloud.payment.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends BaseEntity implements Serializable {
    private String serial;
}
