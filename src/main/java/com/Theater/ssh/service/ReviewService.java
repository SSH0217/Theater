package com.Theater.ssh.service;

import com.Theater.domain.Review;
import com.Theater.ssh.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> findReviews(Long id){
        return reviewRepository.findAllByMovieId(id);
    }
}
