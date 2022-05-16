package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    int userSeq;        //autoincre prkey
    String userId;      //unique
    String userPassword;//nn
    String userName;    //nn
    String userAddress;
    String userTelno;
    String userEmail;
    String userRole;    //nn
    String userRank;    //nn
    String userComment;
    String category;    //nn
    String addDate;     //Default Current Timestamp
    String upDate;      //Default on update CurrentTimestamp
}
