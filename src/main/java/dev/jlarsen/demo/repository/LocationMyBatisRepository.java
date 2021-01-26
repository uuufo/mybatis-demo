package dev.jlarsen.demo.repository;

import dev.jlarsen.demo.models.Location;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LocationMyBatisRepository {

    @Insert("INSERT INTO locations(city, country) VALUES(#{city}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertLocation(Location location);

    @Select("SELECT * FROM locations WHERE id=#{id}")
    public Location selectById(Long id);

    @Select("SELECT * FROM locations")
    public List<Location> findAll();

    @Delete("DELETE FROM locations WHERE id=#{id}")
    public boolean delete(Long id);

    @Update("UPDATE locations SET city=#{city}, country=#{country} WHERE id=#{id}")
    public boolean update(Location location);
}
