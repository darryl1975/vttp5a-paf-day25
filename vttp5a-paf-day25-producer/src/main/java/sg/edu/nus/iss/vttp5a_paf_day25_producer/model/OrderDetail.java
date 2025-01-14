package sg.edu.nus.iss.vttp5a_paf_day25_producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    private int id;

    private String productName;

    private int price;

    private int quantity;
}
