package com.wondersgroup.core.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringUtils;

public class XSSFilter implements Filter {

    private Map<Pattern, String> map = new HashMap<Pattern, String>();

    private List<String> ignore = new ArrayList<String>();

    public void init(FilterConfig filterconfig) throws ServletException {
        InputStream is = null;
        Properties props = new Properties();
        String propName = null;
        String propValue = null;
        Pattern p = null;

        try {
            is = XSSFilter.class.getResourceAsStream("/xssfilter.properties");
            props.load(is);
            Enumeration<?> propKeys = props.propertyNames();
            while (propKeys.hasMoreElements()) {
                propName = (String) propKeys.nextElement();
                propValue = props.getProperty(propName);
                p = Pattern.compile(propName, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

                if ("ignore".equals(propName)) {
                    ignore.addAll(Arrays.asList(propValue.split(";")));
                    continue;
                }

                map.put(p, StringUtils.trimToEmpty(propValue));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
    }

    private String cleanXSS(String s) {
        Matcher m = null;
        for (Pattern p : map.keySet()) {
            m = p.matcher(s);
            if (m.find()) {
                s = m.replaceAll(map.get(p));
            }
        }

        return s;
    }

    final class RequestWrapper extends HttpServletRequestWrapper {
        public RequestWrapper(HttpServletRequest servletRequest) {
            super(servletRequest);
        }

        @Override
        public String getHeader(String name) {
            String value = super.getHeader(name);
            return value == null ? null : cleanXSS(value);
        }

        @Override
        public String getParameter(String name) {
            String value = super.getParameter(name);
            return ignore.contains(name) ? value : (value == null ? null : cleanXSS(value));
        }

        @Override
        public String[] getParameterValues(String name) {
            String[] values = super.getParameterValues(name);

            if (ignore.contains(name)) {
                return values;
            }

            if (values == null) {
                return null;
            }

            for (int i = 0; i < values.length; i++) {
                values[i] = cleanXSS(values[i]);
            }

            return values;
        }
    }
}
