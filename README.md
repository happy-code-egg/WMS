# Erupt 仓库管理系统 (WMS) Demo

这是一个基于 [Erupt](https://www.erupt.xyz) 低代码框架实现的简单仓库管理系统 Demo。实现了基本的物料管理、入库管理、出库管理，并且在出入库时会自动更新物料的库存。

## 环境要求
- Java 8+
- Maven 3.6+

## 功能特性
1. **物料管理**：录入和管理仓库物料信息（物料编码、名称、规格型号、单位、库存等）。
2. **入库管理**：记录入库流水，录入后自动增加对应物料的库存。
3. **出库管理**：记录出库流水，录入后自动扣减对应物料的库存（库存不足时拦截并提示）。

## 运行方式
在当前目录 (`d:\桌面\WMS\Warehouse Management System`) 下执行以下命令：

```bash
mvn spring-boot:run
```

或者打包后运行：
```bash
mvn clean package -DskipTests
java -jar target/wms-demo-0.0.1-SNAPSHOT.jar
```

## 访问系统
- **地址**: `http://localhost:8080`
- **默认账号**: `erupt`
- **默认密码**: `erupt`

> 首次启动时，Erupt 会自动创建所需的数据库表结构并初始化管理员账号。数据保存在本地的 `./data/wms.mv.db` 文件中。
