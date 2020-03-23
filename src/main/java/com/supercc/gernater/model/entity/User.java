package com.supercc.gernater.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author wcc
 * @since 2020-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value = "User对象", description = "系统用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @TableField("nickname")
    private String nickname;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @TableField("email")
        private String email;

    /**
     * 手机
     */
    @ApiModelProperty(value = "手机")
    @TableField("phone")
        private String phone;

    /**
     * 状态 0：禁用 1：正常
     */
    @ApiModelProperty(value = "状态 0：禁用 1：正常")
    @TableField("status")
        private Integer status;

    /**
     * 创建者ID
     */
    @ApiModelProperty(value = "创建者ID")
    @TableField("create_uid")
    private Integer createUid;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 登陆名
     */
    @ApiModelProperty(value = "登陆名")
    @TableField("login_name")
    private String loginName;

        /**
         * 密码
         */
        @ApiModelProperty(value = "密码")
        @TableField("password")
        private String password;

    /**
     * IP地址
     */
    @ApiModelProperty(value = "IP地址")
    @TableField("ip")
    private String ip;

    public List<String> getuserlist() {
        List<String> list = new ArrayList<String>();
        list.add(ip);
        return list;
    }

}
