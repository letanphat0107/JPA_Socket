/*
 * @ (#) CreateEntity.java     1.0   4/1/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

import entity.Course;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/1/2024
 * @version:  1.0
 */
public class CreateEntity {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_SQL");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try{
            et.begin();
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
