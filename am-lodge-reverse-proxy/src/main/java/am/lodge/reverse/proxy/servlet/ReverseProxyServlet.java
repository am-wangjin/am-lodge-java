package am.lodge.reverse.proxy.servlet;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by am on 16-10-26.
 */
public class ReverseProxyServlet extends HttpServlet{

  private static String REQUEST_URL = "_request_url_";

  private static String COOKIE_STORE = "cookieStore";

  private CloseableHttpClient client;

  @Override
  public void init(ServletConfig config) throws ServletException{
    client = HttpClientBuilder.create().setDefaultRequestConfig(
        RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES)
            .setRedirectsEnabled(false)
            .build()
    ).build();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    super.doPost(request, response);
    String url = request.getParameter(REQUEST_URL);
    if(StringUtils.isNotBlank(url)){
      HttpClientContext context = HttpClientContext.create();
      CloseableHttpClient client = null;
      CloseableHttpResponse rep = null;
      try{
        rep = client.execute(createRequest(request), context);
        HttpEntity entity = rep.getEntity();
        if(entity != null){
          response.getWriter().write(EntityUtils.toString(entity, "UTF-8"));
        }
      }finally{
        HttpClientUtils.closeQuietly(rep);
        HttpClientUtils.closeQuietly(client);
      }
    }
  }

  private HttpUriRequest newProxyRequest(String method, String proxyRequestUri, HttpServletRequest request)
      throws IOException {
    if (request.getHeader(HttpHeaders.CONTENT_LENGTH) != null ||
        request.getHeader(HttpHeaders.TRANSFER_ENCODING) != null) {

      return RequestBuilder.create(method).setUri(proxyRequestUri).setEntity(
          new InputStreamEntity(request.getInputStream(), getContentLength(request))
      ).build();
    }
    return RequestBuilder.create(method).setUri(proxyRequestUri).build();
  }

  private long getContentLength(HttpServletRequest request) {
    String contentLengthHeader = request.getHeader("Content-Length");
    if (contentLengthHeader != null) {
      return Long.parseLong(contentLengthHeader);
    }
    return -1L;
  }

  private HttpUriRequest createPostRequest(HttpServletRequest request) throws UnsupportedEncodingException{
    String url = request.getParameter(REQUEST_URL);
    List<NameValuePair> list = new ArrayList<NameValuePair>();
    Enumeration emn = request.getParameterNames();
    while(emn.hasMoreElements()){
      String key = (String) emn.nextElement();
      if(REQUEST_URL.equals(key)){
        url = request.getParameter(REQUEST_URL);
        continue;
      }
      String[] values = request.getParameterValues(key);
      for(String value : values){
        list.add(new BasicNameValuePair(key, value));
      }
    }
    HttpPost result = new HttpPost(url);
    result.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
    return result;
  }
}