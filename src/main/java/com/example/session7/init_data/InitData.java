package com.example.session7.init_data;

import com.example.session7.model.entity.Candidate;
import com.example.session7.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {

    private final CandidateRepository candidateRepository;

    @Override
    public void run(String... args) throws Exception {
        if (candidateRepository.count() == 0){
            List<Candidate> candidates = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                candidates.add(Candidate.builder()
                        .fullName("fullname" + (i+1))
                        .email("fullname" + (i+1)+"@gmail.com")
                        .age(i+1)
                        .yearsOfExperience(i+1)
                        .address("123456")
                        .bio("123467")
                        .build());
            }
            candidateRepository.saveAll(candidates);
        }
    }
}
