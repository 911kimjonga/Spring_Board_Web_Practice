package com.ezen.springmvc.web.member;

import com.ezen.springmvc.domain.member.dto.LoginForm;
import com.ezen.springmvc.domain.member.dto.MemberDTO;
import com.ezen.springmvc.domain.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 가입 화면 출력
     *
     * @param model 모델
     * @return 뷰 이름
     */
    @GetMapping("/register")
    public String registerForm(Model model) {
        MemberDTO member = MemberDTO.builder().build();
        model.addAttribute("member", member);
        return "member/register";
    }

    /**
     * 회원 가입 기능
     *
     * @param member             회원 정보
     * @param bindingResult
     * @param redirectAttributes
     * @param model              모델
     * @return 뷰 이름
     */
    @PostMapping("/register")
    public String register(@Validated @ModelAttribute("member") MemberDTO member, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            return "member/register";
        }

        String mem = member.getId();
        if (memberService.getMember(mem) != null) {
            bindingResult.reject("registFail", "이미 등록된 회원 입니다.");
            return "member/register";
        }

        memberService.register(member);
        redirectAttributes.addFlashAttribute("status", true);
        return "redirect:/member/" + member.getId();
    }

    /**
     * 회원 상세 정보 출력
     *
     * @param id    회원 아이디
     * @param model 모델
     * @return 뷰 이름
     */
    @GetMapping("/{id}")
    public String read(@PathVariable("id") String id, Model model) {
        MemberDTO member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "member/read";
    }

    /**
     * 전체 회원 목록 출력
     *
     * @param model 모델
     * @return 뷰 이름
     */
    @GetMapping("/list")
    public String list(Model model) {
        List<MemberDTO> list = memberService.getMemberList();
        model.addAttribute("list", list);
        return "member/list";
    }

    /**
     * 회원 정보 수정 화면 출력
     *
     * @param id    회원 아이디
     * @param model 모델
     * @return 뷰 이름
     */
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable("id") String id, HttpSession session, Model model) {
        MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");

        if(loginMember == null || !loginMember.getId().equals(id)) {
            return "redirect:/";
        }

        MemberDTO member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "member/edit";
    }

	@PostMapping("/{id}/edit")
	public String edit(@ModelAttribute MemberDTO memberDTO, Model model) {
		memberService.editMember(memberDTO);
		return "redirect:/member/"+memberDTO.getId();
	}

    /**
     * 로그인 화면 출력
     *
     * @param model 모델
     * @return 뷰 이름
     */
    @GetMapping("/login")
    public String loginForm(Model model) {
        LoginForm loginForm = LoginForm.builder().build();
        model.addAttribute("loginForm", loginForm);
        return "member/login";
    }

    /**
     * 로그인 기능
     *
     * @param loginForm     로그인 폼 데이터
     * @param bindingResult
     * @param session       세션
     * @return 뷰 이름
     */
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm loginForm, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "member/login";
        }

        MemberDTO loginMember = memberService.isMember(loginForm.getLoginId(), loginForm.getPasswd());

        // 회원이 아닌 경우
        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "member/login";
        }
        // 회원인 경우
        session.setAttribute("loginMember", loginMember);

        return "redirect:/";
    }

    /**
     * 로그 아웃 기능
     *
     * @param session 세션
     * @return 뷰 이름
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션이 있으면 기존 세션 반환, 없으면 생성하지 않고 null 반환
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}





