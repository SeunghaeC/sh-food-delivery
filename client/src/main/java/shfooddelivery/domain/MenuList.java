package shfooddelivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="MenuList_table")
@Data
public class MenuList {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String menuNm;
        private String price;


}
