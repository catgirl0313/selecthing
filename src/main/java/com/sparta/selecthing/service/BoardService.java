package com.sparta.selecthing.service;

import com.sparta.selecthing.repository.CommentRepository;
import com.sparta.selecthing.dto.BoardDto;
import com.sparta.selecthing.dto.BoardRequestDto;
import com.sparta.selecthing.dto.CommentResponseDto;
import com.sparta.selecthing.model.Board;
import com.sparta.selecthing.repository.MemberRepository;
import com.sparta.selecthing.model.Member;
import com.sparta.selecthing.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;

    public BoardService(BoardRepository boardRepository, CommentRepository commentRepository, MemberRepository memberRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
    }

    //글 상세보기
//    @Transactional
//    public BoardDto showDetailedBoard(Long boardId) {
//        Board entity = boardRepository.findById(boardId)
//                .orElseThrow(() -> new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다."));
//        return new BoardDto(entity);
//    }

    //게시글 등록
    @Transactional
    public String createBoard(BoardRequestDto boardRequestDto, Long memberId) {
       Member member_temp = memberRepository.findById(memberId)
               .orElseThrow(() -> new IllegalArgumentException("id 오류"));

        Board board = new Board(boardRequestDto, member_temp);

        boardRepository.save(board);

        return "200 ok";
    }

    @Transactional
    public BoardDto showDetailedBoard(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() ->
                    new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다."));
        List<CommentResponseDto> comments = commentRepository.findAllByBoardIdOrderByCreatedAtDesc(boardId);

        BoardDto boardDto = new BoardDto(board, comments);
        return boardDto;
    }

    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);

    }
}