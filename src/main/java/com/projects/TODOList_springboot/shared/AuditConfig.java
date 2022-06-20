package com.projects.TODOList_springboot.shared;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditConfig {
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
