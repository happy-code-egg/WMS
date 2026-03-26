package com.example.wms.model;

import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.core.util.EruptSpringUtil;

import javax.persistence.EntityManager;

public class OutboundProxy implements DataProxy<OutboundRecord> {
    
    @Override
    public void beforeAdd(OutboundRecord record) {
        EntityManager entityManager = EruptSpringUtil.getBean(EntityManager.class);
        Material material = entityManager.find(Material.class, record.getMaterial().getId());
        if (material != null) {
            Integer currentStock = material.getStock() == null ? 0 : material.getStock();
            if (currentStock < record.getQuantity()) {
                throw new RuntimeException("库存不足！当前库存：" + currentStock);
            }
        }
    }

    @Override
    public void afterAdd(OutboundRecord record) {
        EntityManager entityManager = EruptSpringUtil.getBean(EntityManager.class);
        Material material = entityManager.find(Material.class, record.getMaterial().getId());
        if (material != null) {
            Integer currentStock = material.getStock() == null ? 0 : material.getStock();
            material.setStock(currentStock - record.getQuantity());
            entityManager.merge(material);
        }
    }
}