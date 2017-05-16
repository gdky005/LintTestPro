package com.example;

import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.ClassContext;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Arrays;
import java.util.List;

/**
 * 检测项目中是否使用了 android 的 log.
 *
 * Created by WangQing on 2017/5/16.
 */

public class LoggerUsageDetector extends Detector implements Detector.ClassScanner {

    public static final Issue ISSUE = Issue.create("LogUtilsNotUsed",
            "You must use our `LogUtils`",
            "Logging should be avoided in production for security and performance reasons. Therefore, we created a LogUtils that wraps all our calls to Logger and disable them for release flavor.",
            Category.MESSAGES, 9, Severity.ERROR, new Implementation(LoggerUsageDetector.class,
                    Scope.CLASS_FILE_SCOPE));

    @Override
    public List<String> getApplicableCallNames() {
        return Arrays.asList("v", "d", "i", "w", "e", "wtf");
    }

    @Override
    public List<String> getApplicableMethodNames() {
        return Arrays.asList("v", "d", "i", "w", "e", "wtf");
    }

    @Override
    public void checkCall(ClassContext context, ClassNode classNode, MethodNode method, MethodInsnNode call) {


        String owner = call.owner;
        if (owner.startsWith("android/util/Log")) {
            context.report(ISSUE, method, call, context.getLocation(call), "You must use our `LogUtils`");
        }


    }
}
