package com.service;

import com.dao.AreaDao;
import com.entity.Area;

import java.util.List;

/**
 * @author ybl
 * @version 1.0.1
 * @conpany 东风标准
 * @date 2019/11/28 18:55
 * @desciption
 */
public class AreaService {
    AreaDao areaDao = new AreaDao();

    public List<Area> allList() {
        return areaDao.allList();
    }

    public List<Area> getCityById(Integer id) {
        return areaDao.getCityById(id);
    }
}
