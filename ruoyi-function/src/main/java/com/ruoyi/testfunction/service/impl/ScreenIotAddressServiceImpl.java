package com.ruoyi.testfunction.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.testfunction.mapper.ScreenIotAddressMapper;
import com.ruoyi.testfunction.domain.ScreenIotAddress;
import com.ruoyi.testfunction.service.IScreenIotAddressService;

/**
 * 【智慧物联】地址信息Service业务层处理
 *
 * @author LF
 * @date 2023-01-04
 */
@Service
public class ScreenIotAddressServiceImpl implements IScreenIotAddressService {
    @Autowired
    private ScreenIotAddressMapper screenIotAddressMapper;

    /**
     * 查询【智慧物联】地址信息
     *
     * @param id 【智慧物联】地址信息主键
     * @return 【智慧物联】地址信息
     */
    @Override
    public ScreenIotAddress selectScreenIotAddressById(Long id) {
        return screenIotAddressMapper.selectScreenIotAddressById(id);
    }

    /**
     * 查询【智慧物联】地址信息列表
     *
     * @param screenIotAddress 【智慧物联】地址信息
     * @return 【智慧物联】地址信息
     */
    @Override
    public List<ScreenIotAddress> selectScreenIotAddressList(ScreenIotAddress screenIotAddress) {
        return screenIotAddressMapper.selectScreenIotAddressList(screenIotAddress);
    }

    /**
     * 新增【智慧物联】地址信息
     *
     * @param screenIotAddress 【智慧物联】地址信息
     * @return 结果
     */
    @Override
    public int insertScreenIotAddress(ScreenIotAddress screenIotAddress) {
        screenIotAddress.setCreateTime(DateUtils.getNowDate());
        return screenIotAddressMapper.insertScreenIotAddress(screenIotAddress);
    }

    /**
     * 修改【智慧物联】地址信息
     *
     * @param screenIotAddress 【智慧物联】地址信息
     * @return 结果
     */
    @Override
    public int updateScreenIotAddress(ScreenIotAddress screenIotAddress) {
        screenIotAddress.setUpdateTime(DateUtils.getNowDate());
        return screenIotAddressMapper.updateScreenIotAddress(screenIotAddress);
    }

    /**
     * 批量删除【智慧物联】地址信息
     *
     * @param ids 需要删除的【智慧物联】地址信息主键
     * @return 结果
     */
    @Override
    public int deleteScreenIotAddressByIds(Long[] ids) {
        return screenIotAddressMapper.deleteScreenIotAddressByIds(ids);
    }

    /**
     * 删除【智慧物联】地址信息信息
     *
     * @param id 【智慧物联】地址信息主键
     * @return 结果
     */
    @Override
    public int deleteScreenIotAddressById(Long id) {
        return screenIotAddressMapper.deleteScreenIotAddressById(id);
    }
}
