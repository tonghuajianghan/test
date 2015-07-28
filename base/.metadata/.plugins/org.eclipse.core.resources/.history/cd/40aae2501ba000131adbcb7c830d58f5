package cn.edu.cust.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.util.CommonUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.util.Assert;

public class MyCasAuthenticationEntryPoint implements AuthenticationEntryPoint,
		InitializingBean {
	// ~ Instance fields
	// ================================================================================================
	private ServiceProperties serviceProperties;

	private String loginUrl;

	// ~ Methods
	// ========================================================================================================

	public void afterPropertiesSet() throws Exception {
		Assert.hasLength(this.loginUrl, "loginUrl must be specified");
		Assert.notNull(this.serviceProperties,
				"serviceProperties must be specified");
		Assert.notNull(this.serviceProperties.getService(),
				"serviceProperties.getService() cannot be null.");
	}

	public final void commence(final HttpServletRequest servletRequest,
			final HttpServletResponse response,
			final AuthenticationException authenticationException)
			throws IOException, ServletException {

		final String urlEncodedService = createServiceUrl(servletRequest,
				response);
		final String redirectUrl = createRedirectUrl(urlEncodedService);

		preCommence(servletRequest, response);

		if("true".equals(servletRequest.getParameter("nonCASLogin"))){
			response.sendRedirect(redirectUrl + "&nonCASLogin=true");
		}else{
			response.sendRedirect(redirectUrl);
		}
	}

	/**
	 * Constructs a new Service Url. The default implementation relies on the
	 * CAS client to do the bulk of the work.
	 * 
	 * @param request
	 *            the HttpServletRequest
	 * @param response
	 *            the HttpServlet Response
	 * @return the constructed service url. CANNOT be NULL.
	 */
	protected String createServiceUrl(final HttpServletRequest request,
			final HttpServletResponse response) {
		return CommonUtils.constructServiceUrl(null, response,
				this.serviceProperties.getService(), null,
				this.serviceProperties.getArtifactParameter(),
				true);
	}

	/**
	 * Constructs the Url for Redirection to the CAS server. Default
	 * implementation relies on the CAS client to do the bulk of the work.
	 * 
	 * @param serviceUrl
	 *            the service url that should be included.
	 * @return the redirect url. CANNOT be NULL.
	 */
	protected String createRedirectUrl(final String serviceUrl) {
		return CommonUtils.constructRedirectUrl(this.loginUrl,
				this.serviceProperties.getServiceParameter(), serviceUrl,
				this.serviceProperties.isSendRenew(), false);
	}

	/**
	 * Template method for you to do your own pre-processing before the redirect
	 * occurs.
	 * 
	 * @param request
	 *            the HttpServletRequest
	 * @param response
	 *            the HttpServletResponse
	 */
	protected void preCommence(final HttpServletRequest request,
			final HttpServletResponse response) {

	}

	/**
	 * The enterprise-wide CAS login URL. Usually something like
	 * <code>https://www.mycompany.com/cas/login</code>.
	 * 
	 * @return the enterprise-wide CAS login URL
	 */
	public final String getLoginUrl() {
		return this.loginUrl;
	}

	public final ServiceProperties getServiceProperties() {
		return this.serviceProperties;
	}

	public final void setLoginUrl(final String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public final void setServiceProperties(
			final ServiceProperties serviceProperties) {
		this.serviceProperties = serviceProperties;
	}

}
