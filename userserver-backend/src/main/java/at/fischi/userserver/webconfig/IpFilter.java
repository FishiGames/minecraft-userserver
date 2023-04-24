package at.fischi.userserver.webconfig;

import at.fischi.userserver.services.ConfigService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class IpFilter extends OncePerRequestFilter {

    private final ConfigService configService;

    public IpFilter(ConfigService configService) {
        this.configService = configService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (configService.getConnectionConfig().getWhitelistedIps().stream().filter(x -> request.getRemoteAddr().startsWith(x)).count() == 0) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }
        filterChain.doFilter(request, response);
    }
}