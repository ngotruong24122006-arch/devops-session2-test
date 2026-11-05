package com.example.session7.service;

import com.example.session7.model.dto.request.CandidateCreateDTO;
import com.example.session7.model.dto.request.CandidateUpdateDTO;
import com.example.session7.model.entity.Candidate;

import java.util.List;

public interface CandidateService {
    Candidate create(CandidateCreateDTO dto);
    Candidate update(Integer id, CandidateUpdateDTO dto);
    List<Candidate> getAll();
}
