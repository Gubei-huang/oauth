package com.hwj.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * @author Huang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private long id;

    @ApiModelProperty("供应商编号")
    private long supplierId;

    @ApiModelProperty("仓库编号")
    private long warehouseId;

    @ApiModelProperty("物品编号")
    private long goodsId;

    @ApiModelProperty("入库物品数量")
    private int quantity;

    @ApiModelProperty("入库时间")
    private Date time;

    private Supplier supplier;
    private Warehouse warehouse;
    private Goods goods;
}
