/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.integrationhub.domain;
import org.springframework.stereotype.Component;
import java.util.*;
@Component
public class DomainCatalog {
    private final Map<String, WorkflowAction> actions = new LinkedHashMap<>();
    public DomainCatalog() {
        actions.put("SUBMIT", new WorkflowAction("SUBMIT", "提交集成评审", List.of("草稿"), "待审批", "OPERATOR"));
        actions.put("APPROVE", new WorkflowAction("APPROVE", "批准集成发布", List.of("待审批"), "待发布", "ADMIN"));
        actions.put("PUBLISH", new WorkflowAction("PUBLISH", "发布集成流程", List.of("待发布"), "已发布", "ADMIN"));
    }
    public String systemName() { return "知华科技企业集成平台"; }
    public String scene() { return "连接器、接口契约、数据映射、集成流程、调度、重试、死信、可观测性与审计"; }
    public String initialStatus() { return "草稿"; }
    public String partyLabel() { return "集成流/目标系统"; }
    public String amountLabel() { return "集成价值"; }
    public String quantityLabel() { return "消息数量"; }
    public String dueLabel() { return "上线期限"; }
    public List<ModuleDefinition> modules() { return List.of(
            new ModuleDefinition("CONNECTOR", "连接器管理", "配置数据库、API、消息、文件和SaaS连接器及凭据引用"),
            new ModuleDefinition("CONTRACT", "接口契约", "维护协议、Schema、版本、负责人和兼容性策略"),
            new ModuleDefinition("MAPPING", "数据映射", "设计字段转换、代码映射、脱敏、校验和默认值"),
            new ModuleDefinition("FLOW", "集成流程", "编排来源、转换、路由、聚合、分支和目标节点"),
            new ModuleDefinition("SCHEDULE", "调度与触发", "支持定时、事件、Webhook和人工补数触发"),
            new ModuleDefinition("RELIABILITY", "可靠性控制", "提供幂等、重试、超时、熔断和流量保护"),
            new ModuleDefinition("DEAD_LETTER", "死信处理", "归集失败消息、分派原因、修复并安全重放"),
            new ModuleDefinition("OBSERVABILITY", "运行可观测", "跟踪吞吐、成功率、延迟、积压、链路和告警"),
            new ModuleDefinition("GOVERNANCE", "发布与审计", "执行环境推广、变更审批、回滚和操作审计")
        ); }
    public Map<String, WorkflowAction> actions() { return Collections.unmodifiableMap(actions); }
    public record ModuleDefinition(String code,String name,String description) {}
    public record WorkflowAction(String code,String label,List<String> from,String to,String requiredRole) {}
}
