package com.example.wms.model;

import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.core.util.EruptSpringUtil;

import javax.persistence.EntityManager;

public class InboundProxy implements DataProxy<InboundRecord> {
    @Override
    public void afterAdd(InboundRecord record) {
        EntityManager entityManager = EruptSpringUtil.getBean(EntityManager.class);
        Material material = entityManager.find(Material.class, record.getMaterial().getId());
        if (material != null) {
            Integer currentStock = material.getStock() == null ? 0 : material.getStock();
            material.setStock(currentStock + record.getQuantity());
            entityManager.merge(material);
        }
    }
}