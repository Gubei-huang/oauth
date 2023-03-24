package com.hwj.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @ApiModelProperty("物品编号")
    private long goodsId;
    @ApiModelProperty("仓库编号")
    private long warehouseId;
    @ApiModelProperty("库存数")
    private int quantity;

    private Goods goods;
    private Warehouse warehouse;
}
