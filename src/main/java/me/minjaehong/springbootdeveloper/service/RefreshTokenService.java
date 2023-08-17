package me.minjaehong.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.minjaehong.springbootdeveloper.domain.RefreshToken;
import me.minjaehong.springbootdeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

  private final RefreshTokenRepository refreshTokenRepository;

  public RefreshToken findByRefreshToken(String refreshToken) {
    return refreshTokenRepository.findByRefreshToken(refreshToken)
            .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
  }
}
