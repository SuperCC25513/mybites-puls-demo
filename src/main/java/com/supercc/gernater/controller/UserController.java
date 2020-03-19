package com.supercc.gernater.controller;

import com.supercc.gernater.model.entity.User;
import com.supercc.gernater.service.UserService;
import com.supercc.gernater.utils.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    @ApiOperation(value = "查询分页数据")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Msg findListByPage(@RequestParam(name = "page", defaultValue = "1") Integer page,
                              @RequestParam(name = "limit", defaultValue = "10") Integer limit,
                              @RequestParam(name = "field", required = false) String field,
                              @RequestParam(name = "order", required = false) String order,
                              @RequestParam(name = "searchname", required = false) String searchname,
                              @RequestParam(name = "Type", required = false) Integer Type) {
        return userService.findListByPage(page, limit, field, order, searchname, Type);
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
