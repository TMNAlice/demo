package com.example.demo.config;


import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PortsConfig {
    @Value("${server.http.port}")
    private int httpPort;

    @Value("${server.https.port}")
    private int httpsPort;

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> containerCustomizer() {
        return (ConfigurableServletWebServerFactory container) -> {
            if (container instanceof TomcatServletWebServerFactory) {
                TomcatServletWebServerFactory containerFactory
                        = (TomcatServletWebServerFactory) container;

                Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
                connector.setPort (httpPort);
                connector.setRedirectPort(httpsPort);
                containerFactory.addAdditionalTomcatConnectors(connector);
            }
        };
    }

    @Bean
    public TomcatServletWebServerFactory servltContainer () {
        return new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext (org.apache.catalina.Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/login");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
    }
}
