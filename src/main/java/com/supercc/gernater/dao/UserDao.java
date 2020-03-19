package com.supercc.gernater.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.supercc.gernater.model.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author wcc
 * @since 2020-03-18
 */
@Repository
public interface UserDao extends BaseMapper<User> {

}
