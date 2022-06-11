package com.Theater.rhg.Repository;

import com.Theater.domain.Member;
import com.Theater.domain.Review;

import java.util.List;

public interface MemberRepoInte {
    Member findOne(String id);
//    List<Review> findTicketList(int id);
}
