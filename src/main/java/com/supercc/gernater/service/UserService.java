package com.supercc.gernater.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.supercc.gernater.model.entity.User;
import com.supercc.gernater.utils.Msg;

import java.util.List;
import java.util.Map;
/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author wcc
 * @since 2020-03-23
 */
public interface UserService extends IService<User> {

        Msg findListByPage(Integer page, Integer limit, String field, String order, List<String> searchRelation, Map<String, Object> searchname, Map<String, Object> type);

        Msg getById(String pkid);

        Msg add(User user);

        Msg delete(List<String> ids);

        Msg update(User user);
}
