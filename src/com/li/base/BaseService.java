package com.li.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.li.utils.Pager;


public interface BaseService<T> {
	/**  
     * 插入一个实体  
     * @param entity  
     */  
	int insert(T entity) ; 
      
    /**  
     * 根据实体主键删除一个实体
     */  
    void deleteById(Serializable id);  
    
    /**  
     * 更新一个实体  
     * @param entity  
     */  
    void update(T entity);   
    
    /**
     * 根据参数查询
     */
    public List<T> listByMap(Map<String,Object> params);
    
    /**  
     * 查询所有实体  
     * @return  
     */  
    List<T> listAll();  
  
    /**  
     * 查询所有实体,根据实体属性值为判断条件查询所有实体，  
     * @param entity  
     * @return  
     */  
    List<T> listAllByEntity(T entity);  
      
    /**
     * 根据主键获取一个实体
     * @param id
     * @return
     */
    T getById(Serializable id);
    
    /**
     * 通过map查询
     * @param params
     * @return
     */
    T getByMap(Map<String,Object> params);
    
    /**
     * 通过对象查询
     */
    public T getByEntity(T entity);
    
    
    //=======================一下是分页方法================================
//    /**
//     * 
//     */
//    public Pager<T> findByMap(Map<String,Object> params);
    
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
