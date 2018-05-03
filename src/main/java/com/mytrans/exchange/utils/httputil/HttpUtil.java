package com.mywind.windfarmplan.utils.httputil;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by LiRongJiang on 2017/4/17.
 */
@Component
public class HttpUtil {


    public static String toJsRedirect(String redirectUrl,
                                      String targetIframe,
                                      String basePath,
                                      Map<String, String> params) {
        StringBuffer sb = new StringBuffer();
        sb.append("<script src=\"" + basePath + "lib/jQuery/jquery-3.1.1.js\"></script>");
        sb.append("<script src=\"" + basePath + "lib/layer/layer.js\"></script>");
        sb.append("<script type=\"application/javascript\">");

        sb.append("var targetiframe = window.parent.frames[\"" + targetIframe + "\"];\n");
        //sb.append("targetiframe.location.href  = \"" + basePath + redirectUrl + "?");
        //sb.append("window.location.href  = \"" + basePath +  redirectUrl + "?");
        //sb.append(paramMapToString(params));
        //sb.append("\";");

        sb.append("layer.close(layer.index);");

        sb.append("</script>");
        return sb.toString();
    }

    public static String getBasepath(HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort()+path+"/";
        return basePath;
    }

    private static String paramMapToString(Map<String, String> params) {
        StringBuffer result = new StringBuffer();

        for (Map.Entry<String, String> entry : params.entrySet()) {

            result.append(entry.getKey());
            result.append("=");
            result.append(entry.getValue());
            result.append("&");
        }

        return result.toString();
    }
}
