package RepositoryMvk;

import Interfaces.IRepositoryMvk;
import Interfaces.IXmlService;
import RepositoryMvk.Data.MvkResponse;
import Service.XmlService;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RepositoryFile implements IRepositoryMvk {

    public RepositoryFile(String fileName) {
        _fileName = fileName;
    }

    private final String _fileName;
    private final IXmlService _xmlService = new XmlService();

    public MvkResponse GetResponse() throws Exception {

        String content = new String(Files.readAllBytes(Paths.get(_fileName)), StandardCharsets.UTF_8);
        return _xmlService.Deserialize(content, MvkResponse.class);
    }
}