package com.muffin.web.investProfile;

import com.muffin.web.util.GenericService;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface InvestProfileService extends GenericService<InvestProfile>{

    void save(InvestProfileVO investProfile);
}

@Service
public class InvestProfileServiceImpl implements InvestProfileService {

    private final InvestProfileRepository repository;

    public InvestProfileServiceImpl(InvestProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(InvestProfileVO investProfile) {
        InvestProfile ip = new InvestProfile(investProfile.getInvestmentPeriod(), investProfile.getInvestmentPropensity(), investProfile.getUser());
        repository.save(ip);
    }

    @Override
    public Optional<InvestProfile> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Iterable<InvestProfile> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public boolean exists(String id) {
        return false;
    }
}
