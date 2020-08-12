package com.muffin.web.investProfile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestProfileRepository extends JpaRepository<InvestProfile, Long>, IInvestProfileRepository {
}
