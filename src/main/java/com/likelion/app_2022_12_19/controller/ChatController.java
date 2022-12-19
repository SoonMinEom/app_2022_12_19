package com.likelion.app_2022_12_19.controller;

import com.likelion.app_2022_12_19.dto.ChatMessage;
import com.likelion.app_2022_12_19.dto.RsData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private List<ChatMessage> chatMessages = new ArrayList<>();


    @AllArgsConstructor
    @Getter
    public static class writeMessageResponse {
        Long id;
    }

    @AllArgsConstructor
    @Getter
    public static class writeMessageRequest {
        String authorName;
        String content;
    }

    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData writeMessage(@RequestBody writeMessageRequest request) {
        ChatMessage message = new ChatMessage(request.authorName, request.content);
        chatMessages.add(message);
        return new RsData<>(
                "S-1",
                "메시지가 작성되었습니다,",
                new writeMessageResponse(message.getId())
        );
    }

    @AllArgsConstructor
    @Getter
    public static class messagesResponse {
        private final List<ChatMessage> messages;
        private long count;
    }

    @GetMapping("/messages")
    @ResponseBody
    public RsData<messagesResponse> messages() {
        return new RsData<>(
                "S-1",
                "성공",
                new messagesResponse(chatMessages, chatMessages.size())
        );
    }
}
