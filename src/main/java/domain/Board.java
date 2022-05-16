package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
    int boardSeq;       //prkey
    String title;
    String category;    //nn
    String content;     //nn
    String userRole;    //nn
    String userSeq;     //nn
    String addDate;     //Default CurrentTimestamp
    String upDate;      //Default on update CurrentTimestamp
}
