package com.company.productsapi.container;

import org.springframework.core.annotation.AliasFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@RestController
@RequestMapping
@CrossOrigin
public @interface CrossSafeRestResource {

    /**
     * The consumable media types of the mapped request, narrowing the primary mapping.
     * <p>The format is a single media type or a sequence of media types,
     * with a request only mapped if the {@code Content-Type} matches one of these media types.
     * Examples:
     * <pre class="code">
     * consumes = "text/plain"
     * consumes = {"text/plain", "application/*"}
     * </pre>
     * Expressions can be negated by using the "!" operator, as in "!text/plain", which matches
     * all requests with a {@code Content-Type} other than "text/plain".
     * <p><b>Supported at the type level as well as at the method level!</b>
     * When used at the type level, all method-level mappings override
     * this consumes restriction.
     * @see MediaType
     * @see javax.servlet.http.HttpServletRequest#getContentType()
     */
    @AliasFor(annotation = RequestMapping.class,attribute = "consumes")
    String[] consumes() default {};


    /**
     * The producible media types of the mapped request, narrowing the primary mapping.
     * <p>The format is a single media type or a sequence of media types,
     * with a request only mapped if the {@code Accept} matches one of these media types.
     * Examples:
     * <pre class="code">
     * produces = "text/plain"
     * produces = {"text/plain", "application/*"}
     * produces = MediaType.APPLICATION_JSON_UTF8_VALUE
     * </pre>
     * <p>It affects the actual content type written, for example to produce a JSON response,
     * {@link MediaType#APPLICATION_JSON_VALUE} should be used.
     * <p>Expressions can be negated by using the "!" operator, as in "!text/plain", which matches
     * all requests with a {@code Accept} other than "text/plain".
     * <p><b>Supported at the type level as well as at the method level!</b>
     * When used at the type level, all method-level mappings override
     * this produces restriction.
     * @see MediaType
     */
    @AliasFor(annotation = RequestMapping.class,attribute = "produces")
    String[] produces() default {MediaType.APPLICATION_JSON_VALUE};


    /**
     * The path mapping URIs (e.g. "/myPath.do").
     * Ant-style path patterns are also supported (e.g. "/myPath/*.do").
     * At the method level, relative paths (e.g. "edit.do") are supported
     * within the primary mapping expressed at the type level.
     * Path mapping URIs may contain placeholders (e.g. "/${connect}").
     * <p><b>Supported at the type level as well as at the method level!</b>
     * When used at the type level, all method-level mappings inherit
     * this primary mapping, narrowing it for a specific handler method.
     * @see org.springframework.web.bind.annotation.ValueConstants#DEFAULT_NONE
     * @since 4.2
     */
    @AliasFor(annotation = RequestMapping.class,attribute = "path")
    String[] path() default {};


    /**
     * The list of allowed origins that be specific origins, e.g.
     * {@code "https://domain1.com"}, or {@code "*"} for all origins.
     * <p>A matched origin is listed in the {@code Access-Control-Allow-Origin}
     * response header of preflight actual CORS requests.
     * <p>By default all origins are allowed.
     * <p><strong>Note:</strong> CORS checks use values from "Forwarded"
     * (<a href="https://tools.ietf.org/html/rfc7239">RFC 7239</a>),
     * "X-Forwarded-Host", "X-Forwarded-Port", and "X-Forwarded-Proto" headers,
     * if present, in order to reflect the client-originated address.
     * Consider using the {@code ForwardedHeaderFilter} in order to choose from a
     * central place whether to extract and use, or to discard such headers.
     * See the Spring Framework reference for more on this filter.
     */
    @AliasFor(annotation = CrossOrigin.class,attribute = "origins")
    String[] crossAllowedOrigins() default {"*"};


    /**
     * The list of request headers that are permitted in actual requests,
     * possibly {@code "*"}  to allow all headers.
     * <p>Allowed headers are listed in the {@code Access-Control-Allow-Headers}
     * response header of preflight requests.
     * <p>A header name is not required to be listed if it is one of:
     * {@code Cache-Control}, {@code Content-Language}, {@code Expires},
     * {@code Last-Modified}, or {@code Pragma} as per the CORS spec.
     * <p>By default all requested headers are allowed.
     */
    @AliasFor(annotation = CrossOrigin.class,attribute = "allowedHeaders")
    String[] crossAllowedHeaders() default {"*"};
}
