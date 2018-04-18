package com.awelee.code.log.enums;

/***
 *
 * @描述: 子模块枚举.
 * @作者: Awelee.
 * @创建时间: 2018/4/18, 15:31 .
 * @版本: V1.0.
 *
 */
public enum SubModelEnum {
    SUB_MODEL_A1("用户新增","A1"),
    SUB_MODEL_A2("用户删除","A2"),
    SUB_MODEL_A3("用户修改","A3"),
    SUB_MODEL_A4("用户查询","A4"),
    SUB_MODEL_A5("用户详情","A5"),

    SUB_MODEL_B1("角色新增","B1"),
    SUB_MODEL_B2("角色删除","B2"),
    SUB_MODEL_B3("角色修改","B3"),
    SUB_MODEL_B4("角色查询","B4"),
    SUB_MODEL_B5("角色详情","B5"),

    DEFAULT("未知子模块","DEFAULT");

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

    private SubModelEnum(String name,String code){
        this.name = name;
        this.code = code;
    }

    public static String getName(String code) {
        for (SubModelEnum c : SubModelEnum.values()) {
            if (c.getCode().equals(code)) {
                return c.name;
            }
        }
        return "未知子模块";
    }

    public static String getCode(String name) {
        for (SubModelEnum c : SubModelEnum.values()) {
            if (c.getName().equals(name)) {
                return c.code;
            }
        }
        return "DEFAULT";
    }
}
