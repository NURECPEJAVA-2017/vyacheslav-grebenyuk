package com.nixsolutions.usermanagement.web;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;

import com.mockobjects.dynamic.Mock;
import com.mockrunner.servlet.BasicServletTestCaseAdapter;
import com.nixsolutions.usermanagement.db.DaoFactory;
import com.nixsolutions.usermanagement.db.MockDaoFactory;

/**
 * @author mak
 */
public abstract class MockServletTestCase extends BasicServletTestCaseAdapter {

    private Mock mockUserDao;
    
    /*
     * @see BasicServletTestCaseAdapter#setUp()
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        Properties properties = new Properties();
        properties.setProperty("dao.Factory", MockDaoFactory.class.getName());
        DaoFactory.init(properties);
        setMockUserDao(((MockDaoFactory) DaoFactory.getInstance()).getMockUserDao());
    }

    /*
     * @see BasicServletTestCaseAdapter#tearDown()
     */
    @After
    public void tearDown() throws Exception {
        getMockUserDao().verify();
        super.tearDown();
    }
    
    

    /**
     * @return Returns the mockUserDao.
     */
    public Mock getMockUserDao() {
        return mockUserDao;
    }
    /**
     * @param mockUserDao The mockUserDao to set.
     */
    public void setMockUserDao(Mock mockUserDao) {
        this.mockUserDao = mockUserDao;
    }
}
