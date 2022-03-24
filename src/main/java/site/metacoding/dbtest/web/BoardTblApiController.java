package site.metacoding.dbtest.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javassist.compiler.ast.Keyword;
import site.metacoding.dbtest.domain.boardTbl.BoardTbl;
import site.metacoding.dbtest.domain.boardTbl.BoardTblRepository;
import site.metacoding.dbtest.web.dto.ResponseDto;

@RestController
public class BoardTblApiController {

    private BoardTblRepository boardTblRepository;

    public BoardTblApiController(BoardTblRepository boardTblRepository) {
        this.boardTblRepository = boardTblRepository;
    }

    @GetMapping("/api/search")
    public ResponseDto<?> search(@RequestParam(defaultValue = "") String keyword) {
        // 모델은 클라이언트 사이드 렌더링이기 때문에 필요없다,뷰를 끌고갈 필요가 x
        // 물음표를 하면 string , inteager 뭐든 가능하다! 와일드 카드 !

        List<BoardTbl> boards = boardTblRepository.mSearch(keyword);

        return new ResponseDto<>(1, "성공", boards); // 꺽쇄 안은 생략 가능
        // MEssageConverter 발동 - 자바오브젝트를 =JSON으로 변환
    }
}