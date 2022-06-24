package com.its.board.entity;

import com.its.board.dto.BoardDTO;
import com.its.board.repository.BoardRepository;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
@Table(name = "board_table")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String boardTitle;

    @Column(length = 20)
    private String boardWrite;

    @Column(length = 20)
    private String boardPassword;

    @Column(length = 500)
    private String boardContents;

    @Column
    private int boardHits;


    public static BoardEntity toSaveEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardWrite(boardDTO.getBoardWrite());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);
        return boardEntity;
    }
}
