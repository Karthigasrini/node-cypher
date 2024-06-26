package org.cypher.core.services.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.cypher.api.GrpcAPI.BytesMessage;
import org.cypher.api.GrpcAPI.SpendAuthSigParameters;
import org.cypher.core.Wallet;


@Component
@Slf4j(topic = "API")
public class CreateSpendAuthSigServlet extends RateLimiterServlet {

  @Autowired
  private Wallet wallet;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) {

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    try {
      PostParams params = PostParams.getPostParams(request);
      SpendAuthSigParameters.Builder build = SpendAuthSigParameters.newBuilder();
      JsonFormat.merge(params.getParams(), build);
      BytesMessage result = wallet.createSpendAuthSig(build.build());
      response.getWriter().println(JsonFormat.printToString(result, params.isVisible()));
    } catch (Exception e) {
      Util.processError(e, response);
    }
  }
}
