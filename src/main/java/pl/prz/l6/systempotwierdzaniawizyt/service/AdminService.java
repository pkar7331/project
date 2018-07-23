package pl.prz.l6.systempotwierdzaniawizyt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.prz.l6.systempotwierdzaniawizyt.model.Admin;
import pl.prz.l6.systempotwierdzaniawizyt.repository.AdminRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository){
        this.adminRepository=adminRepository;
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    public Optional<Admin> findAdminByEmail(String email){
        return adminRepository.findByEmail(email);
    }

    public void save(Admin admin){
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
    }


}
