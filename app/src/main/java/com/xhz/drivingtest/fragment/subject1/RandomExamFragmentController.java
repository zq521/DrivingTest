package com.xhz.drivingtest.fragment.subject1;

import android.databinding.ObservableField;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.xhz.drivingtest.R;
import com.xhz.drivingtest.anim.AnimationListenerAdapter;
import com.xhz.drivingtest.anim.Translate3D;
import com.xhz.drivingtest.databinding.FragmentRandomExamBinding;
import com.xhz.drivingtest.databinding.SingleCoiceLayoutBinding;
import com.xhz.drivingtest.reader.Question;
import com.xhz.drivingtest.reader.QuestionsReadUtil;

import org.xml.sax.SAXException;

import java.util.List;

/**
 * mail：727319870@qq.com
 * Created by ${轩韩子} on 2017/6/22.
 * 13:48
 */

public class RandomExamFragmentController {
    private RandomExamFragment randomExamFragment;
    private FragmentRandomExamBinding binding;
    private ObservableField<String> title = new ObservableField<>("");
    private ObservableField<String> description = new ObservableField<>("");
    private List<Question> questions;
    private Question currentQuestion;
    private SingleCoiceLayoutBinding mSingleCoiceLayoutBinding;


    public RandomExamFragmentController(RandomExamFragment randomExamFragment, FragmentRandomExamBinding binding) {
        this.randomExamFragment = randomExamFragment;
        this.binding = binding;

        try {
            questions = QuestionsReadUtil.read(randomExamFragment.getContext());
            showRandomQuestion();
        } catch (SAXException e) {
            e.printStackTrace();
            Toast.makeText(randomExamFragment.getContext(), "XML Error", Toast.LENGTH_SHORT).show();
        }


    }

    public void btnNavigateToMockExamFragment(View v) {
        randomExamFragment.getView().startAnimation(new Translate3D(0, 90, true, 350, new AnimationListenerAdapter() {
            @Override
            public void onAnimationEnd(Animation animation) {
                MockExamFragment mockExamFragment = new MockExamFragment();
                mockExamFragment.setInitAnimation(new Translate3D(-90, 0, false, 350, null));
                randomExamFragment.getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.examContainer, mockExamFragment)
                        .commit();
                super.onAnimationEnd(animation);
            }
        }));
    }


    public ObservableField<String> getTitle() {
        return title;
    }

    private void showRandomQuestion() {
        description.set("");
        currentQuestion = questions.get((int) (Math.random() * questions.size()));
        title.set(currentQuestion.getTitle());
        String type = currentQuestion.getType();
        if (type.equals("single")) {
            binding.answerContainer.removeAllViews();
            mSingleCoiceLayoutBinding = SingleCoiceLayoutBinding.inflate(LayoutInflater.from(randomExamFragment.getContext()));
            binding.answerContainer.addView(
                    mSingleCoiceLayoutBinding.getRoot());
            mSingleCoiceLayoutBinding.rbA.setText(currentQuestion.getA());
            mSingleCoiceLayoutBinding.rbB.setText(currentQuestion.getB());
            mSingleCoiceLayoutBinding.rbC.setText(currentQuestion.getC());
            mSingleCoiceLayoutBinding.rbD.setText(currentQuestion.getD());

        }
    }

    public void btnNextClickedler(View v) {

        if (currentQuestion.getType().equals("single")) {
            RadioGroup radioGroup = mSingleCoiceLayoutBinding.radioGroup;
            RadioButton radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
            String answer = "";
            if (radioButton == mSingleCoiceLayoutBinding.rbA) {
                answer = "A";
            } else if (radioButton == mSingleCoiceLayoutBinding.rbB) {
                answer = "B";
            } else if (radioButton == mSingleCoiceLayoutBinding.rbC) {
                answer = "C";
            } else if (radioButton == mSingleCoiceLayoutBinding.rbD) {
                answer = "D";
            }
            if (answer.equals(currentQuestion.getAnswer())) {
                Toast.makeText(randomExamFragment.getContext(), "正确", Toast.LENGTH_SHORT).show();
            } else {
                description.set(currentQuestion.getDescription());
            }
        }

    }

    public ObservableField<String> getDescription() {
        return description;
    }
}