package ru.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;
import ru.task.domain.CD;
import ru.task.logic.Decoder;
import ru.task.logic.Encoder;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class XMLService {

    private Decoder decoder;
    private Encoder encoder;
    private File content = new File("src/main/webapp/content/catalog.xml");

    @Autowired
    public void setDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    @Autowired
    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

    public void upload(MultipartFile multipartFile) {
        List<CD> cdList = null;
        File file = null;
        try {
            file = new File("file");
            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
            stream.write(bytes);
            stream.close();
            cdList = decoder.decode(file); //адрес загружаемого файла
            encoder.encode(cdList);
            file.delete();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public List<CD> getCdListFromServer(){
        List<CD> cdList = null;
        try {
            cdList = decoder.decode(content); //адрес файла на сервере
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return  cdList;
    }


    public FileSystemResource getFile(){
        return new FileSystemResource(content);
    }
}


