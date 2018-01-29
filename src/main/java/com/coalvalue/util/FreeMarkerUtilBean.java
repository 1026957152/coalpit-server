package com.coalvalue.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * Created by yunpxu on 1/6/2015.
 */
@Component
public class FreeMarkerUtilBean {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    public void generateJavaSource(String templateName,
                                    String filePath, Map dataMap) throws Exception {

        Configuration cfg = freeMarkerConfigurer.getConfiguration();
        Template temp = cfg.getTemplate(templateName);
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");

        temp.process(dataMap, out);
        out.flush();
        out.close();
    }
}
