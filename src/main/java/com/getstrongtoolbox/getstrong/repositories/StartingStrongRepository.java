package com.getstrongtoolbox.getstrong.repositories;

import com.getstrongtoolbox.getstrong.domain.StartingStrongWorkout;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StartingStrongRepository extends PagingAndSortingRepository<StartingStrongWorkout, Long> {

    public List<StartingStrongWorkout> findAllByOrderByIdDesc();
}
