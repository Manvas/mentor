package lt.jauga.service;

import lt.jauga.domain.User;
import lt.jauga.repository.RoleRepository;
import lt.jauga.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImp.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
     * (non-Javadoc)
     *
     * @see com.example.service.UserService#save(com.example.model.User)
     */
    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        // Set Role to ROLE_USER
        user.setRoles(Collections.singletonList(roleRepository.findByRole("ROLE_USER")));
        return userRepository.saveAndFlush(user);

    }

    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            String username = ((UserDetails) userDetails).getUsername();
            LOG.info("Logged in username:" + username);
            return username;
        }

        return null;
    }

    @Override
    public User findByUsernameAndTenantname(String username, String tenant) {
        User user = userRepository.findByUsernameAndTenantname(username, tenant);
        LOG.info("Found user with username:" + user.getUsername() + " from tenant:" + user.getTenant());
        return user;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Collection<User> findAllOrderedByUsername(){ return userRepository.findAllByOrderByUsernameDesc();}

    @Override
    public Collection<User> findAllByProfession(User user){ return userRepository.findByProfession(user.getProfession());    }

}
