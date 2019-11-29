package com.dao;

import com.entity.Area;
import com.utils.JdbctemplateUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author ybl
 * @version 1.0.1
 * @conpany 东风标准
 * @date 2019/11/28 18:45
 * @desciption
 */
public class AreaDao {
    JdbcTemplate template = new JdbcTemplate(JdbctemplateUtil.getDataSource());

    public List<Area> allList() {
        String sql = "select * from province_city where type=1";
        return template.query(sql, new BeanPropertyRowMapper<>(Area.class));
    }

    public List<Area> getCityById(Integer id){
        String sql="select * from province_city where p_id=?";
        return template.query(sql, new BeanPropertyRowMapper<>(Area.class),id);
    }
}
