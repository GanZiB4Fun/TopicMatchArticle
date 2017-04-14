package com.bigwis.util;


import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */
public class HanLPTagsUtil {

    public static String getTags(String text){
        List<Term> termList = IndexTokenizer.segment(text.replaceAll("\\pP|\\pS", ""));
        String result = "";
        for (Term term : termList) {
            if ("".equals(term.toString().trim()))
                continue;
            result += term.toString();
        }
        result = result.replaceAll("(/[a-z]+)"," ").replaceAll("\\s+","|");
        return result;
    }
}