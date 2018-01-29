package com.coalvalue.configuration;/*
package com.coalvalue.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSolrRepositories
public class SearchContext {


    @Bean
    public EmbeddedSolrServerFactoryBean solrServerFactoryBean() {
        EmbeddedSolrServerFactoryBean factory = new EmbeddedSolrServerFactoryBean();

        factory.setSolrHome("");

        return factory;
    }

    @Bean
    public SolrTemplate solrTemplate() throws Exception {
        return new SolrTemplate(solrServerFactoryBean().getObject());
    }
}*/
