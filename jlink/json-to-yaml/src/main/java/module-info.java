module utils.jsonToYaml {
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires java.sql; // because of jackson have link issues
}