package com.wondersgroup.core.constant;

import java.util.Map;

import com.wondersgroup.core.dao.DicDAO;

public class DicConstants {
    /** 单体实例 */
    private static DicConstants instance;

    /** 用户类型字典 */
    private Map<String, String> dicUserType;

    /** 产品字典 */
    private Map<String, String> dicProd;

    /**
     * 私有构造器
     */
    private DicConstants() {
    }

    /**
     * @return 返回 instance。
     */
    public static DicConstants getInstance() {
        if (instance == null) {
            instance = new DicConstants();
        }
        return instance;
    }

    /**
     * 初始化字典
     */
    public void init() throws Exception {
        DicDAO dicDAO = new DicDAO();

        // 用户类型字典
        this.dicUserType = dicDAO.getDicUserType();

        // 产品字典
        this.dicProd = dicDAO.getDicProd();
    }

    public Map<String, String> getDicUserType() {
        return dicUserType;
    }

    public Map<String, String> getDicProd() {
        return dicProd;
    }
}