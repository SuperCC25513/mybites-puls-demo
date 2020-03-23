package com.supercc.gernater.controller;

import com.supercc.gernater.model.entity.User;
import com.supercc.gernater.service.UserService;
import com.supercc.gernater.utils.Msg;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author wcc
 */
@Api(tags = {"系统用户表"}, produces = "系统用户表相关接口")
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperationSupport(params = @DynamicParameters(name = "objmap", properties = {
            @DynamicParameter(name = "page", value = "页码", example = "1", required = true, dataTypeClass = Integer.class),
            @DynamicParameter(name = "limit", value = "每页条数", example = "10", required = true, dataTypeClass = Integer.class),
            @DynamicParameter(name = "field", value = "排序的字段名", example = "create_Time", dataTypeClass = String.class),
            @DynamicParameter(name = "order", value = "asc or desc", example = "desc", dataTypeClass = String.class),
            @DynamicParameter(name = "entityList", value = "实体类名", example = "['admin','user']", dataTypeClass = List.class),
            @DynamicParameter(name = "searchRelation", value = "搜索多个条件", example = "['or','eq']", dataTypeClass = List.class),
            @DynamicParameter(name = "searchname", value = "实体类名成+字段名称：字段值", example = "{'admin_id':1,'admin_name':'张三'}", dataTypeClass = String.class),
            @DynamicParameter(name = "Type", value = "筛选类型 +字段名称：字段值", example = "{'admin_state':1}", dataTypeClass = String.class)
    }))
    @ApiOperation(value = "查询分页数据", httpMethod = "POST",
            notes = "searchRelation 与 searchname 一一对应 , 否则不生效\n" +
                    "字段名如下\n" +
                    "       uid   \n" + "       nickname  用户名 \n" + "       email  邮箱 \n" + "       phone  手机 \n" + "       status  状态 0：禁用 1：正常 \n" + "       createUid  创建者ID \n" + "       createTime  创建时间 \n" + "       updateTime  修改时间 \n" + "       loginName  登陆名 \n" + "       password  密码 \n" + "       ip  IP地址 \n")

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Msg findListByPage(@RequestBody Map<String, Object> objmap) {
        return userService.findListByPage((int) objmap.get("page"), (int) objmap.get("limit"), (String) objmap.get("field"), (String) objmap.get("order"), (List<String>) objmap.get("searchRelation"), (Map<String, Object>) objmap.get("searchname"), (Map<String, Object>) objmap.get("Type"));
    }

    /**
     * 根据id查询
     */
    @ApiOperation(value = "根据id查询数据")
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Msg getById(@RequestParam("pkid") String pkid) {
        return userService.getById(pkid);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Msg add(@RequestBody User user) {
        return userService.add(user);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public Msg delete(@RequestParam("ids") List<String> ids) {
        return userService.delete(ids);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "更新数据")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Msg update(@RequestBody User user) {
        return userService.update(user);
    }


}
