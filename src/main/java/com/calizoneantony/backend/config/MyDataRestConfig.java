package com.calizoneantony.backend.config;

import com.calizoneantony.backend.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Value("${allowed.origins}")
    private String[] allowedOrigins;

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] exceptGetActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
        HttpMethod[] putDeleteActions = {HttpMethod.PUT, HttpMethod.DELETE};
        HttpMethod[] deleteAction = {HttpMethod.DELETE};

        disableHttpMethods(BillingAddress.class, config, putDeleteActions);
        disableHttpMethods(Country.class, config, exceptGetActions);
        disableHttpMethods(Ebook.class, config, putDeleteActions);
        disableHttpMethods(EbookPage.class, config, putDeleteActions);
        disableHttpMethods(Exercise.class, config, putDeleteActions);
        disableHttpMethods(OnlineCoaching.class, config, putDeleteActions);
        disableHttpMethods(Order.class, config, putDeleteActions);
        disableHttpMethods(Session.class, config, deleteAction);
        disableHttpMethods(SetEntry.class, config, deleteAction);
        disableHttpMethods(State.class, config, exceptGetActions);
        disableHttpMethods(Subscription.class, config, putDeleteActions);
        disableHttpMethods(User.class, config, putDeleteActions);
        disableHttpMethods(Workout.class, config, putDeleteActions);
        disableHttpMethods(WorkoutExercise.class, config, putDeleteActions);

        exposeIds(config);

        cors.addMapping(config.getBasePath() + "/**").allowedOrigins(allowedOrigins);
    }

    private void disableHttpMethods(Object object, RepositoryRestConfiguration config, HttpMethod[] unsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(object.getClass())
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        java.util.Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        List<Class> entityClasses = new ArrayList<>();

        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}
