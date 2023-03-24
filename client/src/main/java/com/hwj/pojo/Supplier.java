package com.hwj.pojo;

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
public class Supplier {
    private long id;

    @ApiModelProperty("供应商名称")
    private String name;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("联系方式")
    private String phone;
}
