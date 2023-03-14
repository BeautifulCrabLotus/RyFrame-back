package com.ruoyi.testfunction.service;

import java.util.List;

import com.ruoyi.testfunction.domain.ScreenIotAddress;

/**
 * 【智慧物联】地址信息Service接口
 *
 * @author LF
 * @date 2023-01-04
 */
public interface IScreenIotAddressService {
    /**
     * 查询【智慧物联】地址信息
     *
     * @param id 【智慧物联】地址信息主键
     * @return 【智慧物联】地址信息
     */
    public ScreenIotAddress selectScreenIotAddressById(Long id);

    /**
     * 查询【智慧物联】地址信息列表
     *
     * @param screenIotAddress 【智慧物联】地址信息
     * @return 【智慧物联】地址信息集合
     */
    public List<ScreenIotAddress> selectScreenIotAddressList(ScreenIotAddress screenIotAddress);

    /**
     * 新增【智慧物联】地址信息
     *
     * @param screenIotAddress 【智慧物联】地址信息
     * @return 结果
     */
    public int insertScreenIotAddress(ScreenIotAddress screenIotAddress);

    /**
     * 修改【智慧物联】地址信息
     *
     * @param screenIotAddress 【智慧物联】地址信息
     * @return 结果
     */
    public int updateScreenIotAddress(ScreenIotAddress screenIotAddress);

    /**
     * 批量删除【智慧物联】地址信息
     *
     * @param ids 需要删除的【智慧物联】地址信息主键集合
     * @return 结果
     */
    public int deleteScreenIotAddressByIds(Long[] ids);

    /**
     * 删除【智慧物联】地址信息信息
     *
     * @param id 【智慧物联】地址信息主键
     * @return 结果
     */
    public int deleteScreenIotAddressById(Long id);
}
