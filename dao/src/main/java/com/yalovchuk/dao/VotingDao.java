package com.yalovchuk.dao;

import com.yalovchuk.bean.Voting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VotingDao extends CrudRepository<Voting, Long> {

    List<Voting> getAllByTopicId(Long topic_id);
}
