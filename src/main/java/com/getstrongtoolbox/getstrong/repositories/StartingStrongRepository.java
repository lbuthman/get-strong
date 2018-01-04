package com.getstrongtoolbox.getstrong.repositories;

import com.getstrongtoolbox.getstrong.domain.StartingStrongWorkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StartingStrongRepository extends JpaRepository<StartingStrongWorkout, Long> {
}
