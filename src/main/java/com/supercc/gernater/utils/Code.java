package com.supercc.gernater.utils;/**
 * @author wangcc
 * @create
 */

/**
 * @ClassName Code
 * @Description Code返回码
 * @Author wangcc
 * @Date 12:03 2019/11/11
 **/
public class Code {
    public static final String TOKEN_NULL = "101";
    public static final String TOKEN_NULL_login = "102";
    public static final String TOKEN_NULL_login_ACC = "103";
    public static final String TOKEN_NULL_MSG = "该请求没有token！ 请先获取token！";

    public static String error = "500";
    public static String errorMsg = "服务异常";
    public static String errorMsg1 = "操作失败";
    public static String errorMsg2 = "查询失败";
    public static String errorMsg3 = "非法操作";
    public static String errorMsg4 = "请重新发起打款";
    public static String errorMsg5 = "网络统一超时！请重试！";
    public static String errorMsg6 = "文本出现敏感、违规字样，请重新输入";
    public static String login = "301";
    public static String loginMsg = "重新登陆";
    public static String sucess = "200";
    public static String sucessMsg = "正常";
    public static String sucessMsg1 = "处理中";
    public static String sucessMsgOk = "查询成功";
    public static String sucessMsgOk1 = "添加成功";
    public static String sucessMsgOk2 = "已删除";
    public static String sucessMsgOk3 = "修改成功";
    public static String sucessMsgOk4 = "无数据";
    public static String sucessMsgOk5 = "已更新";
    public static String sucessLogin = "登录成功";
    public static String register = "注册成功";

    public static String securityNull = "401";
    public static String securityNullMsg = "无权限";
    public static String securityNullMsguser = "您的身份不是老师";
    public static String repeat = "407";
    public static String repeatMsg = "重复";
    public static String repeatMsg1 = "名称已存在";
    public static String repeatMsg2 = "该用户名已存在";
    public static String repeatTime = "408";
    public static String Nonexistent = "404";
    public static String NonexistentMsg = "账号不存在";
    public static String NonexistentMsgNuser = "用户不存在";
    public static String NonexistentMsgMum = "暂无数据";
    public static String NonexistentMsgPageError = "分页参数需要>1";
    public static String NonexistentMsgClassMum = "班级不存在";
    public static String loginAgin = "302";
    public static String loginAginMsg = "账号密码错误";
    public static String Paramerror = "303";
    public static String ParamerrorMsg = "传递参数错误";
    public static String ParamerrorMsgWxNotGz = "该用户没有关注公众号";
    public static String ParamerrorMsgClass = "班级名称不能为空";
    public static String ParamerrorMsgClassBcz = "班级不存在";
    public static String ParamerrorMsgClassCz = "班级已存在";
    public static String ParamerrorMsgClassCzWx = "不能创建该名字班级。已无效";
    public static String Prohibit = "304";
    public static String ProhibitMsg = "账号被锁定";

    /**
     * laiyui 的正常状态码
     **/
    public static String layuisucess = "0";
    public static String layuisucessMsg = "正常";
    public static String ErrorSQ = "444";
    public static String ErrorSQMsg = "未知错误";
    public static String ErrorApi = "500";
    public static String ErrorApiMsg = "API异常";
    public static String ErrorApiMsgWx = "服务异常";
    public static String ErrorAdmin = "500";
    public static String ErrorAdminMsg = "联系管理员";
    public static String ErrorAdminRepeat = "407";
    public static String ErrorAdminRepeatMsg = "该角色已存在";
    public static String uploadCode = "400";
    public static String uploadCodeMsg = "不支持非图片上传";
    public static String uploadCodeMsgPrem = "文件类型错误";
    public static String uploadCodeMsgPremPar = "没有选择文件";
    public static String NonexistentDyMsg = "动态不存在";
    public static String ParamerrorMsgUserKeyType = "用户key用户类型为必传";
    public static String NonexistentMsguserType = "用户类型不识别";
}
