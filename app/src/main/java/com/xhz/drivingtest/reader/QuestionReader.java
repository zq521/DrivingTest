package com.xhz.drivingtest.reader;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * mail：727319870@qq.com
 * Created by ${轩韩子} on 2017/6/21.
 * 16:54
 */

public class QuestionReader {
    private List<Question> mQuestions=new ArrayList<>();
    private Document mDocument;

    public QuestionReader(Context context, int resid) throws SAXException {
         InputStream in=context.getResources().openRawResource(resid);
        parseInputSteam(in);
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public QuestionReader(InputStream in) throws SAXException {
        parseInputSteam(in);

    }
    private void parseInputSteam(InputStream in) throws SAXException {
        try {
            mDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
            NodeList questionNoteList = mDocument.getElementsByTagName("question");
            Node questionNode;
            for (int i = 0; i < questionNoteList.getLength(); i++) {
                questionNode=questionNoteList.item(i);
                NodeList childNodes = questionNode.getChildNodes();
                Node child;
                Map<String,String> childMap=new HashMap<>();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    child=childNodes.item(j);
                    if (!child.getNodeName().equals("#text")){
                        System.out.println(child.getNodeName()+","+child.getTextContent().trim());
                        childMap.put(child.getNodeName(),child.getTextContent().trim());
                    }
                }
                mQuestions.add(new Question(
                        childMap.get("title"),
                        childMap.get("A"),
                        childMap.get("B"),
                        childMap.get("C"),
                        childMap.get("D"),
                        childMap.get("answer"),
                        childMap.get("type"),
                        childMap.get("description")
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public List<Question> getQuestions() {
        return mQuestions;
    }
}
