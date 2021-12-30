package com.xk72.charles.gui.transaction.actions;

import java.awt.*;

/**
 * Created by sunxiaoyang@cmcm.com
 * 2021/12/30 14:40
 */
public class PangleAdText extends Base64DecodeAction {
    private final String text;

    public PangleAdText(String var1) {
        super(null);
        this.text = var1;
    }

    public PangleAdText(String var1, Component var2) {
        super(var2);
        this.text = var1;
    }

    @Override
    protected String getBody() {
        return this.text;
    }
}