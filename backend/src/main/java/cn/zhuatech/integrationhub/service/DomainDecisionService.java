/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.integrationhub.service;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Service;
import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service public class DomainDecisionService {
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public DecisionResult assess(DecisionRequest request) { if(request.deliveredRecords()>request.sourceRecords()||request.deliveredRecords()+request.failedRecords()>request.sourceRecords())throw new IllegalArgumentException("投递与失败记录不能超过源记录数");double success=request.sourceRecords()==0?100:request.deliveredRecords()*100d/request.sourceRecords();int score=(int)Math.round(success);List<String> actions=new ArrayList<>();if(!request.authConfigured()){score-=60;actions.add("配置安全连接认证后再发布");}if(!request.mappingValidated()){score-=45;actions.add("完成字段映射与样本校验");}if(request.failedRecords()>0){score-=Math.min(30,request.failedRecords());actions.add("处理失败消息并安全重放");}if(request.duplicateEvents()>0){score-=30;actions.add("修复幂等键和重复投递");}if(!request.deadLetterCleared()){score-=25;actions.add("关闭死信队列未决事项");}if(request.p95LatencyMs()>2000){score-=15;actions.add("优化集成链路延迟");}return result(score,actions,"READY_TO_PUBLISH","REMEDIATE","BLOCKED",Map.of("successRate",Math.round(success*10)/10d,"failedRecords",request.failedRecords(),"duplicateEvents",request.duplicateEvents(),"p95LatencyMs",request.p95LatencyMs())); }
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 private DecisionResult result(int raw,List<String> actions,String good,String warn,String bad,Map<String,Object> metrics) { int score=Math.max(0,Math.min(100,raw));String decision=score>=80?good:score>=50?warn:bad;return new DecisionResult(decision,score,metrics,List.copyOf(actions)); }
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 private DecisionResult riskResult(int raw,List<String> actions,String good,String warn,String bad,Map<String,Object> metrics) { int score=Math.max(0,Math.min(100,raw));String decision=score>=70?bad:score>=40?warn:good;return new DecisionResult(decision,score,metrics,List.copyOf(actions)); }
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record DecisionRequest(
        @NotBlank String flowCode,
        @PositiveOrZero int sourceRecords,
        @PositiveOrZero int deliveredRecords,
        @PositiveOrZero int failedRecords,
        @PositiveOrZero int p95LatencyMs,
        @PositiveOrZero int duplicateEvents,
        boolean mappingValidated,
        boolean authConfigured,
        boolean deadLetterCleared) {}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record DecisionResult(String decision,int score,Map<String,Object> metrics,List<String> actions) {}
}
