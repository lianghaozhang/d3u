package com.lianghaozhang.utils;

import com.lianghaozhang.anno.MyComponent;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.util.HashMap;
import java.util.Map;

public class BaseClassScan {
    private static final String RESOURCE_PATTERN = "**/*.class";

    public static Map<String, Class<?>> scanMyComponentAnnotation(String basePackage) {
        Map<String, Class<?>> annotationClassMap = new HashMap<>();
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        try {
            String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + ClassUtils.convertClassNameToResourcePath(basePackage) + RESOURCE_PATTERN;
            Resource[] resources = resourcePatternResolver.getResources(pattern);
            MetadataReaderFactory refractory = new CachingMetadataReaderFactory(resourcePatternResolver);
            for (Resource resource : resources) {
//                用于读取类信息
                MetadataReader metadataReader = refractory.getMetadataReader(resource);
                String className = metadataReader.getClassMetadata().getClassName();
                Class<?> clazz = Class.forName(className);
                if(clazz.isAnnotationPresent(MyComponent.class)){
                    MyComponent annotation = clazz.getAnnotation(MyComponent.class);
                    String beanName = annotation.value();
                    if(beanName != null && !beanName.isEmpty()){
                        annotationClassMap.put(beanName, clazz);
                        continue;
                    }

                    annotationClassMap.put(clazz.getSimpleName(), clazz);
                }
            }
        } catch (Exception e) {
        }
        return annotationClassMap;
    }

    public static void main(String[] args) {
        Map<String, Class<?>> annotationClassMap = scanMyComponentAnnotation("com.lianghaozhang.beans");
        System.out.println(annotationClassMap);
    }
}
