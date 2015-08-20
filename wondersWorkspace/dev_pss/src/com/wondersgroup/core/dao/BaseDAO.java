package com.wondersgroup.core.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.wondersgroup.core.bean.Page;
import com.wondersgroup.core.exception.DAOException;

@Repository
public class BaseDAO extends BaseDAOSupport {
    @PersistenceContext
    protected EntityManager em;

    /**
     * 根据实体类型和主键获取实体对象
     * 
     * @param entityClass
     * @param id
     * @return
     */
    protected <T> T get(Class<T> entityClass, Object id) {
        try {
            return em.find(entityClass, id);
        } catch (HibernateException ex) {
            throw new DAOException(ex);
        }
    }

    /**
     * 保存实体对象
     * 
     * @param entity
     */
    protected <T> void save(T entity) {
        try {
            em.persist(entity);
        } catch (HibernateException ex) {
            throw new DAOException(ex);
        }
    }

    /**
     * 更新实体对象
     * 
     * @param entity
     */
    protected <T> T update(T entity) {
        try {
            return em.merge(entity);
        } catch (HibernateException ex) {
            throw new DAOException(ex);
        }
    }

    /**
     * 删除实体对象
     * 
     * @param entity
     */
    protected <T> void delete(T entity) {
        try {
            em.remove(em.merge(entity));
        } catch (HibernateException ex) {
            throw new DAOException(ex);
        }
    }

    /**
     * 根据SQL语句（使用聚合函数count）获取记录数
     * 
     * @param ql
     * @param params 参数（可选）
     * @return
     */
    protected int countBySQL(String ql, Object... params) {
        return super.countBySQL(em, ql, params);
    }

    /**
     * 根据JPQL语句（使用聚合函数count）获取记录数
     * 
     * @param ql
     * @param params 参数（可选）
     * @return
     */
    protected int countByJPQL(String ql, Object... params) {
        return super.countByJPQL(em, ql, params);
    }

    /**
     * 根据SQL语句查询获取单个对象
     * 
     * @param ql
     * @param params 参数（可选）
     * @return
     */
    protected <T> T findUniqueBySQL(String ql, Object... params) {
        return super.findUniqueBySQL(em, ql, params);
    }

    /**
     * 根据JPQL语句查询获取单个对象
     * 
     * @param ql
     * @param params 参数（可选）
     * @return
     */
    protected <T> T findUniqueByJPQL(String ql, Object... params) {
        return super.findUniqueByJPQL(em, ql, params);
    }

    /**
     * 根据SQL语句查询
     * 
     * @param ql
     * @param params 参数（可选）
     * @return
     */
    protected <T> List<T> findBySQL(String ql, Object... params) {
        return super.findBySQL(em, ql, params);
    }

    /**
     * 根据JPQL语句查询
     * 
     * @param ql
     * @param params 参数（可选）
     * @return
     */
    protected <T> List<T> findByJPQL(String ql, Object... params) {
        return super.findByJPQL(em, ql, params);
    }

    /**
     * 根据SQL语句分页查询，返回页对象
     * 
     * @param ql
     * @param pn 当前页码
     * @param ps 每页记录数
     * @param params 参数（可选）
     * @return
     */
    protected Page findBySQLWithPage(String ql, int pn, int ps, Object... params) {
        return super.findBySQLWithPage(em, ql, pn, ps, params);
    }

    /**
     * 根据JPQL语句分页查询，返回页对象
     * 
     * @param ql
     * @param pn 当前页码
     * @param ps 每页记录数
     * @param params 参数（可选）
     * @return
     */
    protected Page findByJPQLWithPage(String ql, int pn, int ps, Object... params) {
        return super.findByJPQLWithPage(em, ql, pn, ps, params);
    }
}
