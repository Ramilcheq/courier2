package courier.service;

import courier.domain.Role;
import courier.persistence.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.getUser(username);
    }

    public List<Role> getRoles() {
        return userMapper.getRoles();
    }

    public void save(String username, String password, Integer roleId) {
        userMapper.save(username, encoder.encode(password), roleId);
    }
}
