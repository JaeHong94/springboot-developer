package me.minjaehong.springbootdeveloper.contorller;

import lombok.RequiredArgsConstructor;
import me.minjaehong.springbootdeveloper.dto.CreateAccessTokenRequest;
import me.minjaehong.springbootdeveloper.dto.CreateAccessTokenResponse;
import me.minjaehong.springbootdeveloper.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenApiController {

  private final TokenService tokenService;

  @PostMapping("/api/token")
  public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken(@RequestBody CreateAccessTokenRequest request) {
    String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());

    return ResponseEntity.status(HttpStatus.CREATED)
            .body(new CreateAccessTokenResponse(newAccessToken));
  }
}
