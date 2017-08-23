package com.yalovchuk.dao;

import com.yalovchuk.bean.Voting;
import org.springframework.data.repository.CrudRepository;

public interface VotingRepository extends CrudRepository<Voting, Long> {
}
