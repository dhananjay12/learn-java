package com.mynotes.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;

public class JsonToYaml {
    public static void main(String[] args) {
        if (args.length != 0) {
            System.out.println("No arguments passed!!");
            System.exit(1);
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode nodeTree = objectMapper.readTree(System.in);
            String yaml = new YAMLMapper().writeValueAsString(nodeTree);
            System.out.println();
            System.out.println(yaml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
