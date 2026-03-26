package com.example.wms.model;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTableType;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Erupt(name = "入库记录", dataProxy = InboundProxy.class)
@Table(name = "wms_inbound")
@Entity
public class InboundRecord extends BaseModel {

    @ManyToOne
    @EruptField(
            views = @View(title = "物料", column = "name"),
            edit = @Edit(
                    title = "物料",
                    type = EditType.REFERENCE_TABLE,
                    referenceTableType = @ReferenceTableType(id = "id", label = "name"),
                    notNull = true
            )
    )
    private Material material;

    @EruptField(
            views = @View(title = "入库数量"),
            edit = @Edit(title = "入库数量", type = EditType.NUMBER, notNull = true)
    )
    private Integer quantity;

    @EruptField(
            views = @View(title = "入库时间"),
            edit = @Edit(title = "入库时间", type = EditType.DATE, notNull = true)
    )
    private Date inboundDate;

    @EruptField(
            views = @View(title = "操作人"),
            edit = @Edit(title = "操作人")
    )
    private String operator;

    @EruptField(
            views = @View(title = "备注"),
            edit = @Edit(title = "备注")
    )
    private String remark;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}