package com.mentormate.tcos.network.model;

import com.google.gson.annotations.SerializedName;
import com.mentormate.tcos.network.services.DiscoveryService;

import java.util.List;

public class DiscoveryResponseModel {
    @SerializedName("issuer")
    private String issuer;

    @SerializedName("jwks_uri")
    private String jwksURI;

    @SerializedName("authorization_endpoint")
    private String authorizationEndpoint;

    @SerializedName("token_endpoint")
    private String tokenEndpoint;

    @SerializedName("userinfo_endpoint")
    private String userinfoEndpoint;

    @SerializedName("end_session_endpoint")
    private String endSessionEndpoint;

    @SerializedName("check_session_iframe")
    // TODO: 4/15/2016 may be unneeded
    private String checkSessionEndpoint;

    @SerializedName("revocation_endpoint")
    private String revocationEndpoint;
    // TODO: 4/15/2016 the below items may be unneeded
    @SerializedName("scopes_supported")
    private List<String> scopesSupported;

    @SerializedName("claims_supported")
    private List<String> claimsSupported;

    @SerializedName("response_types_supported")
    private List<String> responseTypeSupported;

    @SerializedName("response_modes_supported")
    private List<String> responseModesSupported;

    @SerializedName("grant_types_supported")
    private List<String> grantTypesSupported;

    @SerializedName("subject_types_supported")
    private List<String> subjectTypesSupported;

    @SerializedName("id_token_signing_alg_values_supported")
    private List<String> idTokenAlgValuesSupported;

    @SerializedName("token_endpoint_auth_methods_supported")
    private List<String> tokenEndpointAuthMethodsSupported;


    public DiscoveryResponseModel(String issuer, String jwksURI, String authorizationEndpoint, String tokenEndpoint, String userinfoEndpoint, String endSessionEndpoint, String checkSessionEndpoint, String revocationEndpoint, List<String> scopesSupported, List<String> claimsSupported, List<String> responseTypeSupported, List<String> responseModesSupported, List<String> grantTypesSupported, List<String> subjectTypesSupported, List<String> idTokenAlgValuesSupported, List<String> tokenEndpointAuthMethodsSupported) {
        this.issuer = issuer;
        this.jwksURI = jwksURI;
        this.authorizationEndpoint = authorizationEndpoint;
        this.tokenEndpoint = tokenEndpoint;
        this.userinfoEndpoint = userinfoEndpoint;
        this.endSessionEndpoint = endSessionEndpoint;
        this.checkSessionEndpoint = checkSessionEndpoint;
        this.revocationEndpoint = revocationEndpoint;
        this.scopesSupported = scopesSupported;
        this.claimsSupported = claimsSupported;
        this.responseTypeSupported = responseTypeSupported;
        this.responseModesSupported = responseModesSupported;
        this.grantTypesSupported = grantTypesSupported;
        this.subjectTypesSupported = subjectTypesSupported;
        this.idTokenAlgValuesSupported = idTokenAlgValuesSupported;
        this.tokenEndpointAuthMethodsSupported = tokenEndpointAuthMethodsSupported;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getJwksURI() {
        return jwksURI;
    }

    public String getAuthorizationEndpoint() {
        return authorizationEndpoint;
    }

    public String getTokenEndpoint() {
        return tokenEndpoint;
    }

    public String getUserinfoEndpoint() {
        return userinfoEndpoint;
    }

    public String getEndSessionEndpoint() {
        return endSessionEndpoint;
    }

    public String getCheckSessionEndpoint() {
        return checkSessionEndpoint;
    }

    public String getRevocationEndpoint() {
        return revocationEndpoint;
    }

    public List<String> getScopesSupported() {
        return scopesSupported;
    }

    public List<String> getClaimsSupported() {
        return claimsSupported;
    }

    public List<String> getResponseTypeSupported() {
        return responseTypeSupported;
    }

    public List<String> getResponseModesSupported() {
        return responseModesSupported;
    }

    public List<String> getGrantTypesSupported() {
        return grantTypesSupported;
    }

    public List<String> getSubjectTypesSupported() {
        return subjectTypesSupported;
    }

    public List<String> getIdTokenAlgValuesSupported() {
        return idTokenAlgValuesSupported;
    }

    public List<String> getTokenEndpointAuthMethodsSupported() {
        return tokenEndpointAuthMethodsSupported;
    }
}
