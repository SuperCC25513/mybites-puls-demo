package com.supercc.gernater.controller;

import com.supercc.gernater.model.entity.User;
import com.supercc.gernater.service.UserService;
import com.supercc.gernater.utils.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    /**
     * 查询分页数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "limit", value = "每页条数"),
            @ApiImplicitParam(name = "field", value = "排序的字段名"),
            @ApiImplicitParam(name = "order", value = "asc or desc"),
            @ApiImplicitParam(name = "searchRelation", value = "模糊搜索的关系,or or eq ,与searchname一一对应"),
            @ApiImplicitParam(name = "searchname", value = "模糊搜索,k,v 的形式k为字段名，v为模糊搜索"),
            @ApiImplicitParam(name = "Type", value = "筛选类型，k,v 的形式k为字段名，v为筛选的值"),
            @ApiImplicitParam(name = "entityList", value = "传递entity的名字，校验传递的参数名，防止sql注入"),
    })
    @ApiOperation(value = "查询分页数据", httpMethod = "GET",
            notes = "searchRelation 与 searchname 一一对应 , 否则不生效\n" +
                    "字段名如下\n" +
                    "       uid   \n" + "       nickname  用户名 \n" + "       email  邮箱 \n" + "       phone  手机 \n" + "       status  状态 0：禁用 1：正常 \n" + "       createUid  创建者ID \n" + "       createTime  创建时间 \n" + "       updateTime  修改时间 \n" + "       loginName  登陆名 \n" + "       password  密码 \n" + "       ip  IP地址 \n")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Msg findListByPage(@RequestParam(name = "page", defaultValue = "1") Integer page,
                              @RequestParam(name = "limit", defaultValue = "10") Integer limit,
                              @RequestParam(name = "field", required = false) String field,
                              @RequestParam(name = "order", required = false) String order,
                              @RequestParam(name = "searchRelation", required = false) List<String> searchRelation,
                              @RequestParam(name = "searchname", required = false) Map<String, Object> searchname,
                              @RequestParam(name = "Type", required = false) Map<String, Object> Type,
                              @RequestParam(name = "entityList", required = false) List<String> entityList) {
        return userService.findListByPage(page, limit, field, order, searchRelation, searchname, Type);
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
