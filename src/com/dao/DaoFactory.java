package com.dao;

import java.util.ResourceBundle;

public class DaoFactory {

    private DaoFactory() {

    }

    private static DaoFactory instance = null;

    public static DaoFactory getInstance() {
        if (instance == null) {
            synchronized (DaoFactory.class) {
                if (instance == null) {
                    instance = new DaoFactory();
                }
            }
        }
        return instance;
    }

    /**
     * 根据配置文件实例化dao
     * @param clazz dao 的接口类
     * @param <T> 接口类的类型
     * @return 配置的 dao
     */
    public <T> T getDaoByConfig(Class<T> clazz) {
        //clazz dao接口类 ==> 读取配置文件（dao.properties）==> 创建 dao 实现类

        //1. 获取 dao 接口类名
        String IDaoName = clazz.getSimpleName();

        //2. 读取配置文件中，simpleName 对应的实现类
        String daoImpl = ResourceBundle.getBundle("dao").getString(IDaoName);

        //3. 创建配置 dao 的实例对象
        try {
            return (T) Class.forName(daoImpl).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
