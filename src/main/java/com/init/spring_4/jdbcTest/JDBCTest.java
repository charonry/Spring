package com.init.spring_4.jdbcTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {
    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate;
    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        ctx = new ClassPathXmlApplicationContext("spring_4/applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        employeeDao = ctx.getBean(EmployeeDao.class);
        departmentDao = ctx.getBean(DepartmentDao.class);
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
    }

    @Test
    public void testUpdate() {
        String sql = "UPDATE employees set LAST_NAME = ? where id=?";
        jdbcTemplate.update(sql, "SYSTER", 1);
    }

    @Test
    public void TestDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testBatchUpdate() {
        String sql = "INSERT INTO employees(LAST_NAME,EMAIL,DEPT_ID) values(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"AA", "aa@atguigu.com", 1});
        batchArgs.add(new Object[]{"BB", "bb@atguigu.com", 2});
        batchArgs.add(new Object[]{"CC", "cc@atguigu.com", 3});
        batchArgs.add(new Object[]{"DD", "dd@atguigu.com", 3});
        batchArgs.add(new Object[]{"EE", "ee@atguigu.com", 2});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    @Test
    public void testQueryForObject() {
        String sql = "select id,EMAIL,LAST_NAME lastName,dept_id  from employees where id=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(employee);
    }

    @Test
    public void testQueryForList() {
        String sql = "SELECT id, last_name lastName, email FROM employees WHERE id > ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper, 2);
        System.out.println(employees);
    }

    @Test
    public void testQueryForObject2() {
        String sql = "SELECT count(id) FROM employees";
        long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }

    @Test
    public void testDepartmentDao() {
        System.out.println(departmentDao.get(1));
    }

    @Test
    public void testEmployeeDao() {
        System.out.println(employeeDao.get(1));
    }

    /**
     * 可以为参数起名字.
     * 1. 好处: 若有多个参数, 则不用再去对应位置, 直接对应参数名, 便于维护
     * 2. 缺点: 较为麻烦.
     */
    @Test
    public void testNamedParameterJdbcTemplate() {
        String sql = "INSERT INTO employees(last_name, email, dept_id) VALUES(:ln,:email,:deptid)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ln", "FF");
        paramMap.put("email", "ff@atguigu.com");
        paramMap.put("deptid", 2);
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    /**
     * 使用具名参数时, 可以使用 update(String sql, SqlParameterSource paramSource) 方法进行更新操作
     * 1. SQL 语句中的参数名和类的属性一致!
     * 2. 使用 SqlParameterSource 的 BeanPropertySqlParameterSource 实现类作为参数.
     */
    @Test
    public void testNamedParameterJdbcTemplate2() {
        String sql = "INSERT INTO employees(last_name, email, dept_id) "
                + "VALUES(:lastName,:email,:dpetId)";
        Employee employee = new Employee();
        employee.setLastName("XYZ");
        employee.setEmail("xyz@sina.com");
        employee.setDeptId(3);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(sql, paramSource);
    }
}
