package ma.ouss.billingservice.entities;

import lombok.*;

@Data @Getter
@Setter @ToString @Builder
public class Customer {
    private Long id;
    private String name;
    private String email;
}
