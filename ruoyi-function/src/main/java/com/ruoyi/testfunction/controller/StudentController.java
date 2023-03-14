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
import com.ruoyi.testfunction.domain.Student;
import com.ruoyi.testfunction.service.IStudentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生信息Controller
 *
 * @author LF
 * @date 2023-01-04
 */
@RestController
@RequestMapping("/testfunction/student")
public class StudentController extends BaseController {
    @Autowired
    private IStudentService studentService;

/**
 * 查询学生信息列表
 */
@PreAuthorize("@ss.hasPermi('testfunction:student:list')")
@GetMapping("/list")
    public TableDataInfo list(Student student) {
        startPage();
        List<Student> list = studentService.selectStudentList(student);
        return getDataTable(list);
    }

    /**
     * 导出学生信息列表
     */
    @PreAuthorize("@ss.hasPermi('testfunction:student:export')")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Student student) {
        List<Student> list = studentService.selectStudentList(student);
        ExcelUtil<Student> util = new ExcelUtil<Student>(Student. class);
        util.exportExcel(response, list, "学生信息数据");
    }

    /**
     * 获取学生信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('testfunction:student:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(studentService.selectStudentById(id));
    }

    /**
     * 新增学生信息
     */
    @PreAuthorize("@ss.hasPermi('testfunction:student:add')")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Student student) {
        return toAjax(studentService.insertStudent(student));
    }

    /**
     * 修改学生信息
     */
    @PreAuthorize("@ss.hasPermi('testfunction:student:edit')")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Student student) {
        return toAjax(studentService.updateStudent(student));
    }

    /**
     * 删除学生信息
     */
    @PreAuthorize("@ss.hasPermi('testfunction:student:remove')")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(studentService.deleteStudentByIds(ids));
    }
}
