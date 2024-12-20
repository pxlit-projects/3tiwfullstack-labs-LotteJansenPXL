package be.pxl.services.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name="notification")
@Data //setters, getters, equals en tostring
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Long id;
    //private String from;
    //private String to;
    //private String subject;
    private String message;
    private String sender;
}
