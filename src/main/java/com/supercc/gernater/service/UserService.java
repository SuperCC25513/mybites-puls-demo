package com.supercc.gernater.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.supercc.gernater.model.entity.User;
import com.supercc.gernater.utils.Msg;

import java.util.List;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author wcc
 * @since 2020-03-18
 */
public interface UserService extends IService<User> {

    Msg findListByPage(Integer page, Integer limit, String field, String order, String searchname, Integer type);

    Msg getById(String pkid);

    Msg add(User user);

    Msg delete(List<String> ids);

    Msg update(User user);
}
