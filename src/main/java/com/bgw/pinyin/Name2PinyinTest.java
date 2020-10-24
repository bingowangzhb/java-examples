package com.bgw.pinyin;

import com.alibaba.fastjson.JSON;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Name2Pinyin
 *
 * @author zhibin.wang
 * @since 2020/10/20 11:03
 */
public class Name2PinyinTest {

    public static void main(String[] args) throws Exception {
        // convertPinyin();
        List<String> names = parseText();
        names.forEach(name -> System.out.println(convertPinyin(name)));
        List<String> convertNames = names.stream()
                .map(Name2PinyinTest::convertPinyin)
                .collect(Collectors.toList());


        System.out.println(names.size());
        System.out.println(convertNames.size());

        toJson(convertNames);
    }

    private static String convertPinyin(String input) {
        // 创建汉语拼音处理类
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        // 输出设置，大小写，音标方式
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        // HanyuPinyinToneType.WITHOUT_TONE//无声调表示
        // HanyuPinyinToneType.WITH_TONE_MARK//声调符号表示
        // HanyuPinyinToneType.WITH_TONE_NUMBER//声调数字表示

        char[] input_char = input.toCharArray();
        String[] pinyingStr;
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            try {
                pinyingStr = PinyinHelper.toHanyuPinyinStringArray(input_char[i], defaultFormat);
                out.append(pinyingStr[0]);
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        }
        return out.toString();
    }


    private static List<String> parseText() throws Exception {

        String fileName = "names.txt";
        List<String> names = Files.lines(Paths.get(fileName), Charset.defaultCharset())
                .flatMap(line -> Arrays.stream(line.split("\n")))
                .collect(Collectors.toList());

        return names;
    }

    private static void toJson(List<String> names) throws Exception {

        List<Map<String, String>> list = names.stream()
                .map(n -> {
                    Map<String, String> m = new HashMap<>();
                    m.put("loginName", n);
                    return m;
                }).collect(Collectors.toList());

        String file = "jsonNames.json";
        Writer write = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
        write.write(JSON.toJSONString(list));
        write.flush();
        write.close();
    }



}
