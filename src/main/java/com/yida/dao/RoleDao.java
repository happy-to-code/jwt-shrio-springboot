package com.yida.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yida.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 角色表(Role)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-05 18:53:42
 */
public interface RoleDao extends BaseMapper<Role> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Role queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Role> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param role 实例对象
     * @return 对象列表
     */
    List<Role> queryAll(Role role);

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过userID查询
     *
     * @param userId
     * @return
     */
    List<Role> findByUserId(Integer userId);
}
