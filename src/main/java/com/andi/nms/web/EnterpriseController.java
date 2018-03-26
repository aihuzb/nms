package com.andi.nms.web;
import com.andi.nms.core.Result;
import com.andi.nms.core.ResultGenerator;
import com.andi.nms.bean.Enterprise;
import com.andi.nms.service.EnterpriseService;
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
@RequestMapping("/enterprise")
public class EnterpriseController {
    @Resource
    private EnterpriseService enterpriseService;

    @PostMapping("/add")
    public Result add(Enterprise enterprise) {
        enterpriseService.save(enterprise);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        enterpriseService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Enterprise enterprise) {
        enterpriseService.update(enterprise);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Enterprise enterprise = enterpriseService.findById(id);
        return ResultGenerator.genSuccessResult(enterprise);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Enterprise> list = enterpriseService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
