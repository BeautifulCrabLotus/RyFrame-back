package com.ruoyi.testfunction.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.testfunction.domain.ScreenIotAddress;
import com.ruoyi.testfunction.service.IScreenIotAddressService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【智慧物联】地址信息Controller
 *
 * @author LF
 * @date 2023-01-04
 */
@RestController
@RequestMapping("/testfunction/address")
public class ScreenIotAddressController extends BaseController {
    @Autowired
    private IScreenIotAddressService screenIotAddressService;

    /**
     * 查询【智慧物联】地址信息列表
     */
    @PreAuthorize("@ss.hasPermi('testfunction:address:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScreenIotAddress screenIotAddress) {
        startPage();
        List<ScreenIotAddress> list = screenIotAddressService.selectScreenIotAddressList(screenIotAddress);
        return getDataTable(list);
    }

    /**
     * 导出【智慧物联】地址信息列表
     */
    @PreAuthorize("@ss.hasPermi('testfunction:address:export')")
    @Log(title = "【智慧物联】地址信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScreenIotAddress screenIotAddress) {
        List<ScreenIotAddress> list = screenIotAddressService.selectScreenIotAddressList(screenIotAddress);
        ExcelUtil<ScreenIotAddress> util = new ExcelUtil<ScreenIotAddress>(ScreenIotAddress.class);
        util.exportExcel(response, list, "【智慧物联】地址信息数据");
    }

    /**
     * 获取【智慧物联】地址信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('testfunction:address:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(screenIotAddressService.selectScreenIotAddressById(id));
    }

    /**
     * 新增【智慧物联】地址信息
     */
    @PreAuthorize("@ss.hasPermi('testfunction:address:add')")
    @Log(title = "【智慧物联】地址信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScreenIotAddress screenIotAddress) {
        return toAjax(screenIotAddressService.insertScreenIotAddress(screenIotAddress));
    }

    /**
     * 修改【智慧物联】地址信息
     */
    @PreAuthorize("@ss.hasPermi('testfunction:address:edit')")
    @Log(title = "【智慧物联】地址信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScreenIotAddress screenIotAddress) {
        return toAjax(screenIotAddressService.updateScreenIotAddress(screenIotAddress));
    }

    /**
     * 删除【智慧物联】地址信息
     */
    @PreAuthorize("@ss.hasPermi('testfunction:address:remove')")
    @Log(title = "【智慧物联】地址信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(screenIotAddressService.deleteScreenIotAddressByIds(ids));
    }
}
