package com.ryzezhao.springcloud.common;
/**
 *
 * Http状态码（随时补充）
 *
 * @author: HeHaoZhao
 * @date: 2020/5/4 17:59
 */
public interface HttpStatusConstant {
    // --- 1xx Informational ---
    /**
     * {100 Continue 继续} (RFC 2616)
     */
    Integer SC_CONTINUE_100 = 100;
    /**
     * {101 Switching Protocols 交换协议} (RFC 2616)
     */
    Integer SC_SWITCHING_PROTOCOLS_101 = 101;
    /**
     * {102 Processing 处理} (WebDAV - RFC 2518)
     */
    Integer SC_PROCESSING_102 = 102;

    // --- 2xx Success ---
    /**
     * {200 OK} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_OK_200 = 200;
    /**
     * {201 Created 创建} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_CREATED_201 = 201;
    /**
     * {202 Accepted 已接受} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_ACCEPTED = 202;
    /**
     * {203 Non Authoritative Information 非授权信息} (RFC 2616)
     */
    Integer SC_NON_AUTHORITATIVE_INFORMATION = 203;
    /**
     * {204 No Content 无内容} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_NO_CONTENT = 204;
    /**
     * {205 Reset Content 重置内容} (RFC 2616)
     */
    Integer SC_RESET_CONTENT = 205;
    /**
     * {206 Partial Content 部分内容} (RFC 2616)
     */
    Integer SC_PARTIAL_CONTENT = 206;
    /**
     * {207 Multi-Status 多状态} (WebDAV - RFC 2518) or {207 Partial Update OK} (draft-ietf-http-v11-spec-rev-01?)
     */
    Integer SC_MULTI_STATUS = 207;

    // --- 3xx Redirection ---
    /**
     * {300 Mutliple Choices 多种选择} (RFC 2616)
     */
    Integer SC_MULTIPLE_CHOICES = 300;
    /**
     * {301 Moved Permanently 永久移动} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_MOVED_PERMANENTLY = 301;
    /**
     * {302 Moved Temporarily 发现}  (Sometimes {@code Found}) (HTTP/1.0 - RFC 1945)
     */
    Integer SC_MOVED_TEMPORARILY = 302;
    /**
     * {303 See Other 查看其它} (RFC 2616)
     */
    Integer SC_SEE_OTHER = 303;
    /**
     * {304 Not Modified 未修改} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_NOT_MODIFIED = 304;
    /**
     * {305 Use Proxy 使用代理} (RFC 2616)
     */
    Integer SC_USE_PROXY = 305;
    /**
     * {307 Temporary Redirect 开关代理} (RFC 2616)
     */
    Integer SC_TEMPORARY_REDIRECT = 307;

    // --- 4xx Client Error ---
    /**
     * {400 Bad Request 错误的请求} (RFC 2616)
     */
    Integer SC_BAD_REQUEST = 400;
    /**
     * {401 Unauthorized 未授权} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_UNAUTHORIZED = 401;
    /**
     * {402 Payment Required 需要付费} (RFC 2616)
     */
    Integer SC_PAYMENT_REQUIRED = 402;
    /**
     * {403 Forbidden 拒绝访问} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_FORBIDDEN_403 = 403;
    /**
     * {404 Not Found 未找到} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_NOT_FOUND_404 = 404;
    /**
     * {405 Method Not Allowed 不允许的方法} (RFC 2616)
     */
    Integer SC_METHOD_NOT_ALLOWED = 405;
    /**
     * {406 Not Acceptable 不可接受} (RFC 2616)
     */
    Integer SC_NOT_ACCEPTABLE = 406;
    /**
     * {407 Proxy Authentication Required 代理服务器需要身份验证} (RFC 2616)
     */
    Integer SC_PROXY_AUTHENTICATION_REQUIRED = 407;
    /**
     * {408 Request Timeout 请求超时} (RFC 2616)
     */
    Integer SC_REQUEST_TIMEOUT = 408;
    /**
     * {409 Conflict 冲突} (RFC 2616)
     */
    Integer SC_CONFLICT = 409;
    /**
     * {410 Gone 完成} (RFC 2616)
     */
    Integer SC_GONE = 410;
    /**
     * {411 Length Required 需要长度} (RFC 2616)
     */
    Integer SC_LENGTH_REQUIRED = 411;
    /**
     * {412 Precondition Failed 前提条件失败}  (RFC 2616)
     */
    Integer SC_PRECONDITION_FAILED = 412;
    /**
     * {413 Request Entity Too Large 负载过大} (RFC 2616)
     */
    Integer SC_REQUEST_TOO_LONG = 413;
    /**
     * {414 Request-URI Too Long 太长} (RFC 2616)
     */
    Integer SC_REQUEST_URI_TOO_LONG = 414;
    /**
     * {415 Unsupported Media Type 不支持的媒体类型} (RFC 2616)
     */
    Integer SC_UNSUPPORTED_MEDIA_TYPE = 415;
    /**
     * {416 Requested Range Not Satisfiable 范围不合适} (RFC 2616)
     */
    Integer SC_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    /**
     * {417 Expectation Failed 预期失败} (RFC 2616)
     */
    Integer SC_EXPECTATION_FAILED = 417;

    // Static constant for a 418 error. {418 Unprocessable Entity} (WebDAV drafts?) or {@code 418 Reauthentication Required} (HTTP/1.1 drafts?)
    // SC_UNPROCESSABLE_ENTITY = 418;   // not used
    /**
     * Static constant for a 419 error. {419 Insufficient Space on Resource} (WebDAV - draft-ietf-webdav-protocol-05?) or {@code 419 Proxy Reauthentication Required} (HTTP/1.1 drafts?)
     */
    Integer SC_INSUFFICIENT_SPACE_ON_RESOURCE = 419;
    /**
     * Static constant for a 420 error. {420 Method Failure} (WebDAV - draft-ietf-webdav-protocol-05?)
     */
    Integer SC_METHOD_FAILURE = 420;
    /**
     * {422 Unprocessable Entity} (WebDAV - RFC 2518)
     */
    Integer SC_UNPROCESSABLE_ENTITY = 422;
    /**
     * {423 Locked} (WebDAV - RFC 2518)
     */
    Integer SC_LOCKED = 423;
    /**
     * {424 Failed Dependency} (WebDAV - RFC 2518)
     */
    Integer SC_FAILED_DEPENDENCY = 424;
    /**
     * {444 No Response 没有响应} (WebDAV - RFC 2518)
     */
    Integer SC_NO_RESPONSE_444 = 444;


    // --- 5xx Server Error ---
    /**
     * {500 Server Error 内部服务器错误} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_INTERNAL_SERVER_ERROR_500 = 500;
    /**
     * {501 Not Implemented 未执行} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_NOT_IMPLEMENTED = 501;
    /**
     * {502 Bad Gateway 错误的网关} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_BAD_GATEWAY = 502;
    /**
     * {503 Service Unavailable 服务不可用} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_SERVICE_UNAVAILABLE = 503;
    /**
     * {504 Gateway Timeout 网关超时} (RFC 2616)
     */
    Integer SC_GATEWAY_TIMEOUT = 504;
    /**
     * {505 HTTP Version Not Supported 不支持HTTP版本} (RFC 2616)
     */
    Integer SC_HTTP_VERSION_NOT_SUPPORTED = 505;
    /**
     * {507 Insufficient Storage 存储空间不足} (WebDAV - RFC 2518)
     */
    Integer SC_INSUFFICIENT_STORAGE = 507;
}
