package com.example.session7.controller;

import com.example.session7.model.dto.request.CandidateCreateDTO;
import com.example.session7.model.dto.request.CandidateUpdateDTO;
import com.example.session7.model.entity.Candidate;
import com.example.session7.service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @GetMapping
    public List<Candidate> getAll() {
        return candidateService.getAll();
    }

    @PostMapping
    public Candidate createCandidate(@Valid @RequestBody CandidateCreateDTO dto) {
        return candidateService.create(dto);
    }

    @PutMapping("/update/{id}")
    public Candidate updateCandidate(
            @PathVariable Integer id,
            @Valid @ModelAttribute CandidateUpdateDTO dto) {

        return candidateService.update(id, dto);
    }
}
