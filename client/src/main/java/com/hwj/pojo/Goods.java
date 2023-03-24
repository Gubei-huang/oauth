package com.hwj.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Huang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("goods")
public class Goods {
    @TableId
    private long id;

    @ApiModelProperty("物品名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("规格")
    private String specification;

    @ApiModelProperty("类别")
    private String category;

    @ApiModelProperty("描述")
    private String description;

}
