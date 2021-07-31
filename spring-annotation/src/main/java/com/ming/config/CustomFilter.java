package com.ming.config;


import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

public class CustomFilter implements TypeFilter {
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取当前类注解的信息
        Resource resource = metadataReader.getResource();

        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        /*Set<String> types = annotationMetadata.getAnnotationTypes();
        Iterator<String> iterator = types.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }*/
        String className = classMetadata.getClassName();
        if(className.contains("Service")){
            return true;
        }



        return false;

    }
}
