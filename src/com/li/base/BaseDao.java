package com.li.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.li.utils.Pager;

/**
 * 基础dao封装一些简单的方法
 * @author 
 *
 */
public interface BaseDao<T>{
	/**  
     * 插入一个实体  
     * @param entity  
     */  
	public int insert(T entity) ; 
      
    /**  
     * 根据实体主键删除一个实体
     */  
	public void deleteById(Serializable id);  
    
    /**  
     * 更新一个实体  
     * @param entity  
     */  
	public void update(T entity);   
    
    /**
     * 根据参数查询
     * 在Mapper.xml文件实现了，不过当前项目没用到，仅当后续扩展
     */
    public List<T> listByMap(Map<String,Object> params);
    
    /**  
     * 查询所有实体  
     * @return  
     */  
    public List<T> listAll();  
  
    /**  
     * 查询所有实体,根据实体属性值为判断条件查询所有实体
     * @param entity  
     * @return  
     */  
    public List<T> listAllByEntity(T entity);

    /**
     * 根据主键获取一个实体
     * @param id
     * @return
     */
    public T getById(Serializable id);

    /**
     * 根据map查询单一个实体
     * 在Mapper.xml文件实现了，不过当前项目没用到，仅当后续扩展
     * @param params
     * @return
     */
    public T getByMap(Map<String,Object> params);

    /**
     * 通过对象查询
     */
    public T getByEntity(T entity);
    
    /**
     * 通过对象查询分页
     * @param entity
     * @return
     */
    public Pager<T> findByEntityPaging(T entity);
    
    /**
     * 批量新增
     * @param list
     */
    public void insertBatch(List<T> list);
    
    /**
     * 批量修改
     * @param list
     */
    public void updateBatch(List<T> list);
    
}
