package com.youngch.pat.common.base.utils.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Quote from "http://www.cnblogs.com/draem0507/p/4110987.html"
 */
public class EnumConstant {

    /**
     * 枚举接口类全路径
     */
    public final static String ENUMNAME_CLASS = "com.youngch.pat.base.utils.enums.EnumName";

    /**
     * 所有枚举对象的 map
     */
    public static final Map<Class, Map<Integer, EnumName>> ENUM_MAP = new HashMap<>();

    /**静态初始化块*/
    static {
    }
}