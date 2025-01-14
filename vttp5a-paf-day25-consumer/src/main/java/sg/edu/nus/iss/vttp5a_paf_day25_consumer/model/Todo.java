package sg.edu.nus.iss.vttp5a_paf_day25_consumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    
    private int id;

    private String taskName;
}
