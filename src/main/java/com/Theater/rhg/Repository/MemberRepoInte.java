package com.Theater.rhg.Repository;

import com.Theater.domain.Member;
import com.Theater.domain.Review;
import com.Theater.domain.Screen;

import java.util.List;

public interface MemberRepoInte {
    Member findOne(String id);
}
