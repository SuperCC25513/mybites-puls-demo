package com.supercc.gernater.utils;/**
 * @author wangcc
 * @create
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName Msg
 * @Description 返回Msg
 * @Author wangcc
 * @Date 12:01 2019/11/11
 **/
@Data
@ApiModel(value = "通用返回信息", description = "通用数据返回信息")
public class Msg<T> {

    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码")
    private String code;
    /**
     * 提示信息
     */
    @ApiModelProperty(value = "提示信息")
    private String msg;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private Long count;
    /**
     * 访问路径
     **/
    @ApiModelProperty(value = "访问路径")
    private String url;
    /**
     * 返回数据对象
     */
    @ApiModelProperty(value = "常用返回数据对象")
    private T data;
    @ApiModelProperty(value = "返回数据对象")
    private Object object;

    public Msg(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Msg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Msg() {
    }

    /**
     * 查询成功
     */
    public void SelectOk() {
        this.setMsg(Code.sucessMsgOk);
        this.setCode(Code.sucess);
    }

    /**
     * 查询成功Layui
     */
    public void SelectOkLayui() {
        this.setMsg(Code.sucessMsgOk);
        this.setCode(Code.layuisucess);
    }

    /**
     * 查询失败
     */
    public void SelectErr() {
        this.setMsg(Code.sucessMsgOk4);
        this.setCode(Code.sucess);
    }

    /**
     * 查询失败Layui
     */
    public void SelectErrLayui() {
        this.setMsg(Code.sucessMsgOk4);
        this.setCode(Code.layuisucess);
    }

    /**
     * 修改成功
     */
    public void UpdateOk() {
        this.setMsg(Code.sucessMsgOk3);
        this.setCode(Code.sucess);
    }

    /**
     * 修改失败
     */
    public void UpdateErr() {
        this.setMsg(Code.errorMsg1);
        this.setCode(Code.error);
    }

    /**
     * 参数错误
     */
    public void Paramerror() {
        this.setMsg(Code.ParamerrorMsg);
        this.setCode(Code.Paramerror);
    }

    /**
     * 添加成功
     */
    public void insertOk() {
        this.setMsg(Code.sucessMsgOk1);
        this.setCode(Code.sucess);
    }

    /**
     * 添加失败
     */
    public void insertErr() {
        this.setMsg(Code.errorMsg1);
        this.setCode(Code.error);
    }

    /**
     * 删除成功
     */
    public void DelOk() {
        this.setMsg("删除成功");
        this.setCode(Code.sucess);
    }

    /**
     * 删除失败
     */
    public void DelErr() {
        this.setMsg(Code.errorMsg1);
        this.setCode(Code.error);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":\"")
                .append(code).append('\"');
        sb.append(",\"msg\":\"")
                .append(msg).append('\"');
        sb.append(",\"count\":")
                .append(count);
        sb.append(",\"url\":\"")
                .append(url).append('\"');
        sb.append(",\"data\":")
                .append(data);
        sb.append(",\"object\":")
                .append(object);
        sb.append('}');
        return sb.toString();
    }
}
