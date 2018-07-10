package com.techwizards.inmemory.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author TechWizards
 */
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Mr. TechWizards");
    }

}
