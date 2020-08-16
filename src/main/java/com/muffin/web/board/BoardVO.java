package com.muffin.web.board;

import com.muffin.web.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardVO {
    private String boardTitle, boardContent, boardRegdate;
    private int viewCnt;
    private User user;
}
