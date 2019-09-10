package courier.domain;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
    private Integer id;
    private String name;

    Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
