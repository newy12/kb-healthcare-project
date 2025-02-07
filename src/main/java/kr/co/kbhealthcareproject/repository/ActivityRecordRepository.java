package kr.co.kbhealthcareproject.repository;

import kr.co.kbhealthcareproject.entity.ActivityRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActivityRecordRepository extends JpaRepository<ActivityRecord, String> {
    List<ActivityRecord> findByRecordKey(String recordKey);
}
