package Microservicios.Spring.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TraceHeaderFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String traceParent = request.getHeader("traceparent");
        String traceState = request.getHeader("tracestate");

        if (traceParent == null || traceParent.isBlank()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Header traceparent is required");
            return;
        }

        if (traceState == null || traceState.isBlank()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Header tracestate is required");
            return;
        }

        filterChain.doFilter(request, response);
    }
    /**
     *
     * Se agrego componente filter
     */
}