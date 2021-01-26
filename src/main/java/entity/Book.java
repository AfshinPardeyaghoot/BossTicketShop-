package entity;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private City originCityId;

    @ManyToOne
    private City destinationCityId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


}
