package com.example.session7.service.impl;

import com.example.session7.model.dto.request.CandidateCreateDTO;
import com.example.session7.model.dto.request.CandidateUpdateDTO;
import com.example.session7.model.entity.Candidate;
import com.example.session7.repository.CandidateRepository;
import com.example.session7.service.CandidateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;

    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public Candidate create(CandidateCreateDTO dto) {

        Candidate candidate = new Candidate();

        candidate.setFullName(dto.getFullName());
        candidate.setEmail(dto.getEmail());
        candidate.setAge(dto.getAge());
        candidate.setYearsOfExperience(dto.getYearsOfExperience());

        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate update(Integer id, CandidateUpdateDTO dto) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ứng viên"));

        candidate.setAddress(dto.getAddress());
        candidate.setBio(dto.getBio());

        return candidateRepository.save(candidate);
    }

    @Override
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }
}
