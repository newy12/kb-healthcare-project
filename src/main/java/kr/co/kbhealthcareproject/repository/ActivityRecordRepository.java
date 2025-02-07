package kr.co.kbhealthcareproject.repository;

import kr.co.kbhealthcareproject.entity.ActivityRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRecordRepository extends JpaRepository<ActivityRecord, String> {
}
