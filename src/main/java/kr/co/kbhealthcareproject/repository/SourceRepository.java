package kr.co.kbhealthcareproject.repository;

import kr.co.kbhealthcareproject.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<Source,String> {
}
