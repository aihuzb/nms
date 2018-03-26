package com.andi.nms.web;
import com.andi.nms.core.Result;
import com.andi.nms.core.ResultGenerator;
import com.andi.nms.bean.Department;
import com.andi.nms.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/02/10.
*/
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    @PostMapping("/add")
    public Result add(Department department) {
        departmentService.save(department);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        departmentService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Department department) {
        departmentService.update(department);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Department department = departmentService.findById(id);
        return ResultGenerator.genSuccessResult(department);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Department> list = departmentService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
