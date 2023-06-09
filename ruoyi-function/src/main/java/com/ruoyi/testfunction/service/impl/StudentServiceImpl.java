package com.ruoyi.testfunction.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.testfunction.mapper.StudentMapper;
import com.ruoyi.testfunction.domain.Student;
import com.ruoyi.testfunction.service.IStudentService;

/**
 * 学生信息Service业务层处理
 *
 * @author LF
 * @date 2023-01-04
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询学生信息
     *
     * @param id 学生信息主键
     * @return 学生信息
     */
    @Override
    public Student selectStudentById(Long id) {
        return studentMapper.selectStudentById(id);
    }

    /**
     * 查询学生信息列表
     *
     * @param student 学生信息
     * @return 学生信息
     */
    @Override
    public List<Student> selectStudentList(Student student) {
        return studentMapper.selectStudentList(student);
    }

    /**
     * 新增学生信息
     *
     * @param student 学生信息
     * @return 结果
     */
    @Override
    public int insertStudent(Student student) {
                student.setCreateTime(DateUtils.getNowDate());
            return studentMapper.insertStudent(student);
    }

    /**
     * 修改学生信息
     *
     * @param student 学生信息
     * @return 结果
     */
    @Override
    public int updateStudent(Student student) {
                student.setUpdateTime(DateUtils.getNowDate());
        return studentMapper.updateStudent(student);
    }

    /**
     * 批量删除学生信息
     *
     * @param ids 需要删除的学生信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentByIds(Long[] ids) {
        return studentMapper.deleteStudentByIds(ids);
    }

    /**
     * 删除学生信息信息
     *
     * @param id 学生信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentById(Long id) {
        return studentMapper.deleteStudentById(id);
    }
}
