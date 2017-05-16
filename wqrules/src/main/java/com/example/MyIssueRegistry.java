package com.example;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;

import java.util.Arrays;
import java.util.List;

/**
 * Created by WangQing on 2017/5/16.
 */

public class MyIssueRegistry extends IssueRegistry {
    @Override
    public List<Issue> getIssues() {
        System.out.println("!!!!!!!!!!!!! ljf MyIssueRegistry lint rules works");
        return Arrays.asList(LoggerUsageDetector.ISSUE);
    }
}
