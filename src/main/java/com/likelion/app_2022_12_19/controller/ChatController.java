package com.likelion.app_2022_12_19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @PostMapping("/writeMessage")
    @ResponseBody
    public String writeMessage() {
        return "메시지가 작성되었습니다.";
    }
}
