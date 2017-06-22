package com.xhz.drivingtest.reader;

import android.content.Context;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

/**
 * mail：727319870@qq.com
 * Created by ${轩韩子} on 2017/6/22.
 * 16:36
 */

public class QuestionsReadUtil {

 public    static List<Question> read(Context context) throws SAXException {
        try {
        return new QuestionReader(context.getAssets().open("questions")).getQuestions();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
