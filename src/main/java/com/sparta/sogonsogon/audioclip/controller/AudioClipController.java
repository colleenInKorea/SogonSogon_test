package com.sparta.sogonsogon.audioclip.controller;

import com.sparta.sogonsogon.audioclip.dto.AudioClipRequestDto;
import com.sparta.sogonsogon.audioclip.dto.AudioClipResponseDto;
import com.sparta.sogonsogon.audioclip.service.AudioClipService;
import com.sparta.sogonsogon.dto.StatusResponseDto;
import com.sparta.sogonsogon.security.UserDetailsImpl;
import com.sparta.sogonsogon.util.S3Uploader;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/audioclip")
public class AudioClipController {

    private final AudioClipService audioClipService;
    private final S3Uploader s3Uploader;

    @PostMapping(value = "/uploaded",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "오디오 클립 생성", description = "오디오 클립을 생성 할 수 있습니다. ")
    public StatusResponseDto<AudioClipResponseDto> createdAudioClip(@ModelAttribute AudioClipRequestDto requestDto,
                                                                    @Parameter(hidden = true)
                                                                    @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {

        return audioClipService.createdAudioClip(requestDto, userDetails);
    }

    @PutMapping(value = "/updated/{audioclipId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "오디오 클립 수정", description = "오디오 내부 내용을 전체 수정 할 수 있습니다. ")
    public StatusResponseDto<AudioClipResponseDto> updatedAudioClip(@PathVariable Long audioclipId,
                                                                    @ModelAttribute AudioClipRequestDto requestDto,
                                                                    @Parameter(hidden = true)
                                                                        @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {
        return audioClipService.updateAudioClip(audioclipId, requestDto, userDetails);
    }

    @DeleteMapping("/deleted/{audioclipId}")
    @Operation(summary = "오디오 클립 삭제", description = "오디오클립 전체를 삭제 할 수 있습니다.")
    public StatusResponseDto<String> deleteAudioClip(@PathVariable Long audioclipId, @Parameter(hidden = true) @AuthenticationPrincipal UserDetailsImpl userDetails){
        return audioClipService.deleteAudioClip(audioclipId, userDetails);
    }

    @GetMapping("/{audioclipId}")
    @Operation(summary = "원하는 오디오 클립 상세 조회", description = "오디오 클립 아이디를 가고 상세 조회 합니다. 내가 좋아요 했는지 여부확인 가능합니다.")
    public StatusResponseDto<AudioClipResponseDto> detailsAudipClip(@PathVariable Long audioclipId, @Parameter(hidden = true) @AuthenticationPrincipal UserDetailsImpl userDetails){
        return audioClipService.detailsAudioClip(audioclipId, userDetails);
    }

//    @GetMapping("")
//    @Operation(summary = "오디오 클립 전체 조회 ", description = "오디오앨범에서 전체 클립을 볼 수 있습니다. ")
//    public



}
