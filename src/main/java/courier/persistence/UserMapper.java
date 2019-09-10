package courier.persistence;

import courier.domain.Role;
import courier.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User getUser(String username);

    List<Role> getRoles();

    void save(@Param("username") String username, @Param("password") String password, @Param("roleId") Integer roleId);

    Role getRole(Integer roleId);
}
