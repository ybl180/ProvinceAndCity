package com.servlet;

import com.alibaba.fastjson.JSON;
import com.entity.Area;
import com.service.AreaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author ybl
 * @version 1.0.1
 * @conpany 东风标准
 * @date 2019/11/28 18:58
 * @desciption
 */
@WebServlet("/district")
public class DistrictServlet extends HttpServlet {
    AreaService areaService = new AreaService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("cityId");
        List<Area> list = areaService.getCityById(Integer.valueOf(id));
        String listObjStr = JSON.toJSONString(list);
        PrintWriter out = resp.getWriter();
        out.append(listObjStr);
    }
}
