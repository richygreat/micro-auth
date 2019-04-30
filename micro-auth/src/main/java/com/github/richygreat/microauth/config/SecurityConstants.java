package com.github.richygreat.microauth.config;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SecurityConstants {
	public static final String SIGNING_KEY = "e55a8g5GAocFSfqP7gzbAMlyukZzrQn3e1KRQQbKw6XGWUnMEWZYSwC9yDjZgQt";
	public static final String RESOURCE_ID = "micro";

	public static final String CLIENT_ID = "client";
	public static final String CLIENT_SECRET = "$2a$10$HlzMvb9OQayvlWfX5pzJTeZvH30eKwnc6gE0C3idjDvbQt4XJMTki";// secret
	public static final String GRANT_TYPE_PASSWORD = "password";
	public static final String AUTHORIZATION_CODE = "authorization_code";
	public static final String REFRESH_TOKEN = "refresh_token";
	public static final String IMPLICIT = "implicit";

	public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 3600;
	public static final int REFRESH_TOKEN_VALIDITY_SECONDS = 6 * ACCESS_TOKEN_VALIDITY_SECONDS;

	public static final String SCOPE_READ = "read";
	public static final String SCOPE_WRITE = "write";

	public static final String ROLE_SUPER_ADMIN = "ROLE_SUPER_ADMIN";

	public static final String ROOT_USER = "root";
	public static final String ROOT_USER_TEST_PASSWORD = "password";

	public static final String OAUTH2_HAS_SCOPE_READ = "#oauth2.hasScope('" + SCOPE_READ + "')";
	public static final String OAUTH2_HAS_SCOPE_WRITE = "#oauth2.hasScope('" + SCOPE_WRITE + "')";
}
