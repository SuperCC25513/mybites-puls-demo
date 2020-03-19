package com.supercc.gernater.config;/**
 * @author wangcc
 * @create
 */

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName MyMetaObjectHandler
 * 用于自动填充字段
 * @Author wangcc
 * @Date 13:16 2020/3/19
 **/
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("modifyTime", new Date(), metaObject);
        this.setFieldValByName("create_Time", new Date(), metaObject);
        this.setFieldValByName("update_Time", new Date(), metaObject);
        this.setFieldValByName("modify_Time", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("modifyTime", new Date(), metaObject);
        this.setFieldValByName("create_Time", new Date(), metaObject);
        this.setFieldValByName("update_Time", new Date(), metaObject);
        this.setFieldValByName("modify_Time", new Date(), metaObject);
    }
}