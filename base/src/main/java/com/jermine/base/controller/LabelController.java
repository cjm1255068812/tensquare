package com.jermine.base.controller;

import com.jermine.base.entity.Label;
import com.jermine.base.service.LabelService;
import com.jermine.common.entity.Response;
import com.jermine.common.util.ResponseUtils;
import jdk.nashorn.internal.ir.Labels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping
    public Response<List<Label>> findAll() {
        List<Label> labelList = labelService.findAll();
        return ResponseUtils.success(labelList);
    }

    @GetMapping("/{labelId}")
    public Response<Label> findById(@PathVariable("labelId") String labelId) {
        Label label = labelService.findById(labelId);
        return ResponseUtils.success(label);
    }

    @PostMapping
    public Response save(@RequestBody @Validated Label label) {
        labelService.save(label);
        return ResponseUtils.success(null, "保存成功");
    }

    @PutMapping("/{labelId}")
    public Response update(@PathVariable("labelId") String labelId, @RequestBody Label label) {
        labelService.update(label);
        return ResponseUtils.success(null, "更新成功");
    }

    @DeleteMapping("/{labelId}")
    public Response deleteById(@PathVariable("labelId") String labelId) {
        labelService.deleteById(labelId);
        return ResponseUtils.success(null, "删除成功");
    }

    @PostMapping("/search")
    public Response findSearch(@RequestBody Label label) {
        List<Label> list =  labelService.findSearch(label);
        return ResponseUtils.success(list, "查询成功");
    }

}
