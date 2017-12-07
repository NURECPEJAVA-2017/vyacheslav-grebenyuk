package com.nixsolutions.usermanagement;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

public class UserTest extends TestCase {
    
    // ���� ���������� ��� ������� ���� 7-���-2017
    private static final int CURRENT_YEAR = 2017;
    private static final int YEAR_OF_BIRTH = 1971;
    
    // ����(1) ��� ������ ��� ���� �������� ��� ������, �� ����� ��� ���� � ���� ����    
    // ��������� ������� ���������� �� �������� ���� � ���� ��������
    // ������������ ��� �������
    private static final int ETALONE_AGE_1 = CURRENT_YEAR - YEAR_OF_BIRTH;
    private static final int DAY_OF_BIRTH_1 = 5;
    private static final int MONTH_OF_BIRTH_1 = Calendar.DECEMBER;
    
    // ����(2) ��� ������ ��� ����� �������� ������ � ���� ����
    private static final int ETALONE_AGE_2 = CURRENT_YEAR - YEAR_OF_BIRTH;
    private static final int DAY_OF_BIRTH_2 = 5;
    private static final int MONTH_OF_BIRTH_2 = Calendar.NOVEMBER;
    
    // ����(3) ��� ������ ���� �������� ������
    
    // ����(4) ��� ������ ����� �������� ����, �� ���� �������� ��� �������
    
    // ����(5) ��� ������ ����� ����� �������� ��� �� �������
    
    
    private User user;
    private Date dateOfBirthd;
    
    protected void setUp() throws Exception {
        super.setUp();
        user = new User();
    }

    
    public void testGetFullName() {
        user.setFirstName("John");
        user.setLastName("Doe");
        assertEquals("Doe, John", user.getFullName());
    }
    
    public void testGetAge1() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH_1, DAY_OF_BIRTH_1);
        dateOfBirthd = calendar.getTime();
        user.setDateOfBirth(dateOfBirthd);
        assertEquals(ETALONE_AGE_1, user.getAge());
    }
    
    public void testGetAge2() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH_2, DAY_OF_BIRTH_2);
        dateOfBirthd = calendar.getTime();
        user.setDateOfBirth(dateOfBirthd);
        assertEquals(ETALONE_AGE_2, user.getAge());
    }
}
