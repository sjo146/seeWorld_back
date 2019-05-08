package com.seeworld.hl.config;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer
{

    @Value("${cbs.imagesPath}")
    private String mImagesPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        System.out.println("now webappcontroller");
        System.out.println("mImagesPath="+mImagesPath);
        if (mImagesPath.equals("") || mImagesPath.equals("${cbs.imagesPath}"))
        {
            System.out.println("mImagesPath="+mImagesPath);
            String imagesPath = WebAppConfig.class.getClassLoader().getResource("").getPath();
            System.out.println("imagesPath="+imagesPath);
            if (imagesPath.indexOf(".jar") > 0)
            {
                imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
            }
            else if (imagesPath.indexOf("classes") > 0)
            {
                imagesPath = "file:" + imagesPath.substring(0, imagesPath.indexOf("classes"));
            }
            imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/")) + "/images/";
            System.out.println("imagesPath="+imagesPath);
            mImagesPath = imagesPath;
        }
        LoggerFactory.getLogger(WebAppConfig.class).info("imagesPath=" + mImagesPath);
        registry.addResourceHandler("/images/**").addResourceLocations(mImagesPath);
    }
}