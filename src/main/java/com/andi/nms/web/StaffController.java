package com.andi.nms.web;
import com.andi.nms.core.Result;
import com.andi.nms.core.ResultGenerator;
import com.andi.nms.bean.Staff;
import com.andi.nms.service.StaffService;
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
@RequestMapping("/staff")
public class StaffController {
    @Resource
    private StaffService staffService;

    @PostMapping("/add")
    public Result add(Staff staff) {
        staffService.save(staff);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        staffService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Staff staff) {
        staffService.update(staff);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Staff staff = staffService.findById(id);
        return ResultGenerator.genSuccessResult(staff);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Staff> list = staffService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
