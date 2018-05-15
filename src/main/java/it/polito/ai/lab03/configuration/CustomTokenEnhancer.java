package it.polito.ai.lab03.configuration;

import it.polito.ai.lab03.repository.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer extends JwtAccessTokenConverter {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,
                                     OAuth2Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        final Map<String, Object> additionalInfo = new HashMap<String, Object>();

        additionalInfo.put("username", user.getUsername());
        additionalInfo.put("role", user.getRole());

        ((DefaultOAuth2AccessToken) accessToken)
                .setAdditionalInformation(additionalInfo);

        return accessToken;
    }
}
