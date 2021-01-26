package dev.jlarsen.demo.repository;

import java.util.List;

import dev.jlarsen.demo.models.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMyBatisRepository {
    @Select("SELECT * FROM employees")
    public List<Employee> findAll();

    @Select("SELECT * FROM employees WHERE id = #{id}")
    public Employee findById(long id);

    @Delete("DELETE FROM employees WHERE id = #{id}")
    public int deleteById(long id);

    @Insert("INSERT INTO employees(first_name, last_name, email) " +
            "VALUES (#{firstName}, #{lastName}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(Employee employee);

    @Update("UPDATE employees SET first_name=#{firstName}, last_name=#{lastName}," +
            " email=#{email} WHERE id=#{id}")
    public int update(Employee employee);
}