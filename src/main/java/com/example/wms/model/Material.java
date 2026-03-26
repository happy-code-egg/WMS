package com.example.wms.model;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Erupt(name = "物料管理")
@Table(name = "wms_material")
@Entity
public class Material extends BaseModel {

    @EruptField(
            views = @View(title = "物料编码"),
            edit = @Edit(title = "物料编码", notNull = true)
    )
    private String code;

    @EruptField(
            views = @View(title = "物料名称"),
            edit = @Edit(title = "物料名称", notNull = true)
    )
    private String name;

    @EruptField(
            views = @View(title = "规格型号"),
            edit = @Edit(title = "规格型号")
    )
    private String specification;

    @EruptField(
            views = @View(title = "单位"),
            edit = @Edit(title = "单位")
    )
    private String unit;

    @EruptField(
            views = @View(title = "当前库存"),
            edit = @Edit(title = "当前库存", type = EditType.NUMBER, readonly = @xyz.erupt.annotation.sub_field.Readonly)
    )
    private Integer stock = 0;

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }
}