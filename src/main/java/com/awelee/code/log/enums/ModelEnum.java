package com.awelee.code.log.enums;

/***
 *
 * @描述: 模块枚举.
 * @作者: Awelee.
 * @创建时间: 2018/4/18, 15:31 .
 * @版本: V1.0.
 *
 */
public enum ModelEnum {
    MODEL_A("用户管理","A"),
    MODEL_B("角色管理","B"),
    MODEL_C("部门管理","C"),
    MODEL_D("公司管理","D"),
    MODEL_E("菜单管理","E"),
    MODEL_F("系统管理","F"),
    MODEL_G("日志管理","G"),
    DEFAULT("未知模块","DEFAULT");

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    ModelEnum(String name,String code){
        this.name = name;
        this.code = code;
    }

    public static String getName(String code) {
        for (ModelEnum c : ModelEnum.values()) {
            if (c.getCode().equals(code)) {
                return c.name;
            }
        }
        return "未知模块";
    }

    public static String getCode(String name) {
        for (ModelEnum c : ModelEnum.values()) {
            if (c.getName().equals(name)) {
                return c.code;
            }
        }
        return "DEFAULT";
    }
}
