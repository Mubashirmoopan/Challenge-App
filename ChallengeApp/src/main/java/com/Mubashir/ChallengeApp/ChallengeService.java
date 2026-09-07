package com.Mubashir.ChallengeApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {

    private Long nextId = 1L;
    @Autowired
    ChallengeRepository challengeRepository;

    public ChallengeService() {

    }
    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    public boolean addChallenge(Challenge challenge) {
        if(challenge!= null) {
            challenge.setId(nextId++);
            challengeRepository.save(challenge);
            return true;
        }
        else
        {
            return false;
        }

        }

    public Challenge getChallenge(String month) {
        Optional<Challenge> challenge = challengeRepository.findByMonthIgnoreCase(month);
        return challenge.orElse(null);
    }

    public boolean updateChallenge(long id, Challenge updatedChallenge) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if (challenge.isPresent()) {
            Challenge existingChallenge = challenge.get();
            existingChallenge.setMonth(updatedChallenge.getMonth());
            existingChallenge.setDescription(updatedChallenge.getDescription());
            challengeRepository.save(existingChallenge);
            return true;
            }

        return false;
    }

    public boolean deleteChallenge(long id)
    {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if (challenge.isPresent())
        {
            challengeRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
