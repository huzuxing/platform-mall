package com.cyc.platform.common.common;

/**
 * Created by huzuxing on 2017/9/18.
 */
public enum Tips {
    ERROR100(-100, "系统错误"),
    ERROR101(-101, "保存失败"),
    ERROR102(-102, "修改失败"),
    ERROR103(-103, "查询失败"),
    ERROR104(-104, "删除失败"),
    ERROR105(-105, "{param}已存在"),
    ERROR106(-106, "{param}不存在"),
    ERROR107(-107, "{param}被封禁"),
    ERROR108(-108, "登录失败"),
    ERROR109(-109, "用户名错误"),
    ERROR110(-110, "密码错误"),
    ERROR111(-111, "未登录"),
    ERROR112(-112, "文件上传失败"),
    ERROR113(-113, "{param}生成失败"),
    ERROR200(-200, "{param}无效/不合法"),
    ERROR201(-201, "没有权限"),
    ERROR202(-202, "{param}参数错误"),
    ERROR203(-203, "{param}校验失败"),
    ERROR204(-204, "图形验证码不正确"),
    ERROR205(-205, "短信验证码不正确"),
    ERROR206(-206, "参数{param}不能为空 "),
    ERROR207(-207, "图形验证码已过期"),
    ERROR208(-208, "短信验证码已过期"),
    ERROR209(-209, "超时"),
    ERROR210(-210, "{param}超过限制"),
    ERROR211(-211, "{param}不能为空"),
    ERROR212(-212, "不支持该格式"),
    ERROR1000(1, "没有更多数据"),
    ERROR0(0, "失败"),
    ERROR1(0, "失败！ {param}"),
    SUCCESS1(1, "成功"),
    SUCCESS2(1, "成功更新{param}条数据 "),
    SUCCESS3(1, "成功删除{param}条数据 "),
    ERROR300(-300, "不在活动时间段"),
    ERROR301(-301, "活动未开始"),
    ERROR302(-302, "活动已结束"),
    ERROR303(-303, "已参加过该活动"),
    ERROR304(-304, "活动次数已用完"),
    ERROR305(-305, "解析JSON/XML内容错误"),
    ERROR306(-306, "解析错误"),
    ERROR307(-307, "需提供图形验证码"),
    ERROR308(-308, "已发送，稍后再试"),
    ERROR309(-309, "礼包码已用完"),
    ERROR310(-310, "没有配置邮件"),
    ERROR311(-311, "邮件内容没有配置,或没启用"),
    ERROR312(-312, "没有配置短信"),
    ERROR313(-313, "短信内容没有配置,或没启用"),
    ERROR314(-314, "短信验证码没有配置,或没启用"),
    ERROR500(-500, "{param}字数过多"),
    ERROR501(-501, "参数过长"),
    ERROR700(-700, "conditions中缺少{param}参数 "),
    ERROR701(-701, "参数{param}不能同时为空 "),
    ERROR702(-702, "以'{param}'为参数的对象已经存在，请保证该参数在系统中唯一 "),
    ERROR703(-703, "参数{param}只能要么同时为空，要么同时不为空 "),
    ERROR704(-704, "存在{param}参数为空，或者格式错误的情况 "),
    ERROR801(-801, "确少更新的参数字段"),
    ERROR802(-802, "参数{param}的值相同"),
    ERROR803(-803, "没有系统操作权限"),
    ERROR804(-804, "上传文件大小超限");

    private int code;
    private String desc;

    private Tips(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return this.desc.replace("{param}", "");
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc(String param) {
        return this.desc.replace("{param}", param);
    }
}