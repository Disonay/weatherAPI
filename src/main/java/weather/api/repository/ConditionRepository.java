package weather.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.api.entity.ConditionEntity;

public interface ConditionRepository extends JpaRepository<ConditionEntity, Long> {
}
