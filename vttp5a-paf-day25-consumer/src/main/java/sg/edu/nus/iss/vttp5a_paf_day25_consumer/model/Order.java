package sg.edu.nus.iss.vttp5a_paf_day25_consumer.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    
    private int id;

    private String fullName;

    private List<OrderDetail> lineItem;
}
