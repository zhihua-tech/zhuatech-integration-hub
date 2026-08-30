# ZhuaTech INTHUB｜企业集成平台

> 用受治理的连接器、映射和运行编排打通企业应用与数据流

ZhuaTech INTHUB 是知华科技（上海如静知华信息科技有限公司）发布的企业级源码项目，面向“连接器、接口契约、数据映射、集成流程、调度、重试、死信、可观测性与审计”提供管理端与响应式业务端。工程采用前后端分离架构，所有示例数据均为虚构数据。

[知华科技官网](https://www.zhuatech.cn/) · [架构说明](docs/ARCHITECTURE.md) · [API 文档](docs/API.md) · [企业能力](docs/ENTERPRISE.md) · [测试说明](docs/TESTING.md)

![企业集成平台产品界面示意](docs/images/product-overview.svg)

## 业务模块

| 模块 | 核心能力 |
| --- | --- |
| 连接器管理 | 配置数据库、API、消息、文件和SaaS连接器及凭据引用 |
| 接口契约 | 维护协议、Schema、版本、负责人和兼容性策略 |
| 数据映射 | 设计字段转换、代码映射、脱敏、校验和默认值 |
| 集成流程 | 编排来源、转换、路由、聚合、分支和目标节点 |
| 调度与触发 | 支持定时、事件、Webhook和人工补数触发 |
| 可靠性控制 | 提供幂等、重试、超时、熔断和流量保护 |
| 死信处理 | 归集失败消息、分派原因、修复并安全重放 |
| 运行可观测 | 跟踪吞吐、成功率、延迟、积压、链路和告警 |
| 发布与审计 | 执行环境推广、变更审批、回滚和操作审计 |

![企业集成平台业务闭环](docs/images/workflow.svg)

## 企业级控制

- ADMIN / OPERATOR 角色边界和管理员接口隔离；
- 服务端字段、模块、唯一编号和状态迁移校验；
- 组织、期间、责任人、风险等级、到期日和 SLA 统计；
- 幂等创建、JPA 乐观锁、重复提交保护和职责分离；
- 附件 SHA-256 元数据、业务凭证完整性与全流程审计；
- 组合检索、分页、逾期筛选、UTF-8 CSV 导出和协作时间线；
- 外部系统仅预留适配器，使用方自行配置地址与凭据；
- prod profile 拒绝默认密码、弱数据库口令和本地跨域来源。

## 技术架构

- 后端：Java 21、Spring Boot、Spring Security、JPA、Bean Validation、Actuator
- 前端：Vue 3、Vite、Axios，支持桌面端与移动端响应式布局
- 数据库：MySQL 8；自动化测试使用 H2
- 交付：Docker Compose、Nginx、环境变量、GitHub Actions
- Java 包名：`cn.zhuatech.integrationhub`

## 启动与测试

```bash
cd backend && mvn test
cd ../frontend && npm install && npm run build
cd .. && cp .env.example .env && docker compose up --build
```

开发演示账号：`admin / admin123`、`operator / operator123`。生产环境必须通过环境变量替换全部默认凭据。

## 许可与商业授权

Copyright © 2026 上海如静知华信息科技有限公司。

本工程仅允许个人学习、研究和非商业技术交流，**不得用于商业用途**。企业内部使用、生产部署、SaaS运营、项目交付、品牌替换、收费培训、咨询实施或再分发，均须事先获得上海如静知华信息科技有限公司书面授权，详见 [LICENSE](LICENSE)。

深度开发、私有化部署、系统集成与企业数字化咨询，请访问[知华科技官网](https://www.zhuatech.cn/)或扫码联系：

| 微信咨询一 | 微信咨询二 |
| --- | --- |
| ![微信咨询二维码一](docs/images/zhuatech-wechat-consulting.png) | ![微信咨询二维码二](docs/images/zhuatech-wechat-consulting-2.png) |

SEO：企业集成平台、INTHUB系统源码、企业数字化、Java企业系统、Vue管理系统、知华科技、上海如静知华信息科技有限公司。
