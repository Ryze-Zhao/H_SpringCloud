package com.ryzezhao.springcloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ryzezhao.springcloud.common.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@TableName(value = "seata_storage.t_storage")
public class TStorage extends BaseEntity implements Serializable {
    /**
     * 总库存
     */
    @TableField(value = "total")
    private Integer total;

    /**
     * 使用库存
     */
    @TableField(value = "used")
    private Integer used;

    /**
     * 剩余库存
     */
    @TableField(value = "residue")
    private Integer residue;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_TOTAL = "total";

    public static final String COL_USED = "used";

    public static final String COL_RESIDUE = "residue";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";
}