package kr.co.kbhealthcareproject.repository;

import kr.co.kbhealthcareproject.entity.ActivityRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRecordRepository extends JpaRepository<ActivityRecord, String> {
    List<ActivityRecord> findByRecordKey(String recordKey);
}
