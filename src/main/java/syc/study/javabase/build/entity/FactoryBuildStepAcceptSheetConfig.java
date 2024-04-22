package syc.study.javabase.build.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 验收单配置表
 * </p>
 *
 * @author syc
 * @since 2024-04-22
 */
@Data
@TableName("t_factory_build_step_accept_sheet_config")
public class FactoryBuildStepAcceptSheetConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "f_id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分组名称
     */
    @TableField("f_group")
    private String group;

    /**
     * 内容
     */
    @TableField("f_content")
    private String content;

    /**
     * 排序字段
     */
    @TableField("f_orderBy")
    private Integer orderBy;

    /**
     * 图片配置
     */
    @TableField("f_img_config")
    private String imgConfig;

    /**
     * 示例内容
     */
    @TableField("f_demo_content")
    private String demoContent;

    /**
     * 1:删除无效  0：有效
     */
    @TableField("f_status")
    private Integer status;

    /**
     * 环节
     */
    @TableField("f_segment")
    private String segment;

    /**
     * 1:设备调试(安装验收报告),2：出厂质检,3：基建报告,4：基建验收报告,5：安装报告
     */
    @TableField("f_type")
    private Integer type;

    /**
     * 1:手动检测  2：自动检测  3:洗车检测
     */
    @TableField("f_group_type")
    private Integer groupType;

    /**
     * 题目关联ID，值为该配置表主键ID，主要是验收报告时显示对应节点报告的相同题目的答案
     */
    @TableField("f_relation_id")
    private Integer relationId;

    /**
     * plc程序版本
     */
    @TableField("f_version")
    private String version;

    /**
     * 创建时间
     */
    @TableField("f_create_time")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @TableField("f_create_id")
    private Integer createId;

    /**
     * 更新时间
     */
    @TableField("f_update_time")
    private LocalDateTime updateTime;

    /**
     * 修改人
     */
    @TableField("f_update_id")
    private Integer updateId;

    /**
     * 是否删除1是0否
     */
    @TableField("f_is_deleted")
    private Integer isDeleted;


}
