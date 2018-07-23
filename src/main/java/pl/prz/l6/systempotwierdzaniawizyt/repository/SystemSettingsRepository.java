package pl.prz.l6.systempotwierdzaniawizyt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prz.l6.systempotwierdzaniawizyt.model.SystemSettings;

import java.util.Optional;

@Repository
public interface SystemSettingsRepository extends JpaRepository<SystemSettings, Long> {
}
