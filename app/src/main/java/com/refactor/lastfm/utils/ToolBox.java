package com.refactor.lastfm.utils;

public class ToolBox {

    private ToolBox() {
    }

    public static int compareLongStr(String menorJudgment, String mayorJudgment) {
        if (mayorJudgment.length() > menorJudgment.length())
            return -1;

        if (mayorJudgment.length() < menorJudgment.length())
            return 1;

        long mayorJudgmentL = Long.parseLong(mayorJudgment);
        long menorJudgmentL = Long.parseLong(menorJudgment);
        return Long.compare(menorJudgmentL, mayorJudgmentL);
    }
}
