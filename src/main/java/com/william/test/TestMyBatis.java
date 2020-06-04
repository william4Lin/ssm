package com.william.test;

import com.william.dao.AccountDao;
import com.william.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    /**
     * 测试查询
     * @throws IOException
     */
    @Test
    public void run1() throws IOException {

        //加载配置文件
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
        //创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取到代理对象
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        //查询所有数据
        List<Account> lists = mapper.findAll();

        for (Account account : lists) {
            System.out.println(account);
        }
        //关闭资源
        sqlSession.close();
        resource.close();
    }


    /**
     * 测试保存
     * @throws IOException
     */
    @Test
    public void run2() throws IOException {
        Account account = new Account();
        account.setName("测试");
        account.setMoney(400d);

        //加载配置文件
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
        //创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取到代理对象
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        //保存
        mapper.saveAccount(account);

        sqlSession.commit();
        //关闭资源
        sqlSession.close();
        resource.close();
    }
}
