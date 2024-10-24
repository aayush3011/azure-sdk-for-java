// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automation.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The token type. Must be either PersonalAccessToken or Oauth.
 */
public final class TokenType extends ExpandableStringEnum<TokenType> {
    /**
     * Static value PersonalAccessToken for TokenType.
     */
    public static final TokenType PERSONAL_ACCESS_TOKEN = fromString("PersonalAccessToken");

    /**
     * Static value Oauth for TokenType.
     */
    public static final TokenType OAUTH = fromString("Oauth");

    /**
     * Creates a new instance of TokenType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public TokenType() {
    }

    /**
     * Creates or finds a TokenType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding TokenType.
     */
    public static TokenType fromString(String name) {
        return fromString(name, TokenType.class);
    }

    /**
     * Gets known TokenType values.
     * 
     * @return known TokenType values.
     */
    public static Collection<TokenType> values() {
        return values(TokenType.class);
    }
}
