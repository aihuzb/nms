package com.andi.nms.business.web;
import com.andi.nms.sys.core.Result;
import com.andi.nms.sys.core.ResultGenerator;
import com.andi.nms.business.bean.Entity;
import com.andi.nms.business.service.EntityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/04/12.
*/
@RestController
@RequestMapping("/entity")
public class EntityController {
    @Resource
    private EntityService entityService;

    @PostMapping("/add")
    public Result add(Entity entity) {
        entityService.save(entity);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        entityService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Entity entity) {
        entityService.update(entity);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Entity entity = entityService.findById(id);
        return ResultGenerator.genSuccessResult(entity);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Entity> list = entityService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
