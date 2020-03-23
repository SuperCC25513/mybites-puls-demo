package com.supercc.gernater.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supercc.gernater.dao.UserDao;
import com.supercc.gernater.model.entity.User;
import com.supercc.gernater.service.UserService;
import com.supercc.gernater.utils.Code;
import com.supercc.gernater.utils.Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author wcc
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Msg findListByPage(Integer page, Integer limit, String field, String order, List<String> searchRelation, Map<String, Object> searchname, Map<String, Object> type) {
        Msg msg = new Msg();
        try {
            PageHelper.startPage(page, limit);
            QueryWrapper queryWrapper = new QueryWrapper();
            if (!StringUtils.isEmpty(order) && !StringUtils.isEmpty(field)) {
                if ("desc".equals(order)) {
                    queryWrapper.orderBy(true, false, field);
                } else {
                    queryWrapper.orderBy(true, true, field);
                }
            }
            //业务需要的模糊搜索
            if (searchRelation.size() > 0 && !searchRelation.isEmpty() && !searchname.isEmpty() && searchname.size() > 0 && searchRelation.size() == searchname.size()) {
                for (int i = 0; i < searchRelation.size(); i++) {
                    if ("or".equals(searchRelation.get(i))) {
                        queryWrapper.or();
                    }
                    for (Map.Entry<String, Object> search : searchname.entrySet()) {
                        queryWrapper.like(search.getKey(), "%" + search.getValue() + "%");
                    }
                }

            }
            if (type.isEmpty() && type.size() > 0) {
                //业务需要的类型搜索
                for (Map.Entry<String, Object> TypeSearch : type.entrySet()) {
                    queryWrapper.eq(TypeSearch.getKey(), TypeSearch.getValue());
                }
            }
            //      业务代码start

            queryWrapper.eq("status", 1);

            //      业务代码end
            List<User> list = userDao.selectList(queryWrapper);
            if (list.size() > 0) {
                PageInfo<User> pageInfo = new PageInfo(list);
                msg.setCode(Code.layuisucess);
                msg.setMsg(Code.layuisucessMsg);
                msg.setCount(pageInfo.getTotal());
                msg.setData(pageInfo.getList());
            } else {
                msg.setCode(Code.layuisucess);
                msg.setMsg(Code.sucessMsgOk4);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error: {}", e);
            msg.setCode(Code.error);
            msg.setMsg(Code.errorMsg);
        }
        return msg;
    }

    @Override
    public Msg getById(String pkid) {
        Msg msg = new Msg();
        try {
            if (StringUtils.isEmpty(pkid)) {
                msg.Paramerror();
                return msg;
            }
            User user = userDao.selectById(pkid);
            msg.setData(user);
            msg.SelectOkLayui();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error: {}", e);
            msg.setCode(Code.error);
            msg.setMsg(Code.errorMsg);
        }
        return msg;
    }

    @Override
    public Msg add(User user) {
        Msg msg = new Msg();
        try {
            if (StringUtils.isEmpty(user)) {
                msg.Paramerror();
                return msg;
            }
            int insert = userDao.insert(user);
            if (insert > 0) {
                msg.insertOk();
            } else {
                msg.insertErr();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error: {}", e);
            msg.setCode(Code.error);
            msg.setMsg(Code.errorMsg);
        }
        return msg;
    }

    @Override
    public Msg delete(List<String> ids) {
        Msg msg = new Msg();
        try {
            if (ids.isEmpty()) {
                msg.Paramerror();
                return msg;
            }
            int i = userDao.deleteBatchIds(ids);
            if (i > 0) {
                msg.DelOk();
            } else {
                msg.DelErr();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error: {}", e);
            msg.setCode(Code.error);
            msg.setMsg(Code.errorMsg);
        }
        return msg;
    }

    @Override
    public Msg update(User user) {
        Msg msg = new Msg();
        try {
            if (StringUtils.isEmpty(user)) {
                msg.Paramerror();
                return msg;
            }
            int i = userDao.updateById(user);
            if (i > 0) {
                msg.UpdateOk();
            } else {
                msg.UpdateErr();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error: {}", e);
            msg.setCode(Code.error);
            msg.setMsg(Code.errorMsg);
        }
        return msg;
    }

}
