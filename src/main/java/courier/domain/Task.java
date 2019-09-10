package courier.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Task {
    private Long id;
    private Long orderId;
    private Date taskDate;
}
