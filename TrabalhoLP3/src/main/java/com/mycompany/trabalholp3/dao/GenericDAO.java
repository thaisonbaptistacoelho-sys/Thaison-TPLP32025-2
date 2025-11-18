/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalholp3.dao;

import java.util.List;

/**
 *
 * @author Thaison
 */
public class GenericDAO<T> {

    @PersistenceContext
    protected EntityManager em;

    private Class<T> clazz;

    public GenericDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void salvar(T entidade) {
        em.persist(entidade);
    }

    public T buscar(Long id) {
        return em.find(clazz, id);
    }

    public T atualizar(T entidade) {
        return em.merge(entidade);
    }

    public void deletar(Long id) {
        T entidade = buscar(id);
        if (entidade != null) {
            em.remove(entidade);
        }
    }

    public List<T> listarTodos() {
        return em.createQuery("FROM " + clazz.getSimpleName(), clazz)
                 .getResultList();
    }
}
