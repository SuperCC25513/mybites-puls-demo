package com.supercc.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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


}
