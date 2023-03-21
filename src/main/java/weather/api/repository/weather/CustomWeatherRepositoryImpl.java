package weather.api.repository.weather;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import weather.api.dto.AvgWeatherDTO;
import weather.api.entity.ConditionEntity;
import weather.api.entity.LocationEntity;
import weather.api.entity.WeatherEntity;
import weather.api.repository.ConditionRepository;
import weather.api.repository.LocationRepository;

import java.time.LocalDate;

@Repository
@RequiredArgsConstructor
public class CustomWeatherRepositoryImpl implements CustomWeatherRepository {
    private final LocationRepository locationRepository;

    private final ConditionRepository conditionRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    @Transactional
    @Override
    public void saveIfExists(WeatherEntity weatherEntity) {
        LocationEntity locationEntity = weatherEntity.getLocation();
        ConditionEntity conditionEntity = weatherEntity.getCondition();

        locationRepository.findOne(Example.of(locationEntity)).ifPresent(weatherEntity::setLocation);
        conditionRepository.findOne(Example.of(conditionEntity)).ifPresent(weatherEntity::setCondition);

        entityManager.persist(weatherEntity);
    }

    @Override
    public AvgWeatherDTO getAvgWeatherInfoByPeriod(LocalDate from, LocalDate to) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AvgWeatherDTO> criteriaQuery = criteriaBuilder.createQuery(AvgWeatherDTO.class);
        Root<WeatherEntity> root = criteriaQuery.from(WeatherEntity.class);

        Predicate dateRangePredicate = criteriaBuilder.between(root.get("lastUpdated"), from, to);

        criteriaQuery
                .select(
                        criteriaBuilder.construct(AvgWeatherDTO.class,
                            criteriaBuilder.avg(root.get("temp")),
                            criteriaBuilder.avg(root.get("windMph")),
                            criteriaBuilder.avg(root.get("pressureMb")),
                            criteriaBuilder.avg(root.get("humidity"))))
                .where(dateRangePredicate);

        TypedQuery<AvgWeatherDTO> query = entityManager.createQuery(criteriaQuery);

        return query.getSingleResult();
    }
}
