package com.coalvalue.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by Peter Xu on 1/9/2015.
 */
public class BaseJpaRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable>
        extends JpaRepositoryFactoryBean<R, T, I> {

    /**
     * Creates a new {@link org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean} for the given repository interface.
     *
     * @param repositoryInterface must not be {@literal null}.
     */
    public BaseJpaRepositoryFactoryBean(Class<? extends R> repositoryInterface) {
        super(repositoryInterface);
    }

    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new BaseJpaRepositoryFactory(entityManager);
    }

    private static class BaseJpaRepositoryFactory<T, I extends Serializable>
            extends JpaRepositoryFactory {

        private EntityManager entityManager;

        public BaseJpaRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
            this.entityManager = entityManager;
        }

      //  @Override
        protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryMetadata metadata,
                                                                                             EntityManager entityManager) {
            return new BaseJpaRepositoryImpl(metadata.getDomainType(), entityManager);
        }

      //  @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return BaseJpaRepositoryImpl.class;
        }
    }
}