package pl.prz.l6.systempotwierdzaniawizyt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prz.l6.systempotwierdzaniawizyt.repository.*;

@Service
public class SystemSettingsService {
    private final SystemSettingsRepository systemSettingsRepository;

    @Autowired
    public SystemSettingsService(SystemSettingsRepository systemSettingsRepository) {
        this.systemSettingsRepository = systemSettingsRepository;
    }
}
