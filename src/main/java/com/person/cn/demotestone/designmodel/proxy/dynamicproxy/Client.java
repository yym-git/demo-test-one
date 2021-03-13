package com.person.cn.demotestone.designmodel.proxy.dynamicproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.proxy.dynamicproxy
 * @updateUser
 * @date 13:42 2020/12/15
 */
public class Client {
    public static void main(String[] args) {
        AbstractUserDao userDao = new UserDao();
        InvocationHandler handler = new DaoLogInvocationHandler(userDao);
        //第一个参数：代理类的类加载器
        //第二个参数：代理类所实现的接口列表
        //第三个参数：指派的调用处理程序类
        userDao = (AbstractUserDao) Proxy.newProxyInstance(AbstractUserDao.class.getClassLoader(),
                new Class[]{AbstractUserDao.class}, handler);
        //调用代理对象的业务方法
        userDao.findUserById("yym");
        System.out.println("--------------------------------------------------");

        AbstractDocumentDao documentDao = new DocumentDao();
        handler = new DaoLogInvocationHandler(documentDao);
        documentDao = (AbstractDocumentDao)Proxy.newProxyInstance(AbstractDocumentDao.class.getClassLoader(),
                new Class[]{AbstractDocumentDao.class},handler);
        documentDao.deleteDocumentById("D001");

    }
}
